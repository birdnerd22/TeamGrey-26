package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ShooterTestOpMode extends OpMode {

    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    ShootPowerCommand shootPowerCommand = new ShootPowerCommand();

    @Override
    public void init() {
        shooterSubsystem.init(hardwareMap);
        shootPowerCommand.init(hardwareMap, shooterSubsystem);
    }

    @Override
    public void loop() {
        //shootPowerCommand.execute(gamepad1, shooterSubsystem);
        shooterSubsystem.runToRPM(3000);

    }
}
