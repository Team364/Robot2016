// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc364.Robot2016;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.interfaces.Gyro;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static SpeedController driveSystemleftFront;
    public static SpeedController driveSystemleftRear;
    public static SpeedController driveSystemrightFront;
    public static SpeedController driveSystemrightRear;
    public static RobotDrive driveSystemrobotDrive;
    public static DoubleSolenoid shiftSystemleftShifter;
    public static DoubleSolenoid shiftSystemrightShifter;
    public static SpeedController intakeSystemintakeMotor;
    public static DigitalInput intakeSystemballSensor;
    public static SpeedController shootSystemshootMotor;
    public static AnalogInput driveSystemgyro;
    public static SpeedController hangSystemwinchMotor;
    public static SpeedController hangSystemflipMotor;
    public static AnalogInput hangSystempot;
	public static RobotDrive intakeSystemintakeDrive;

    public static void init() { 

        driveSystemleftFront = new VictorSP(0);
        driveSystemleftRear = new VictorSP(1);       
        driveSystemrightFront = new VictorSP(2);        
        driveSystemrightRear = new VictorSP(3);
        
        driveSystemrobotDrive = new RobotDrive(driveSystemleftFront, driveSystemleftRear,
              driveSystemrightFront, driveSystemrightRear);
        
        driveSystemrobotDrive.setSafetyEnabled(true);
        driveSystemrobotDrive.setExpiration(0.1);
        driveSystemrobotDrive.setSensitivity(0.5);
        driveSystemrobotDrive.setMaxOutput(1.0);
        driveSystemgyro = new AnalogInput(0);

        intakeSystemintakeMotor = new VictorSP(4); 
        intakeSystemballSensor = new DigitalInput(0);
        
        shootSystemshootMotor = new VictorSP(5);
        
        hangSystemwinchMotor = new VictorSP(6);
        hangSystemflipMotor = new VictorSP(7);
        hangSystempot = new AnalogInput(0);
        
        
    }
}
