package org.firstinspires.ftc.teamcode.unfinished;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class TurretMechanismTutorial {

    private DcMotorEx turret;

    private double kP = 0.0001;
    private double kD = 0.0000;
    private double goalX = 0;
    private double lastError = 0;
    private double angleTolerance = 0.2;
    private final double MAX_POWER = 0.6;
    private double power = 0;

    private final ElapsedTime timer = new ElapsedTime();

    public void init(HardwareMap hwMap){
        turret = hwMap.get(DcMotorEx.class, "turret");
        turret.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void setkP(double newkP){
        kP = newkP;
    }
    public double getkP(){
        return kP;
    }
    public void setkD(double newkD){
        kD = newkD;
    }
    public double getkD(){
        return kD;
    }

    public void resetTimer(){
        timer.reset();
    }

    public void update(LLResult llResult){
        double deltaTime = timer.seconds();
        timer.reset();

        if(llResult != null && llResult.isValid()){
            double error = goalX - llResult.getTx();
            double pTerm = error * kP;

            double dTerm = 0;
            if (deltaTime > 0) {
                dTerm = ((error - lastError) / deltaTime) * kD;
            }

            if (Math.abs(error) < angleTolerance){
                power = 0;
            } else {
                power = Range.clip(pTerm + dTerm, -MAX_POWER, MAX_POWER);
            }
            // add safety at some point(encoder check)

            turret.setPower(power);
            lastError = error;
        } else {
            turret.setPower(0);
            lastError = 0;
            return;

        }

    }


}
