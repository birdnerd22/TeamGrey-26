package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
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

    public void execute(DriveSubsystem driveSubsystem, Gamepad gamepad){
        driveSubsystem.setMotors(gamepad.left_stick_x, gamepad.left_stick_y, gamepad.right_stick_x);

    }

    public void brake (DriveSubsystem driveSubsystem){
        driveSubsystem.brake();
    }

    public void driveWithValues(DriveSubsystem driveSubsystem, double x, double y, double rotate){
        driveSubsystem.setMotors(x, y, rotate);
    }
}
