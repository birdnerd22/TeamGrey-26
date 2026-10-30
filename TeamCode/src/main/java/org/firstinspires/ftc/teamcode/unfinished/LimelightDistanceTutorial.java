package org.firstinspires.ftc.teamcode.unfinished;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class LimelightDistanceTutorial extends OpMode {

    private Limelight3A limelight;

    private final double CAMERA_HEIGHT_CM = 18.0;//get from fusion
    private final double CAMERA_ANGLE = 35;//get from fusion
    private final double GOAL_HEIGHT = 135.9;//measure to be sure

    private double distance = 0;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(9);

    }

    @Override
    public void start() {
        limelight.start();
    }

    public double getDistance(double ty){
        double angleToTarget = CAMERA_ANGLE + ty;
        double heightDifference = GOAL_HEIGHT - CAMERA_HEIGHT_CM;

        return heightDifference / Math.tan(Math.toRadians(angleToTarget));
    }

    @Override
    public void loop() {
        LLResult llResult = limelight.getLatestResult();

        if(llResult != null && llResult.isValid()){
            distance = getDistance(llResult.getTy());
            telemetry.addData("Distance", distance);
        } else {
            telemetry.addLine("No valid target found");
        }

    }
}
