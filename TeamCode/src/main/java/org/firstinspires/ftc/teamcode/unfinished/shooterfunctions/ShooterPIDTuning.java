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
    public static double kP = 0.002;
    public static double kD = 0.0001;
    public static double kF = 0.2;

    private ShooterSubsystem shooter;

    @Override
    public void init() {
        shooter = new ShooterSubsystem(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

    }

    @Override
    public void loop() {
        ShooterSubsystem.kP = kP;
        ShooterSubsystem.kD = kD;
        ShooterSubsystem.kF = kF;

        shooter.runToRPM(TARGET_RPM);

        telemetry.addData("Target RPM", TARGET_RPM);
        telemetry.addData("Current RPM", shooter.getCurrentRPM());
        telemetry.addData("kP", kP);
        telemetry.addData("kD", kD);
        telemetry.addData("kF", kF);
        telemetry.update();

    }
}
