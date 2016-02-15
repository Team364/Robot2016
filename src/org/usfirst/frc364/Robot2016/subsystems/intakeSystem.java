package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.intakeCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class intakeSystem extends PIDSubsystem {

	private SpeedController intakeMotor = RobotMap.intakeSystemintakeMotor;
    private DigitalInput ballSensor = RobotMap.intakeSystemballSensor;
    private AnalogInput intakePot = RobotMap.intakeSystemintakePot;
    private SpeedController intakePulley = RobotMap.intakeSystemintakePulley;
	
    public intakeSystem() {
		super("intakeSystem", 1.0, 0.0, 0.0);
		enable();
		setAbsoluteTolerance(0);
		getPIDController().setContinuous(false);
		getPIDController().setOutputRange(-1, 1);
		setSetpoint(1);
	}
    
    public void intakeBall() {

    	// Set the position for the pulley.
    	setSetpoint(1);
    	
    	// Run a loop that waits until the ball comes into the robot.
    	for(int i = 1; i < 0; i++) {
    		if(ballSensor.get() == true) {
    			intakeMotor.set(1);
    		} else {
    			intakeMotor.set(0);
    			i = -1;
    		}
    			
    	}
    	
    	// Set the position for the pulley.
    	setSetpoint(1);
    	
    }

    public void manualIntake(double speed) {
    	intakeMotor.set(speed);
    }
    
    public void manualPulley(double speed) {
    	intakePulley.set(speed);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new intakeCommand());
    }

	@Override
	protected double returnPIDInput() {
		return intakePot.getAverageVoltage();
	}

	@Override
	protected void usePIDOutput(double output) {
		intakePulley.set(output);
	}
}

