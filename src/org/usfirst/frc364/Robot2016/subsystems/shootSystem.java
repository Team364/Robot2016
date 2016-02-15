package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.shootCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class shootSystem extends Subsystem {

    private final SpeedController shootMotor = RobotMap.shootSystemshootMotor;
    private final SpeedController intakeMotor = RobotMap.intakeSystemintakeMotor;
    
    public void shoot() {
    	intakeMotor.set(-0.3);
    	Timer.delay(0.5);
    	intakeMotor.set(0);
    	shootMotor.set(1);
    	Timer.delay(1.5);
    	intakeMotor.set(1);
    	Timer.delay(1.5);
    	intakeMotor.set(0);
    	shootMotor.set(0);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new shootCommand());
    }
}
