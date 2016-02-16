package org.usfirst.frc364.Robot2016.subsystems;

import org.usfirst.frc364.Robot2016.commands.*;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class cameraSystem extends Subsystem {
    
    
	int rearCam = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	int frontCam = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	CameraServer server = CameraServer.getInstance();
	public int camera;

    public void initDefaultCommand() {
    	setDefaultCommand(new cameraCommand());
    }

	public void configureCameraFeed(int camera) {
		if(camera == 0) {
			NIVision.IMAQdxConfigureGrab(rearCam);
		} if (camera == 1) {
			NIVision.IMAQdxConfigureGrab(frontCam);
		}
		
	}
	
	public void getCameraFeed(int camera) {
		if(camera == 0) {
			NIVision.IMAQdxGrab(rearCam, frame, 0);
			server.setImage(frame);
		} if(camera == 1) {
			NIVision.IMAQdxGrab(frontCam, frame, 0);
			server.setImage(frame);
		}

	}

}


