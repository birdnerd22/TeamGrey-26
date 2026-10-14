package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.IntakeMechanism;


public class IntakeCommand {
    IntakeMechanism intake = new IntakeMechanism();
    Gamepad gamepad = new Gamepad();

    public void init (HardwareMap hwMap){
        intake.init(hwMap);


    }
    public void execute(IntakeMechanism intakeMechanism, Gamepad gamepad){
        if(gamepad.a){
            intakeMechanism.setPower(1.0);
        } else if (gamepad.b) {
            intakeMechanism.setPower(-1.0);
        } else {
            intakeMechanism.setPower(0.0);
        }
    }

    public void stop(IntakeMechanism intakeMechanism){
        intakeMechanism.setPower(0.0);
    }
}
