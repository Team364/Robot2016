package org.usfirst.frc364.Robot2016.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;

public class flipSystem extends PIDSubsystem {

	public SpeedController flipMotor = RobotMap.flipSystemflipMotor;
	public static AnalogInput flipPot = RobotMap.flipSystemflipPot;

    public flipSystem() {
    	
    	super("flipSystem", 1, 0.0, 0.1);
    	enable();
		setAbsoluteTolerance(0);
		getPIDController().setContinuous(false);
		getPIDController().setOutputRange(-1, 1);
    	setSetpoint(0.01);
    	
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new flipCommand());
    }
    
	public void manualFlip(double power) {
		//setSetpoint(power + flipPot.getVoltage());
	}
	
	public void flipHangBars() {
		//setSetpoint(0.55);
	}

    protected double returnPIDInput() {
    	return flipPot.getAverageVoltage();
    }
    
    protected void usePIDOutput(double output) {
    	flipMotor.set(0);
    }

}
