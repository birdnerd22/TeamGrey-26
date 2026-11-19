package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class RobotCentricCommand extends CommandBase {
    DriveSubsystem driveSubsystem;
    Gamepad gamepad;

    public RobotCentricCommand(DriveSubsystem driveSubsystem, Gamepad gamepad){
        this.driveSubsystem = driveSubsystem;
        this.gamepad = gamepad;
        addRequirements(driveSubsystem);
    }

    public void execute(){
        driveSubsystem.setMotors(-gamepad.left_stick_y, gamepad.left_stick_x, gamepad.right_stick_x);

    }

    public void brake (){
        driveSubsystem.brake();
    }

}
