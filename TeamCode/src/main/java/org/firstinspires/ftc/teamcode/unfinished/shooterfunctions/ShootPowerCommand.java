package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShootPowerCommand extends CommandBase {
    ShooterSubsystem shooterSubsystem;
    private Gamepad gamepad;

    public void init(HardwareMap hwMap, ShooterSubsystem shooterSubsystem){
        shooterSubsystem.init(hwMap);
    }


    public void execute(Gamepad gamepad, ShooterSubsystem shooterSubsystem) {
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
