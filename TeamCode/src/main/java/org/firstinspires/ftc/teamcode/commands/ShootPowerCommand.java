package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class ShootPowerCommand extends CommandBase {
    ShooterSubsystem shooterSubsystem;

    private Gamepad gamepad;

    public ShootPowerCommand(ShooterSubsystem shooterSubsystem, Gamepad gamepad){
        this.shooterSubsystem = shooterSubsystem;
        this.gamepad = gamepad;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        if (gamepad.right_bumper && !gamepad.left_bumper){
            shooterSubsystem.setPower(-1);
        } else if (gamepad.left_bumper && !gamepad.right_bumper){
            shooterSubsystem.setPower(1);
        } else {
            shooterSubsystem.setPower(0);
        }

    }

    public void end(){
        shooterSubsystem.stop();
    }
}
