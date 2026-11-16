package org.firstinspires.ftc.teamcode.opmodes;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.FieldCentricPedro;
@TeleOp
public class PedroTele extends OpMode {

    FieldCentricPedro fieldCentricPedro;
    private Follower follower;

    @Override
    public void init() {


    }

    @Override
    public void start() {
        fieldCentricPedro.start(follower, hardwareMap);

    }

    @Override
    public void loop() {
        fieldCentricPedro.execute(gamepad1);
        if(gamepad1.x){
            fieldCentricPedro.resetPose();
        }

    }
}
