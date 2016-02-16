package org.usfirst.frc364.Robot2016.commands;

import org.usfirst.frc364.Robot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class cameraCommand extends Command {

    public cameraCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.cameraSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cameraSystem.camera = 0;
    	Robot.cameraSystem.configureCameraFeed(0);
    	Robot.cameraSystem.getCameraFeed(0);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.frontCamSelect.get() == true) {
    		Robot.cameraSystem.camera = 1;
    		Robot.cameraSystem.configureCameraFeed(1);
    		Robot.cameraSystem.getCameraFeed(1);
    	} if(Robot.oi.rearCamSelect.get() == true) {
    		Robot.cameraSystem.camera = 0;
    		Robot.cameraSystem.configureCameraFeed(0);
    		Robot.cameraSystem.getCameraFeed(0);
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
