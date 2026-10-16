package org.firstinspires.ftc.teamcode.unfinished;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {
        int teamNumber = 20105;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "LEP Team Grey";
        int motorAngle = 90;
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw Closed?", clawClosed);
        telemetry.addData("Name", teamName);
        telemetry.addData("Motor Angle", motorAngle);
    }

    @Override
    public void loop() {

    }
}
