package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.Encoder;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.revhub.localizers.RevHubIMU;
import com.pedropathing.revhub.localizers.ThreeWheelIMUConfig;
import com.pedropathing.revhub.localizers.ThreeWheelIMULocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


public class Constants {
    //add mass somewhere?? no FollowerConstants

    private static RevHubOrientationOnRobot.LogoFacingDirection logoDirection =
            RevHubOrientationOnRobot.LogoFacingDirection.UP;
    private static RevHubOrientationOnRobot.UsbFacingDirection usbDirection =
            RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD;
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("lf");
        c.frontRightName.set("rf");
        c.backLeftName.set("lb");
        c.backRightName.set("rb");
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.manualBrakeMode.set(true);
    });

    /*public static ThreeWheelIMUConfig localizerConfig = new ThreeWheelIMUConfig(c -> {
        c.leftEncoderName.set("lb");
        c.rightEncoderName.set("rf");
        c.strafeEncoderName.set("rb");
        c.imuName.set("imu");
        c.imu.set(new RevHubIMU(new RevHubOrientationOnRobot(logoDirection, usbDirection)));
        c.leftPodY.set(1.7042581224351725);
        c.rightPodY.set(-3.527054990514969);
        c.strafePodX.set(1.5189883134991427);
        c.forwardTicksToInches.set(0.0013252685141740294);
        c.strafeTicksToInches.set(0.0013831258644536654);
        c.turnTicksToRadians.set(0.0012602779681969312);
        c.leftEncoderDirection.set(Encoder.REVERSE);
        c.rightEncoderDirection.set(Encoder.REVERSE);
        c.strafeEncoderDirection.set(Encoder.FORWARD);
    });

     */
  /*  public static ThreeWheelIMUConfig localizerConfig = new ThreeWheelIMUConfig(c -> {
        c.leftEncoderName.set("lb");
        c.rightEncoderName.set("rf");
        c.strafeEncoderName.set("rb");
        c.imuName.set("imu");
        c.imu.set(new RevHubIMU(new RevHubOrientationOnRobot(logoDirection, usbDirection)));
        c.leftPodY.set(1.048033754715752);
        c.rightPodY.set(-3.074605977738281);
        c.strafePodX.set(1.4238165783886636);
        c.forwardTicksToInches.set(0.0011737950604381888);
        c.strafeTicksToInches.set(0.0012583892617449666);
        c.turnTicksToRadians.set(9.709250494302577E-4);
        c.leftEncoderDirection.set(Encoder.REVERSE);
        c.rightEncoderDirection.set(Encoder.REVERSE);
        c.strafeEncoderDirection.set(Encoder.FORWARD);
    });

   */

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(3.122352540023684);
        c.yPodOffset.set(2.3165247759481113);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.7313595647366687);
                Controller secondaryTranslationalForward = Controller.proportional(0.27021781688271385);
                Controller primaryTranslationalLateral = Controller.proportional(0.7548811037785856);
                Controller secondaryTranslationalLateral = Controller.proportional(0.27890839705160364);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.018854522305663868));
                c.brake.set(Controller.proportionalFeedforward(0.016026343959814286));

                c.headingFeedback.set(Controller.proportional(4.71398762145398));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.12453545204453735, 0.001959992827121414));

                c.linearBrakeCoefficients.set(Matrix.diag(0.056030139316841546, 0.021765545731921257));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.00244260251968635, 0.004261547131711949));

                c.maxAchievableForwardVelocity.set(58.37009255266746);
                c.maxAchievableStrafeVelocity.set(56.42986392152581);
                c.naturalForwardDeceleration.set(70.01273016508213);
                c.naturalStrafeDeceleration.set(72.90397916312676);
            }
    );
    public static Follower create(HardwareMap h) {
        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}