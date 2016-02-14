package org.usfirst.frc364.Robot2016.commands;

import org.usfirst.frc364.Robot2016.Robot;
import org.usfirst.frc364.Robot2016.subsystems.flipSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class flipCommand extends Command {
	
	boolean up = Robot.oi.controller.getRawButton(4);
	boolean down = Robot.oi.controller.getRawButton(1);
	//boolean flipHangers = Robot.oi.controller.getRawButton(2);

    public flipCommand() {
        requires(Robot.flipSystem);
    } 

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(up == true) {
    		Robot.flipSystem.manualFlip(1);
    	} if(down == true) {
    		Robot.flipSystem.manualFlip(-1);
    	} else {
    		Robot.flipSystem.manualFlip(0);
    	}
    	/*
    	if(flipHangers == true) {
    		Robot.flipSystem.flipHangBars();
    	}
    	*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
