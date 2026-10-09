package pedro.pathingopmodes;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import static com.pedropathing.ivy.pedro.PedroCommands.hold;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.curves.Line;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
@Autonomous
public class MultiPathAuto extends OpMode {
    private Follower follower;

    private final PoseFactory p = PoseFactory.degrees();

    private final Pose startPose = p.of(56, 22.687, 90);
    private final Pose shootPose = p.of(56,30, 90);
    private final Pose flowerPose = p.of(28.345, 39.847, 158);
    private final Pose parkPose = p.of(17.875,87.931, 101);

    private Path shoot() {
        return line(startPose, shootPose).linear(startPose, shootPose);
    }

    private Path flower(){
        return line(shootPose, flowerPose).tangent();
    }

    private Path park(){
        return line(flowerPose, parkPose).tangent();
    }


    private Command autoRoutine(){
        return sequential(
                follow(follower, shoot()),
                //add mechanisms here between paths
                follow(follower, flower()),
                follow(follower, park()),
                hold(follower)
        );
    }
    @Override
    public void init() {
        follower = pedro.Constants.create(hardwareMap);
        follower.setPose(startPose);
        Scheduler.reset();
        follower.update();

    }

    @Override
    public void start() {
        super.start();
        schedule(autoRoutine());
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();

        telemetry.addData("X", follower.pose().x());
        telemetry.addData("Y", follower.pose().y());
        telemetry.addData("Heading", Math.toDegrees(follower.pose().heading()));
        telemetry.addData("Follower Mode", follower.mode());
        telemetry.update();


    }
}
