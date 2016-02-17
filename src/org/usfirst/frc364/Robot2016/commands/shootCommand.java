package org.usfirst.frc364.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc364.Robot2016.Robot;

public class shootCommand extends Command {
	
    public shootCommand() {
    	requires(Robot.shootSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	boolean shootButton = Robot.oi.controller.getRawButton(6);

    	if(shootButton == true) {
    		Robot.shootSystem.shoot();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
