package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.RobotCentricCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
@TeleOp
public class IntakeDrive extends OpMode {

    IntakeCommand intake = new IntakeCommand();
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    DriveSubsystem driveSubsystem = new DriveSubsystem();
    RobotCentricCommand drive = new RobotCentricCommand();

    @Override
    public void init() {
        intake.init(hardwareMap);
        intakeSubsystem.init(hardwareMap);
        driveSubsystem.init(hardwareMap);
        drive.init(hardwareMap);


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
