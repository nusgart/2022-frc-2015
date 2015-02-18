package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.RobotMain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDriveCommand extends Command {
	
	OI oi = RobotMain.oi;
	boolean shifterActivated = false;
	
	int toggle = 0;
	
	public TankDriveCommand() {
		requires(RobotMain.tankSubsystem);
	}

	@Override
	protected void initialize() {
//		SmartDashboard.putString("TankDrive", "COMMAND_INIT");
	}

	@Override
	protected void execute() {
		double speedModifier = .75;
		double right = Math.max(Math.min(oi.xbox.GetRightY(), 1), -1);
		double left = Math.max(Math.min(oi.xbox.GetLeftY(), 1), -1);
		
		if (oi.xbox.GetRightBumperValue()) {
			RobotMain.tankSubsystem.toggleInversion();
		}
	
		if (oi.xbox.GetLeftTriggers() > 0.1) { // turtle
			speedModifier = .5; 
		} else if (oi.xbox.GetRightTriggers() > 0.1) { // turbo
			speedModifier = 1; 
		}
		
		if(RobotMain.tankSubsystem.isInverted()){
			RobotMain.tankSubsystem.setLeftSpeed(right * speedModifier);
			RobotMain.tankSubsystem.setRightSpeed(left * speedModifier);
		}else{
			RobotMain.tankSubsystem.setLeftSpeed(left * speedModifier);
			RobotMain.tankSubsystem.setRightSpeed(right * speedModifier);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMain.tankSubsystem.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
