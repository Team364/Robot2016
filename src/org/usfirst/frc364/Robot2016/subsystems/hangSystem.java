package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class hangSystem extends PIDSubsystem {

	public SpeedController wenchMotor = RobotMap.hangSystemwenchMotor;
	public static AnalogInput wenchPot = RobotMap.hangSystemwenchPot;

	public hangSystem() {
		super("hangSystem", 1.0, 0.0, 0.0);
		enable();
		setAbsoluteTolerance(0);
		getPIDController().setContinuous(false);
		getPIDController().setOutputRange(-1, 1);
		setSetpoint(0.33);
	}

	public void extendHangBars() {
		setSetpoint(1);
	}
	
	public void hangFromCastle() {
		setSetpoint(1);
	}

	public void manualWench(double power) {
		setSetpoint(power + wenchPot.getVoltage());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new hangCommand());
    }

	protected double returnPIDInput() {
		return wenchPot.getAverageVoltage();
	}

	protected void usePIDOutput(double output) {
		wenchMotor.set(output);
	}

}

