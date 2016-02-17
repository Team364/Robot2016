package org.usfirst.frc364.Robot2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc364.Robot2016.Robot;

public class AutonomousCommand extends Command {

    public AutonomousCommand() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.driveStraight(30);
    	Robot.driveSystem.drive(-0.5, 0.5);
    	Timer.delay(1);
    	Robot.driveSystem.driveStraight(30);
    	Robot.driveSystem.drive(-0.5, 0.5);
    	Timer.delay(1);
    	Robot.driveSystem.driveStraight(30);
    	Robot.shootSystem.shoot();
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
