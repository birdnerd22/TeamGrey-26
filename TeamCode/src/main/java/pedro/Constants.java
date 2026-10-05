package pedro;

import com.pedropathing.follower.Follower;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.Encoder;
import com.pedropathing.revhub.localizers.RevHubIMU;
import com.pedropathing.revhub.localizers.ThreeWheelIMUConfig;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Constants {
    //add mass somewhere?? no FollowerConstants
    public static Follower create(HardwareMap h) {
         //return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }
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
}