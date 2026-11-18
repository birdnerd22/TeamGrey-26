package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.RobotCentricCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
@TeleOp
@Disabled
public class IntakeDrive extends OpMode {

    IntakeCommand intake;
    IntakeSubsystem intakeSubsystem;

    DriveSubsystem driveSubsystem;
    RobotCentricCommand drive;

    @Override
    public void init() {
        IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hardwareMap);
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);
        drive = new RobotCentricCommand(driveSubsystem, gamepad1);
        intake = new IntakeCommand(intakeSubsystem, gamepad1);


    }

    @Override
    public void loop() {
        intake.execute(intakeSubsystem, gamepad1);
        drive.execute(driveSubsystem, gamepad1);

        if(gamepad1.x){
            drive.brake(driveSubsystem);
        }


    }
}
