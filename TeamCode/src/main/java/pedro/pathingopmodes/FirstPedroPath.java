package pedro.pathingopmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.follower.Follower;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;

import com.pedropathing.paths.Path;


@Autonomous
public class FirstPedroPath extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    // start and end coordinate
    private final Pose startPose = p.of(24, 24, 0);
    private final Pose park = p.of(48, 48, 90);
    //poses from before

    private Path park() {
        return line(startPose, park).linear(startPose, park);
    }

    @Override
    public void init() {
        follower = pedro.Constants.create(hardwareMap);
        follower.setPose(startPose);

    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {

    }
}
