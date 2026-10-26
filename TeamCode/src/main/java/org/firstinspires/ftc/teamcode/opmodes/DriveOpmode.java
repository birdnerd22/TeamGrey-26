package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.RobotCentricCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class DriveOpmode extends OpMode {

    DriveSubsystem driveSubsystem = new DriveSubsystem();
    RobotCentricCommand driveCommand = new RobotCentricCommand();

    @Override
    public void init() {
        driveSubsystem.init(hardwareMap);
        driveCommand.init(hardwareMap);

    }

    @Override
    public void loop() {
        driveCommand.execute(driveSubsystem, gamepad1);

    }
}
