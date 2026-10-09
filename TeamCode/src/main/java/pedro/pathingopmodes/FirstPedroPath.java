package pedro.pathingopmodes;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.follower.Follower;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;

import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.groups.Groups.sequential;

import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;


@Autonomous
public class FirstPedroPath extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    // start and end coordinate
    private final Pose startPose = p.of(56, 8, 90);
    private final Pose park = p.of(56,31.59777777777778, 90);
    // other poses...
    private final Pose controlPose = p.of(36, 60, 45);
    //poses from before

    private Path park() {
        return line(startPose, park).linear(startPose, park);
    }
    /*private Path park() {
        return curve(startPose, controlPose, park).linear(startPose, park);
    }*/
    private Command autoRoutine() {
        return sequential(
                follow(follower, park())
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
