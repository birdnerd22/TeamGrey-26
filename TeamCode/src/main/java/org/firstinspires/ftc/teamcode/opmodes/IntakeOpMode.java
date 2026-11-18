package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
@Disabled
@TeleOp
public class IntakeOpMode extends OpMode {
    IntakeSubsystem intakeSubsystem;

    IntakeCommand intakeCommand;



    @Override
    public void init() {
        IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hardwareMap);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad1);


    }

    @Override
    public void loop() {
       intakeCommand.execute(intakeSubsystem, gamepad1);

    }
}