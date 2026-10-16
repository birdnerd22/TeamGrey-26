package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.mechanisms.DriveMechanism;

@TeleOp
public class DriveOpmode extends OpMode {

    DriveMechanism driveMechanism = new DriveMechanism();
    DriveCommand driveCommand = new DriveCommand();

    @Override
    public void init() {
        driveMechanism.init(hardwareMap);
        driveCommand.init(hardwareMap);

    }

    @Override
    public void loop() {
        driveCommand.execute(driveMechanism, gamepad1);

    }
}
