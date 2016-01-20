// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class hangSystem extends Subsystem {

	public final SpeedController winchMotor = RobotMap.hangSystemwinchMotor;
	public final SpeedController flipMotor = RobotMap.hangSystemflipMotor;
	public final AnalogInput pot = RobotMap.hangSystempot;

	public void flipHangBars() {
		//Create the sequence to flip the hanging bars into hanging position here.
	}
	
	public void extendHangBars() {
		//Create the sequence to extend the hanging bars up to hang here.
	}
	
	public void hangFromCastle() {
		//Create the sequence to hang from the castle here.
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new hangCommand());
    }
}

