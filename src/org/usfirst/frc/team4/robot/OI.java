/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4.robot;

//import org.usfirst.frc.team4.robot.commands.Climb;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public OI() {
//		ControllerConstants.operatorStart.whileHeld(new Climb());
	}
	public double leftX(Joystick axis) {
		return axis.getRawAxis(ControllerConstants.AXIS_LEFT_X);
	}
	public double leftY(Joystick axis) {
		return axis.getRawAxis(ControllerConstants.AXIS_LEFT_Y);
	}
	public double rightX(Joystick axis) {
		return axis.getRawAxis(ControllerConstants.AXIS_RIGHT_X);
	}
	public double rightY(Joystick axis) {
		return axis.getRawAxis(ControllerConstants.AXIS_RIGHT_Y);
	}
}
