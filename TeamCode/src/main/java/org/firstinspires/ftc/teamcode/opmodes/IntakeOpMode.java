package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

@TeleOp
public class IntakeOpMode extends OpMode {

    IntakeCommand intake = new IntakeCommand();
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();


    @Override
    public void init() {
        intake.init(hardwareMap);


    }

    @Override
    public void loop() {
       intake.execute(intakeSubsystem, gamepad1);

    }
}