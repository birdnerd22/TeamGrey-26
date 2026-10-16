package org.firstinspires.ftc.teamcode.unfinished;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Disabled
@Autonomous
public class HelloWorld extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Hello", "Julia");

    }

    @Override
    public void loop() {

    }
}
