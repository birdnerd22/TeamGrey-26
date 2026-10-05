package pedro;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.revhub.localizers.ThreeWheelIMULocalizer;
import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;
import com.qualcomm.robotcore.hardware.HardwareMap;

import pedro.procedures.ForesightTuner;
import pedro.procedures.MecanumTuner;
import pedro.procedures.Tests;
import pedro.procedures.ThreeWheelIMUTuner;
import pedro.procedures.ThreeWheelTuner;


public class Tuning {
    // Tuners go here
    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    }




    @Tuner
    public static Procedure tests() {
        return new Tests(hardwareMap -> new Mecanum(hardwareMap, Constants.drivetrainConfig), (hardwareMap -> new ThreeWheelIMULocalizer(hardwareMap, Constants.localizerConfig)), null);
    }


    @Tuner
    public static Procedure threeWheelIMUTuner() {
        return new ThreeWheelIMUTuner();
    }
    @Tuner
    public static Procedure foresightTuner() {
        return new ForesightTuner((hardwareMap) -> new ThreeWheelIMULocalizer(hardwareMap, Constants.localizerConfig), (hardwareMap) -> new Mecanum(hardwareMap, Constants.drivetrainConfig));
    }
}

