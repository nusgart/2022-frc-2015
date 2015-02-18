package org.usfirst.frc.team2022.robot.commands;

import static org.usfirst.frc.team2022.robot.RobotMain.*;
import edu.wpi.first.wpilibj.command.Command;
/**
 * Experimental AI code
 * @author nick
 *
 */
public class AutonomousCommand extends Command {

	public AutonomousCommand() {
		requires(forkliftSubsystem);
		requires(pneumaticSubsystem);
		requires(tankSubsystem);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}
}
