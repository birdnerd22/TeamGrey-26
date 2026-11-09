package org.firstinspires.ftc.teamcode.commands;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.CommandBase;
import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.opmodes.OpModePoseStorage;
import org.firstinspires.ftc.teamcode.pedro.Constants;

public class FieldCentricPedro extends CommandBase {

    private Follower follower;

    public void init(HardwareMap hwMap){
        follower = Constants.create(hwMap);

    }

    public void start(){
        follower.setPose(OpModePoseStorage.autonomousEndPose);
        follower.update();
        // Add this in Opmode public void start
    }

    public void execute(Gamepad gamepad) {
        DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad.left_stick_y,
                gamepad.left_stick_x,
                gamepad.right_stick_x,
                follower.pose().heading()
        );
        ManualDrive.driveOrHold(follower, powers);
        follower.update();
        Pose robotPose = follower.pose();

        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));
    }

    public void resetPose(){
        Pose cornerPose = new Pose(10.5, 10.5, Math.toRadians(90));// change this if necessary
        follower.setPose(cornerPose);
        // --- This is to reset the IMU if localization is drifting
    }
}
