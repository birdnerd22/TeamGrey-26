package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Odom Encoder Test")
public class OdomPodTest extends LinearOpMode {

    @Override
    public void runOpMode() {

        // Port 3 = Right odom
        DcMotor rightOdom = hardwareMap.get(DcMotor.class, "rf");

        // Port 1 = Perpendicular odom
        DcMotor perpOdom = hardwareMap.get(DcMotor.class, "rb");

        // Port 0 = Left odom
        DcMotor leftOdom = hardwareMap.get(DcMotor.class, "lb");

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("Right", rightOdom.getCurrentPosition());
            telemetry.addData("Perp", perpOdom.getCurrentPosition());
            telemetry.addData("Left", leftOdom.getCurrentPosition());

            telemetry.update();
        }
    }
}
