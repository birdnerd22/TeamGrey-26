package org.firstinspires.ftc.teamcode.unfinished;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
@Disabled
public class AprilTagAutoAlign extends OpMode {

    private Limelight3A limelight;
     DriveSubsystem driveSubsystem = new DriveSubsystem();

    // ------------------PD Controller -----------------------
    public static double kP = 0.002;
    double error = 0;
    double lastError = 0;
    double goalX = 0;
    double angleTolerance = 0.2;
    public static double kD = 0.0001;
    double curTime = 0;
    double lastTime = 0;

    // --------------------- drive setup --------------------
    double forward, strafe, rotate;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        driveSubsystem.init(hardwareMap);
        limelight.pipelineSwitch(9);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

    }

    @Override
    public void start() {
        super.start();
        resetRuntime();
        curTime = getRuntime();
        limelight.start();

    }

    @Override
    public void loop() {
        // --------------- drive inputs -----------------

        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        LLResult llResult = limelight.getLatestResult();

        // ---------------- auto rotation ------------------
        if (gamepad1.left_trigger > 0.3){
            if(llResult != null && llResult.isValid()){
                error = goalX - llResult.getTx();

                if (Math.abs(error) < angleTolerance){
                    rotate = 0;
                } else {
                    double pTerm = error * kP;

                    curTime = getRuntime();
                    double dT = curTime - lastTime;
                    double dTerm = ((error - lastError) / dT) * kD;

                    rotate = Range.clip(pTerm + dTerm, -0.4, 0.4);

                    lastError = error;
                    lastTime = curTime;
                }
            } else {
                lastTime = getRuntime();
                lastError = 0;
            }

        }else{
            lastError = 0;
            lastTime = getRuntime();
        }

        driveSubsystem.drive(strafe, forward, rotate);

        telemetry.addData("kP", kP);
        telemetry.addData("kD", kD);

    }
}
