package org.firstinspires.ftc.teamcode.unfinished.shooterfunctions;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PDController;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class ShooterSubsystem extends SubsystemBase {

    private  DcMotorEx shooter1;
    //private final DcMotorEx shooter2;

    private static final double TICKS_PER_REV = 28.0;
    private static final double GEAR_RATIO = 1;

    private  PIDController pidController;

    public static double kD = 0.09;
    public static double kF = 0.9;
    public static double kI = 0.09;
    public static double kP = 0.9;


    public void init(HardwareMap hwMap){
        shooter1 = hwMap.get(DcMotorEx.class, "shooterMotor1");
        //shooter2 = hwMap.get(DcMotorEx.class, "shooterMotor2");

        shooter1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //shooter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        shooter1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //shooter2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooter1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //shooter2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        pidController = new PIDController(kP, kI, kD);
    }

    public double getCurrentRPM(){
        double ticksPerSec = (shooter1.getVelocity());
        double motorRPM = (ticksPerSec * 60.0) / TICKS_PER_REV;
        return motorRPM * GEAR_RATIO;
    }

    public void stop(){
        shooter1.setPower(0);
        //shooter2.setPower(0);
    }

    public void setPower(double power){
        shooter1.setPower(power);
        //shooter2.setPower(power);
    }

    public void runToRPM(double targetRPM){
        double currentRPM = getCurrentRPM();

        pidController.setP(kP);
        pidController.setD(kD);
        pidController.setI(kI);

        double correction = pidController.calculate(targetRPM, currentRPM);

        double ff = kF * (targetRPM / 6000.0);
        double power = ff + correction;
        //power = Math.max(-1.0, Math.min(1.0, power));
        power = Range.clip(power, -1.0, 1);

        shooter1.setPower(-power);
        //shooter2.setPower(-power);
    }

   /* public double calculateRPM(double distance) {
     interpolation, use desmos and values to make an equation or smth
    }

    */


}
