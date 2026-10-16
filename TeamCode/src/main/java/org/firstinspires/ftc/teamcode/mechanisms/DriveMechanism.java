package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class DriveMechanism {
    private DcMotor lf, lb, rf, rb;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        lf = hwMap.get(DcMotor.class, "lf");
        lb = hwMap.get(DcMotor.class, "lb");
        rf = hwMap.get(DcMotor.class, "rf");
        rb = hwMap.get(DcMotor.class, "rb");

        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = hwMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD
        ));
        imu.initialize(parameters);


    }
    public void drive(double x, double y, double rx, double trigger){//change as well

        double max = Math.max(Math.abs(x) + Math.abs(y)+ Math.abs(rx), 1);

        double power = 0.2 + (0.6 * trigger);//right trigger changes power

        double heading = -imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        //cubic scaling for smooth low-speed control
        x = Math.pow(x, 3);
        y = Math.pow(y, 3);
        rx = Math.pow(rx, 3);

        double adjustedLx = -y * Math.sin(heading) + x * Math.cos(heading);
        double adjustedLy = y * Math.cos(heading) + x * Math.sin(heading);


        lf.setPower(((adjustedLy + adjustedLx + rx) / max) * power);
        lb.setPower(((adjustedLy - adjustedLx + rx) / max) * power);
        rf.setPower(((adjustedLy - adjustedLx - rx) / max) * power);
        rb.setPower(((adjustedLy + adjustedLx - rx) / max) * power);
    }

    public void brake(){
        lf.setPower(0.0);
        lb.setPower(0.0);
        rf.setPower(0.0);
        rb.setPower(0.0);
    }
}


