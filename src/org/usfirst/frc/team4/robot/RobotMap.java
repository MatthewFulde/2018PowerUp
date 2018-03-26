/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

		// Chassis
		public static final int CHASSIS_MOTOR_LEFT_FRONT = 2;
		public static final int CHASSIS_MOTOR_LEFT_MIDDLE = 3;
		public static final int CHASSIS_MOTOR_LEFT_REAR = 4;
		public static final int CHASSIS_MOTOR_RIGHT_FRONT = 9;
		public static final int CHASSIS_MOTOR_RIGHT_MIDDLE = 8;
		public static final int CHASSIS_MOTOR_RIGHT_REAR = 7; 

		public static final int CHASSIS_ENCODER_LEFT_FORWARD = 8;
		public static final int CHASSIS_ENCODER_LEFT_BACKWARD = 9;
		public static final int CHASSIS_ENCODER_RIGHT_FORWARD = 2;
		public static final int CHASSIS_ENCODER_RIGHT_BACKWARD = 3;
		
		
		// Elevator
		public static final int ELEVATOR_MOTOR_LEFT = 0;   
		public static final int ELEVATOR_MOTOR_RIGHT = 11; 
		
		public static final int ELEVATOR_POT = 0;
		
		// Intake
		public static final int INTAKE_MOTOR_RIGHT = 10;
		public static final int INTAKE_MOTOR_LEFT= 1;
		
		//Climber
		public static final int CLIMBER_MOTOR_MASTER = 5; 
		public static final int CLIMBER_MOTOR_SLAVE = 6;
}