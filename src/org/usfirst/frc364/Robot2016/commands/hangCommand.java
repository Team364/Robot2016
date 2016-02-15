package org.usfirst.frc364.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc364.Robot2016.Robot;
import org.usfirst.frc364.Robot2016.subsystems.hangSystem;

public class hangCommand extends Command {
	
    public hangCommand() {
    	requires(Robot.hangSystem);
    }


    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {	
    	
    	if(Robot.oi.wenchManualUp.get() == true) {
    		
    		Robot.hangSystem.manualWench(1);
    		
    	} if(Robot.oi.wenchManualDown.get() == true) {
    		
    		Robot.hangSystem.manualWench(-1);
    		
    	} if(Robot.oi.hangFromCastle.get() == true) {
    		
    		Robot.hangSystem.hangFromCastle();
    	
    	} else {
    		
    		Robot.hangSystem.manualWench(0);
    	
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
