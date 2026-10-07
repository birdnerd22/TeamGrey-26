package pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.Encoder;
import com.pedropathing.revhub.localizers.RevHubIMU;
import com.pedropathing.revhub.localizers.ThreeWheelIMUConfig;
import com.pedropathing.revhub.localizers.ThreeWheelIMULocalizer;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


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
    public static ThreeWheelIMUConfig localizerConfig = new ThreeWheelIMUConfig(c -> {
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

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(1.3079404203174625);
                Controller secondaryTranslationalForward = Controller.proportional(0.48324903649560996);
                Controller primaryTranslationalLateral = Controller.proportional(1.662873421501485);
                Controller secondaryTranslationalLateral = Controller.proportional(0.6143872964486458);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.02979060505577004));
                c.brake.set(Controller.proportionalFeedforward(0.025322014297404532));

                c.headingFeedback.set(Controller.proportional(5.052767117094189));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.10624988738171268, 0.00392137071876278));

                c.linearBrakeCoefficients.set(Matrix.diag(0.10043699458733091, 0.06467420160509199));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.003133154126843664, 0.0031627486771072895));

                c.maxAchievableForwardVelocity.set(30.847424416600916);
                c.maxAchievableStrafeVelocity.set(7.0130366003987605);
                c.naturalForwardDeceleration.set(38.330366783927204);
                c.naturalStrafeDeceleration.set(65.93513474525282);
            }
    );
    public static Follower create(HardwareMap h) {
        return new Follower(
                new ThreeWheelIMULocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}