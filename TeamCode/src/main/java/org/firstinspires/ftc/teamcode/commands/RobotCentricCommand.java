package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class RobotCentricCommand extends CommandBase {

    DriveSubsystem drive = new DriveSubsystem();
    public void init(HardwareMap hwMap){
        drive.init(hwMap);

    }

    public void execute(DriveSubsystem driveSubsystem, Gamepad gamepad){
        driveSubsystem.drive(gamepad.left_stick_x, gamepad.left_stick_y, gamepad.right_stick_x);

    }

    public void brake (DriveSubsystem driveSubsystem){
        driveSubsystem.brake();
    }

    public void driveWithValues(DriveSubsystem driveSubsystem, double x, double y, double rotate){
        driveSubsystem.drive(x, y, rotate);
    }
}
