package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.ServoSubsystem;

public class ServoOpmode extends OpMode {
    ServoSubsystem servoSubsystem;
    @Override
    public void init() {
        servoSubsystem = new ServoSubsystem(hardwareMap);

    }

    @Override
    public void loop() {
        if(gamepad1.a){
            servoSubsystem.setPower(1);
        } else{
            servoSubsystem.setPower(0);
        }

    }
}
