package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoSubsystem extends SubsystemBase {

    private Servo feeder;

    public ServoSubsystem(HardwareMap hwMap){
        feeder = hwMap.get(Servo.class, "feeder");
        feeder.setDirection(Servo.Direction.FORWARD);
    }

    public void setPower(double power){
        feeder.setPosition(0);
    }
}
