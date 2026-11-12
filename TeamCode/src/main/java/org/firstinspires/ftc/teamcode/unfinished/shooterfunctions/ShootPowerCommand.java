package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

public class ShootPowerCommand extends CommandBase {
    ShooterSubsystem shooterSubsystem;
    private Gamepad gamepad;

    public void shootPower(ShooterSubsystem shooterSubsystem, Gamepad gamepad){
        this.shooterSubsystem = shooterSubsystem;
        this.gamepad = gamepad;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        if (gamepad.left_stick_y == 1){
            shooterSubsystem.setPower(-1);
        } else if (gamepad.left_stick_y == -1){
            shooterSubsystem.setPower(1);
        } else {
            shooterSubsystem.setPower(0);
        }
    }

    public void end(){
        shooterSubsystem.stop();
    }
}
