package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

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
        if(gamepad.a){
            shooterSubsystem.runToRPM(3000);
        } else if(gamepad.b){
            shooterSubsystem.runToRPM(5000);
        } else{
            shooterSubsystem.stop();
        }
    }

    public void end(){
        shooterSubsystem.stop();
    }
}
