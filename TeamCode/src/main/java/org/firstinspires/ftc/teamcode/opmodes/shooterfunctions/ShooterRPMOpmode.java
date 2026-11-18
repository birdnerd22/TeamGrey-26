package org.firstinspires.ftc.teamcode.opmodes.shooterfunctions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.ShooterRPMCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

@TeleOp
public class ShooterRPMOpmode extends OpMode {

    ShooterSubsystem shooterSubsystem;
    ShooterRPMCommand shooterRPMCommand;
    @Override
    public void init() {
        shooterSubsystem = new ShooterSubsystem(hardwareMap);
        shooterRPMCommand.ShootRPM(shooterSubsystem, gamepad1);

    }

    @Override
    public void loop() {
        shooterRPMCommand.execute();

    }
}
