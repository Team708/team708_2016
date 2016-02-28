package org.team708.robot.commands.autonomous;

import org.team708.robot.AutoConstants;
import org.team708.robot.commands.arm.ArmDown;
import org.team708.robot.commands.drivetrain.DriveStraightForTime;
import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.RotateAndDriveToTarget;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.shooter.AutoLoaderSpin;
import org.team708.robot.commands.shooter.AutoShooterSpin;
import org.team708.robot.commands.shooter.AutoStopSL;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DriveForwardShoot extends CommandGroup {
	
	public  DriveForwardShoot() {
		addSequential(new ArmDown());
		addSequential(new DriveStraightForTime(AutoConstants.ROBOT_TIME_DRIVE_SPEED, AutoConstants.ROBOT_OVER_DEFENSE_TIME));
    	addSequential(new RotateAndDriveToTarget(AutoConstants.SHOOTING_SONAR_DISTANCE));
    	//Shooting Sequence
    	addSequential(new AutoShooterSpin());
		addSequential(new WaitCommand(AutoConstants.SHOOTER_MOTOR_SPINUP_TIME));
		addSequential(new AutoLoaderSpin());
		addSequential(new WaitCommand(AutoConstants.LOADER_MOTOR_LOADING_TIME));
		addSequential(new AutoStopSL());

   
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
