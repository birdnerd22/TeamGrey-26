package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ShooterRPMOpmode extends OpMode {

    ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    ShooterRPMCommand shooterRPMCommand;
    @Override
    public void init() {
        shooterSubsystem.init(hardwareMap);
        shooterRPMCommand.ShootRPM(shooterSubsystem, gamepad1);

    }

    @Override
    public void loop() {
        shooterRPMCommand.execute();

    }
}
