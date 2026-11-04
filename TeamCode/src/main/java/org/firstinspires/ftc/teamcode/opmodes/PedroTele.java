package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.commands.FieldCentricPedro;

public class PedroTele extends OpMode {

    FieldCentricPedro fieldCentricPedro;

    @Override
    public void init() {
        fieldCentricPedro.init(hardwareMap);
    }

    @Override
    public void start() {
        fieldCentricPedro.start();

    }

    @Override
    public void loop() {
        fieldCentricPedro.execute(gamepad1);
        if(gamepad1.x){
            fieldCentricPedro.resetPose();
        }

    }
}
