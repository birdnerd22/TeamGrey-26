package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.IntakeMechanism;

@TeleOp
public class IntakeOpMode extends OpMode {

    IntakeMechanism intake = new IntakeMechanism();


    @Override
    public void init() {
        intake.init(hardwareMap);


    }

    @Override
    public void loop() {
        if(gamepad1.a){
            intake.setPower(1.0);
        } else if (gamepad1.b){
            intake.setPower(-1.0);
        } else {
            intake.setPower(0.0);
        }

    }
}