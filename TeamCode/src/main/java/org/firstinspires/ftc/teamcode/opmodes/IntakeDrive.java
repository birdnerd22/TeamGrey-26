package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.mechanisms.IntakeMechanism;
import org.firstinspires.ftc.teamcode.mechanisms.DriveMechanism;
@TeleOp
public class IntakeDrive extends OpMode {

    IntakeCommand intake = new IntakeCommand();
    IntakeMechanism intakeMechanism = new IntakeMechanism();
    DriveMechanism driveMechanism = new DriveMechanism();
    DriveCommand drive = new DriveCommand();

    @Override
    public void init() {
        intake.init(hardwareMap);
        intakeMechanism.init(hardwareMap);
        driveMechanism.init(hardwareMap);
        drive.init(hardwareMap);


    }

    @Override
    public void loop() {
        intake.execute(intakeMechanism, gamepad1);
        drive.execute(driveMechanism, gamepad1);

        if(gamepad1.x){
            drive.brake(driveMechanism);
        }


    }
}
