package org.firstinspires.ftc.teamcode.unfinished;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PDController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Config
@TeleOp(name = "PIDF tuning dashboard")
public class PIDTesting extends OpMode {
    //dashboard tuning values
    public static double kP = 0.0;
    public static double kD = 0.0;
    public static double kF = 0.0;
    public static double targetRPM = 3000;

    private DcMotorEx shooterMotor;

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
