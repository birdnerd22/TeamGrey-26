package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.RobotCentricCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
@Disabled
public class DriveOpmode extends OpMode {

    DriveSubsystem driveSubsystem;
    RobotCentricCommand driveCommand;

    @Override
    public void init() {
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);
        driveCommand = new RobotCentricCommand(driveSubsystem, gamepad1);

    }

    @Override
    public void loop() {
        driveCommand.execute();

    }
}
