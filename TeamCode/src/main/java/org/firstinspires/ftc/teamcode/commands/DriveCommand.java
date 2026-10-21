package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.DriveMechanism;

public class DriveCommand {

    DriveMechanism drive = new DriveMechanism();
    public void init(HardwareMap hwMap){
        drive.init(hwMap);


    }

    public void execute(DriveMechanism driveMechanism, Gamepad gamepad){
        driveMechanism.drive(gamepad.left_stick_x, gamepad.left_stick_y, gamepad.right_stick_x);

    }

    public void brake (DriveMechanism driveMechanism){
        driveMechanism.brake();
    }

    public void driveWithValues(DriveMechanism driveMechanism, double x, double y, double rotate){
        driveMechanism.drive(x, y, rotate);
    }
}
