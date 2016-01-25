package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.commands.*;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class cameraSystem extends Subsystem {
    
    
	int rearCam = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	CameraServer server = CameraServer.getInstance();


    public void initDefaultCommand() {
    	setDefaultCommand(new cameraCommand());
    }
    
	public void configureCameraFeed() {
		NIVision.IMAQdxConfigureGrab(rearCam);
	}
	
	public void getCameraFeed() {
		NIVision.IMAQdxGrab(rearCam, frame, 0);
		server.setImage(frame);
	}
}

