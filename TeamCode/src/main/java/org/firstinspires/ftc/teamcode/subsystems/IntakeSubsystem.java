package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem extends SubsystemBase {

    private DcMotorEx intakeMotor;

    public void init(HardwareMap hwMap){
        intakeMotor = hwMap.get(DcMotorEx.class, "intake");
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);

    }
    public void setPower(double power){
        intakeMotor.setPower(power);
    }
}
