package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;


public class IntakeCommand extends CommandBase{
    IntakeSubsystem intake = new IntakeSubsystem();
    Gamepad gamepad = new Gamepad();

    public void init (HardwareMap hwMap){
        intake.init(hwMap);


    }
    public void execute(IntakeSubsystem intakeSubsystem, Gamepad gamepad){
        if(gamepad.a){
            intakeSubsystem.setPower(1.0);
        } else if (gamepad.b) {
            intakeSubsystem.setPower(-1.0);
        } else {
            intakeSubsystem.setPower(0.0);
        }
    }

    public void stop(IntakeSubsystem intakeSubsystem){
        intakeSubsystem.setPower(0.0);
    }
}
