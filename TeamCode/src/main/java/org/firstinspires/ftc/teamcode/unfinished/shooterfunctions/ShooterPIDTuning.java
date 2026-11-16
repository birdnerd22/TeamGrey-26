package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Config
@TeleOp
public class ShooterPIDTuning extends OpMode {

    // -------- Dashboard tuning variables -------------
    public static double TARGET_RPM = 3000;
    public static double kD = 0.09;
    public static double kF = 0.9;
    public static double kI = 0.09;
    public static double kP = 0.9;


    private ShooterSubsystem shooter = new ShooterSubsystem();

    @Override
    public void init() {
        shooter.init(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

    }

    @Override
    public void loop() {
        ShooterSubsystem.kP = kP;
        ShooterSubsystem.kD = kD;
        ShooterSubsystem.kF = kF;
        ShooterSubsystem.kI = kI;

        if(gamepad1.left_bumper){
            shooter.runToRPM(TARGET_RPM);
        }
        else if (!gamepad1.left_bumper) {
            shooter.setPower(0);
        }

        telemetry.addData("Target RPM", TARGET_RPM);
        telemetry.addData("Current RPM", shooter.getCurrentRPM());
        telemetry.addData("kP", kP);
        telemetry.addData("kD", kD);
        telemetry.addData("kF", kF);
        telemetry.addData("kI", kI);
        telemetry.update();

    }
}
