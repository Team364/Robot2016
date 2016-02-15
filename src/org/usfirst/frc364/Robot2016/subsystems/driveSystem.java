package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.RobotMap;
import org.usfirst.frc364.Robot2016.commands.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class driveSystem extends Subsystem {

    public final RobotDrive robotDrive = RobotMap.driveSystemrobotDrive;
    public final AnalogInput gyro = RobotMap.driveSystemgyro;
    
    public void drive(double left, double right) {
    	robotDrive.tankDrive(left, right);
    }

    public void initDefaultCommand() {	
    	setDefaultCommand(new driveCommand());
    }
}

