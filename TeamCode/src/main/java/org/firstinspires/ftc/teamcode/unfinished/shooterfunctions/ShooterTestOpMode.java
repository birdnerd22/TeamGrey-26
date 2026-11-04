package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class ShooterTestOpMode extends OpMode {

    private ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    private ShootPowerCommand shootPowerCommand;

    @Override
    public void init() {
        shooterSubsystem.init(hardwareMap);
        shootPowerCommand = new ShootPowerCommand();
        shootPowerCommand.shootPower(shooterSubsystem, gamepad1);
    }

    @Override
    public void loop() {
        shootPowerCommand.execute();

    }
}
