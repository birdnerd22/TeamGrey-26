package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.RobotCentricCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.commands.ShootPowerCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
@TeleOp
public class AllMechanismTele extends OpMode {
    IntakeSubsystem intakeSubsystem;
    DriveSubsystem driveSubsystem;

    ShooterSubsystem shooterSubsystem;
    RobotCentricCommand driveCommand;
    IntakeCommand intakeCommand;
   // ShooterRPMCommand shooterRPMCommand;
    ShootPowerCommand shootPowerCommand;


    @Override
    public void init() {
         driveSubsystem = new DriveSubsystem(hardwareMap);
         intakeSubsystem = new IntakeSubsystem(hardwareMap);
         shooterSubsystem = new ShooterSubsystem(hardwareMap);
        driveCommand = new RobotCentricCommand(driveSubsystem, gamepad1);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad1);
        //shooterRPMCommand.ShootRPM(shooterSubsystem, gamepad1);
        shootPowerCommand = new ShootPowerCommand(shooterSubsystem, gamepad1);

    }

    @Override
    public void loop() {
        //driveCommand.execute();
        intakeCommand.execute();
        //shooterRPMCommand.execute();

        if (gamepad1.x){
            driveCommand.brake();
        }




    }
}
