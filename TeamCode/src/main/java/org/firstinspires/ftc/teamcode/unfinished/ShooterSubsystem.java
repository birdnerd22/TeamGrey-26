package org.firstinspires.ftc.teamcode.unfinished;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class ShooterSubsystem extends SubsystemBase {

    private final DcMotorEx shooter1;
    private final DcMotorEx shooter2;

    private static final double TICKS_PER_REV = 28.0;
    private static final double GEAR_RATIO = 24.0 / 18.0;

    private final PDController pdController;

    public static double kP = 0.0002;
    public static double kD = 0.00001;
    public static double kF = 0.2;

    public ShooterSubsystem(HardwareMap hwMap){
        shooter1 = hwMap.get(DcMotorEx.class, "shooterMotor1");
        shooter2 = hwMap.get(DcMotorEx.class, "shooterMotor2");

        shooter1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        shooter1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooter2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooter1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooter2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        pdController = new PDController(kP, kD);
    }

    public double getCurrentRPM(){
        double ticksPerSec = (shooter2.getVelocity());
        double motorRPM = (ticksPerSec * 60.0) / TICKS_PER_REV;
        return motorRPM * GEAR_RATIO;
    }

    public void stop(){
        shooter1.setPower(0);
        shooter2.setPower(0);
    }

    public void setPower(double power){
        shooter1.setPower(power);
        shooter2.setPower(power);
    }

    public void runToRPM(double targetRPM){
        double currentRPM = getCurrentRPM();

        pdController.setP(kP);
        pdController.setD(kD);

        double correction = pdController.calculate(targetRPM, currentRPM);

        double ff = kF * (targetRPM / 6000.0);
        double power = ff + correction;
        power = Math.max(-1.0, Math.min(1.0, power));

        shooter1.setPower(-power);
        shooter2.setPower(-power);
    }

    public double calculateRPM(double distance) {
        return 9.01121e-8 * Math.pow(distance, 6)
                - 3.92579e-5 * Math.pow(distance, 5)
                + 0.0069767 * Math.pow(distance, 4)
                - 0.642693 * Math.pow(distance, 3)
                + 32.13839 * Math.pow(distance, 2)
                - 815.39232 * distance
                + 10747.4643;
    }

    public void runLimelightShot(double distance){
        runToRPM(calculateRPM(distance));
    }
}
