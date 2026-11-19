package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DriveSubsystem extends SubsystemBase {
    private DcMotor lf, lb, rf, rb;
    //private IMU imu;
    private GoBildaPinpointDriver pinpoint;



    public DriveSubsystem(HardwareMap hwMap) {
        lf = hwMap.get(DcMotor.class, "lf");
        lb = hwMap.get(DcMotor.class, "lb");
        rf = hwMap.get(DcMotor.class, "rf");
        rb = hwMap.get(DcMotor.class, "rb");


        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);

        pinpoint = hwMap.get(GoBildaPinpointDriver.class, "pinpoint");
        pinpoint.setOffsets(3.122352540023684, 2.3165247759481113, DistanceUnit.INCH);
        pinpoint.resetPosAndIMU();



        /*imu = hwMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        ));
        imu.initialize(parameters);

         */




    }
    public void setMotors(double y, double x, double rx){
        pinpoint.update();

        double heading = pinpoint.getHeading(AngleUnit.RADIANS);
        //cubic scaling for smooth low-speed control
        x = Math.pow(x, 3);
        y = Math.pow(y, 3);
        rx = Math.pow(rx, 3);

        double adjustedX = x * Math.cos(-heading) - y * Math.sin(-heading);
        double adjustedY = x * Math.sin(-heading) + y * Math.cos(-heading);

        double lfPower = adjustedX + adjustedY + rx;
        double lbPower = adjustedX - adjustedY + rx;
        double rfPower = adjustedX - adjustedY - rx;
        double rbPower = adjustedX + adjustedY - rx;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(lfPower));
        maxPower = Math.max(maxPower, Math.abs(lbPower));
        maxPower = Math.max(maxPower, Math.abs(rfPower));
        maxPower = Math.max(maxPower, Math.abs(rbPower));

        lf.setPower(maxSpeed *(lfPower / maxPower));
        lb.setPower(maxSpeed *(lbPower / maxPower));
        rf.setPower(maxSpeed *(rfPower / maxPower));
        rb.setPower(maxSpeed *(rbPower / maxPower));

    }

    public void brake(){
        lf.setPower(0.0);
        lb.setPower(0.0);
        rf.setPower(0.0);
        rb.setPower(0.0);
    }
}


