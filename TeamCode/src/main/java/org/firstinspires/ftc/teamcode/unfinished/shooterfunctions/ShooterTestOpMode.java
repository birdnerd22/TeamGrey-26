package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class ShooterTestOpMode extends OpMode {

    private ShooterSubsystem shooterSubsystem;
    private ShootPowerCommand shootPowerCommand;

    @Override
    public void init() {
        shooterSubsystem = new ShooterSubsystem(hardwareMap);
        shootPowerCommand = new ShootPowerCommand();
        shootPowerCommand.shootPower(shooterSubsystem, gamepad1);
    }

    @Override
    public void loop() {
        shootPowerCommand.execute();

    }
}
