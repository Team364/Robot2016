package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.intakeCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class intakeSystem extends PIDSubsystem {
	
	public SpeedController intakeMotor = RobotMap.intakeSystemintakeMotor;
    public DigitalInput ballSensor = RobotMap.intakeSystemballSensor;
    public AnalogInput intakePot = RobotMap.intakeSystemintakePot;
    public SpeedController intakePulley = RobotMap.intakeSystemintakePulley;
    
	public class intakeThread extends Thread {	
		@Override
		public void run() {
			for(int i = 1; i > 0; i++) {
				if(ballSensor.get() == true) {
					setSetpoint(3.8);
					intakeMotor.set(1);
				} else {
					pullIntakeUp();
					intakeMotor.set(0);
					i = -1;
				}
				Timer.delay(0.05);
			}
		}
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new intakeCommand());
    }

    public intakeSystem() {
		super("intakeSystem", 1.0, 0.0, 0.0);
		enable();
		setAbsoluteTolerance(0);
		getPIDController().setContinuous(false);
		getPIDController().setOutputRange(-1, 1);
		setSetpoint(1.3);
	}

    public void intakeBall() {	
    	Thread intakeThread = new Thread();
    	intakeThread.start();	
    }
    
    void pullIntakeUp() {
    	setSetpoint(1.3);
    }

    public void manualIntake(double speed) {
    	intakeMotor.set(speed);
    }
    
    public void manualPulley(double speed) {
    	setSetpoint((speed * 0.03) + intakePot.getVoltage());
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

