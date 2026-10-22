package org.firstinspires.ftc.teamcode.pedro.pathingopmodes;


import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.*;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedro.Constants;

@Autonomous(name = "Blue Testing", group = "Autonomous")
    public class BlueConcept extends LinearOpMode {

        private Follower follower;

        private final PoseFactory poseFactory = PoseFactory.degrees();

        private final Pose start = poseFactory.of(86.9831, 139.5982, -90);
        private final Pose firstShot = poseFactory.of(86.9831, 123.8501, -90);
        private final Pose toFlowerStart = poseFactory.of(86.9831, 123.8501, 0);
        private final Pose toFlower = poseFactory.of(133.1185, 95.5237, 0);
        private final Pose exitFlowerStart = poseFactory.of(133.1185, 95.5237, 0);
        private final Pose exitFlower = poseFactory.of(126.2878, 95.8702, 0);
        private final Pose curveToShootingStart = poseFactory.of(126.2878, 95.8702, 0);
        private final Pose curveToShooting = poseFactory.of(83.3488, 25.7291, 90);
        private final Pose curveToShootingControl1 = poseFactory.of(130.956, 45.877, 0);
        private final Pose curveToGardenStart = poseFactory.of(83.3488, 25.7291, 90);
        private final Pose curveToGarden = poseFactory.of(133.2731, 134.4503, 90);
        private final Pose curveToGardenControl1 = poseFactory.of(136.4357, 36.6851, 0);
        private final Pose curveToGardenControl2 = poseFactory.of(79.2901, 117.0124, 0);
        private final Pose parkingStart = poseFactory.of(133.2731, 134.4503, 90);
        private final Pose parking = poseFactory.of(134.2415, 33.2675, 180);
        private final Pose parkingControl1 = poseFactory.of(94.2167, 100.8454, 0);

        // Autonomous routine
        public Command autoRoutine() {
            return sequential(
                    follow(follower, firstShot()),
                    follow(follower, toFlower()),
                    follow(follower, exitFlower()),
                    follow(follower, curveToShooting()),
                    follow(follower, curveToGarden()),
                    follow(follower, parking())
            );
        }

        @Override
        public void runOpMode() {
            Scheduler.reset();
            follower = Constants.create(hardwareMap);
            follower.setPose(start);
            follower.update();

            waitForStart();
            schedule(autoRoutine());

            while (opModeIsActive()) {
                follower.update();
                Scheduler.execute();

                telemetry.addData("x", follower.pose().x());
                telemetry.addData("y", follower.pose().y());
                telemetry.addData("heading", follower.pose().heading());

                if (follower.currentPath() != null) {
                    telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
                    telemetry.addData("Path number", follower.pathIndex());
                }

                telemetry.update();
            }
        }

        public Path firstShot() {
            return Paths.line(start, firstShot).linear(start, firstShot);
        }

        public Path toFlower() {
            return Paths.line(toFlowerStart, toFlower).linear(toFlowerStart, toFlower);
        }

        public Path exitFlower() {
            return Paths.line(exitFlowerStart, exitFlower).linear(exitFlowerStart, exitFlower);
        }

        public Path curveToShooting() {
            return Paths.curve(curveToShootingStart, curveToShootingControl1, curveToShooting).linear(curveToShootingStart, curveToShooting);
        }

        public Path curveToGarden() {
            return Paths.curve(curveToGardenStart, curveToGardenControl1, curveToGardenControl2, curveToGarden).linear(curveToGardenStart, curveToGarden);
        }

        public Path parking() {
            return Paths.curve(parkingStart, parkingControl1, parking).linear(parkingStart, parking);
        }
    }

