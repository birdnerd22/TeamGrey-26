package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoSubsystem extends SubsystemBase {

    private CRServo feeder;

    public ServoSubsystem(HardwareMap hwMap){
        feeder = hwMap.get(CRServo.class, "feeder");
        feeder.setDirection(CRServo.Direction.FORWARD);
    }

    public void setPower(double power){
        feeder.setPower(power);
    }
}
