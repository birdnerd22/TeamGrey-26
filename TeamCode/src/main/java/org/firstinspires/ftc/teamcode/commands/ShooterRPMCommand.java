package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;

public class ShooterRPMCommand extends CommandBase {

    ShooterSubsystem shooterSubsystem;
    private Gamepad gamepad;

    public void ShootRPM(ShooterSubsystem shooterSubsystem, Gamepad gamepad){
        this.shooterSubsystem = shooterSubsystem;
        this.gamepad = gamepad;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        if(gamepad.right_bumper){
            shooterSubsystem.runToRPM(3000);
        } else if(gamepad.right_trigger == 1){
            shooterSubsystem.runToRPM(5000);
        } else{
            shooterSubsystem.stop();
        }
    }

    public void end(){
        shooterSubsystem.stop();
    }
}
