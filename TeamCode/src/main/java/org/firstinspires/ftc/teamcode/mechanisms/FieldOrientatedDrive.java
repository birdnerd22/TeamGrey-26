package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "Field Oriented Drive")
public class FieldOrientatedDrive extends LinearOpMode{//can change for command based
    public void runOpMode(){//change name for command based
        DcMotor lf = hardwareMap.get(DcMotor.class, "lf");
        DcMotor lb = hardwareMap.get(DcMotor.class, "lb");
        DcMotor rf = hardwareMap.get(DcMotor.class, "rf");
        DcMotor rb = hardwareMap.get(DcMotor.class, "rb");

        lf.setDirection(DcMotorSimple.Direction.REVERSE);
        lb.setDirection(DcMotorSimple.Direction.REVERSE);

        IMU imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD
        ));
        imu.initialize(parameters);

        waitForStart();

        while(opModeIsActive()){//change as well
            double lx = gamepad1.left_stick_x;
            double ly = gamepad1.left_stick_y;
            double rx = gamepad1.right_stick_x;

            double max = Math.max(Math.abs(lx) + Math.abs(ly)+ Math.abs(rx), 1);

            double power = 0.2 + (0.6 * gamepad1.right_trigger);//right trigger changes power

            double heading = -imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            double adjustedLx = -ly * Math.sin(heading) + lx * Math.cos(heading);
            double adjustedLy = ly * Math.cos(heading) + lx * Math.sin(heading);


            lf.setPower(((adjustedLy + adjustedLx + rx) / max) * power);
            lb.setPower(((adjustedLy - adjustedLx + rx) / max) * power);
            rf.setPower(((adjustedLy - adjustedLx - rx) / max) * power);
            rb.setPower(((adjustedLy + adjustedLx - rx) / max) * power);
        }
    }
}
