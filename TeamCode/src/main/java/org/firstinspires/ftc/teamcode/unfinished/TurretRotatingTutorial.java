package org.firstinspires.ftc.teamcode.unfinished;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Config
@TeleOp(name = "Auto Align Turret PD Tuning")
public class TurretRotatingTutorial extends OpMode {

    private Limelight3A limelight;

    private TurretMechanismTutorial turretMechanism = new TurretMechanismTutorial();

    public static double KP = 0.0001;
    public static double KD = 0.00001;

    @Override
    public void init() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(9);
        turretMechanism.init(hardwareMap);

    }

    @Override
    public void start() {
        super.start();
        turretMechanism.resetTimer();
        limelight.start();
    }

    @Override
    public void loop() {
        turretMechanism.update(limelight.getLatestResult());
        turretMechanism.setkP(KP);
        turretMechanism.setkD(KD);


    }
}
