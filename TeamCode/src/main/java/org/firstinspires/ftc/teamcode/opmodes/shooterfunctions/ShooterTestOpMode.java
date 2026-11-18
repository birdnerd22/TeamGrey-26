package org.firstinspires.ftc.teamcode.opmodes.shooterfunctions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.ShootPowerCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

@TeleOp
public class ShooterTestOpMode extends OpMode {

    private ShooterSubsystem shooterSubsystem;
    private ShootPowerCommand shootPowerCommand;

    @Override
    public void init() {
        shooterSubsystem = new ShooterSubsystem(hardwareMap);
        shootPowerCommand = new ShootPowerCommand(shooterSubsystem, gamepad1);

    }

    @Override
    public void loop() {
        shootPowerCommand.execute();
        telemetry.addData("RPM", shooterSubsystem.getCurrentRPM());

    }
}
