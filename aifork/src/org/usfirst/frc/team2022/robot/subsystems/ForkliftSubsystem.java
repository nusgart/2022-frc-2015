
package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.ForkliftCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

/**
 *
 */
public class ForkliftSubsystem extends Subsystem {
	private CanTalonSRX winchMotor;
	private Encoder winchEncoder;

	public ForkliftSubsystem(){
		winchMotor = new CanTalonSRX(RobotMap.winchMotor) ;
		winchEncoder = new Encoder(RobotMap.winchEncoderChannelA, RobotMap.winchEncoderChannelB);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ForkliftCommand());
	}

	public void moveForklift(double winchSpeed){
		winchMotor.Set(winchSpeed);
	}
	public boolean getUpperLimit(){
		return false;
	}
	public boolean getLowerLimit(){
		return false;
	}
}

