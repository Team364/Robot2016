package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.shootCommand;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class shootSystem extends Subsystem {

    private final SpeedController shootMotor = RobotMap.shootSystemshootMotor;
    private final SpeedController shootMotor2 = RobotMap.shootSystemshootMotor2;
    private final SpeedController intakeMotor = RobotMap.intakeSystemintakeMotor;
    
    public class shootThread extends Thread {
    	@Override
    	public void run() {
        	intakeMotor.set(-0.3);
        	Timer.delay(0.7);
        	intakeMotor.set(0);
        	shootMotor.set(0.6);
        	shootMotor2.set(0.6);
        	Timer.delay(1.7);
        	intakeMotor.set(1);
        	Timer.delay(1.5);
        	intakeMotor.set(0);
        	shootMotor.set(0);
        	shootMotor2.set(0);
        	Timer.delay(0.05);
    	}
    	
    }
    
    public void shoot() {
    	Thread shootThread = new Thread();
    	shootThread.start();
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new shootCommand());
    }
}
