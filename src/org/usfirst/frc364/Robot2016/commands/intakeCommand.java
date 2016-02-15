package org.usfirst.frc364.Robot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc364.Robot2016.Robot;

public class intakeCommand extends Command {

    public intakeCommand() {
    	requires(Robot.intakeSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	double yaxis = Robot.oi.controller.getRawAxis(1);
    	double xaxis = Robot.oi.controller.getRawAxis(5);
    	
    	//This runs the manual intake
    	if(yaxis > 0.05 || yaxis < -0.05) { 
        	Robot.intakeSystem.manualIntake(yaxis);
    	} else {
    		Robot.intakeSystem.manualIntake(0);
    	}
    	//This runs the manual pulley
    	if(xaxis > 0.05 || xaxis < -0.05) {
    		Robot.intakeSystem.manualPulley(xaxis);
    	} else {
    		Robot.intakeSystem.manualPulley(0);
    	}
    	//This runs the intake ball sequence
    	if(Robot.oi.intakeBall.get() == true) {
    		Robot.intakeSystem.intakeBall();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after is Finished returns true
    protected void end() {
    	end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
