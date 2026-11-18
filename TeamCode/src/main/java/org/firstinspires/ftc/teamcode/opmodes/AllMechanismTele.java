package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

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
    Gamepad gamepad;

    @Override
    public void init() {
        gamepad = gamepad1;
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);
        IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hardwareMap);
        ShooterSubsystem shooterSubsystem = new ShooterSubsystem(hardwareMap);
        driveCommand = new RobotCentricCommand(driveSubsystem, gamepad);
        intakeCommand = new IntakeCommand(intakeSubsystem, gamepad);
        //shooterRPMCommand.ShootRPM(shooterSubsystem, gamepad1);
        shootPowerCommand = new ShootPowerCommand(shooterSubsystem, gamepad);

    }

    @Override
    public void loop() {
        driveCommand.execute(driveSubsystem, gamepad);
        intakeCommand.execute(intakeSubsystem, gamepad);
        //shooterRPMCommand.execute();

        if (gamepad.x){
            driveCommand.brake(driveSubsystem);
        }




    }
}
