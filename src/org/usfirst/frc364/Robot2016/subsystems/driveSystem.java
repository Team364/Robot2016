package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class driveSystem extends Subsystem {

    public final RobotDrive robotDrive = RobotMap.driveSystemrobotDrive;
    public final AnalogGyro gyro = RobotMap.driveSystemgyro;
    
    public void drive(double left, double right) {
    	robotDrive.tankDrive(left, right);
    }
    
    public void centerRobot() {
    	double angle = gyro.getAngle();
    	double Kp = 0.03;
    	for(int i = 1; i > 0; i++) {
        	if(angle > -0.05 && angle < 0.05) {
        		robotDrive.tankDrive((-0.5 * (-angle * Kp)), (0.5 * (-angle * Kp)));
        	} else {
        		i = -1;
        	}
    	}
    }
    
    public void driveStraight(int cycles) {
    	// 10 cycles in a second
    	double angle;
    	double Kp = 0.03;
    	gyro.reset();
    	int i = 0;
    	while(i < cycles) {
    	angle = gyro.getAngle(); // get current heading
        drive(0.5, -angle*Kp); // drive towards heading 0
        Timer.delay(0.1);
        i = i + 1;
    	}
    	drive(0, 0);
    }

    public void initDefaultCommand() {	
    	setDefaultCommand(new driveCommand());
    }
}

