package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Chassis extends Subsystem {

    SpeedControllerGroup leftMotors;
    SpeedControllerGroup rightMotors;
    
    DifferentialDrive driveController;

    public Chassis() {
    	WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_LEFT_FRONT);
    	WPI_VictorSPX leftMiddleMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_LEFT_MIDDLE);
    	WPI_VictorSPX leftRearMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_LEFT_REAR);
    	
    	WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_RIGHT_FRONT);
    	WPI_VictorSPX rightMiddleMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_RIGHT_MIDDLE);
    	WPI_VictorSPX rightRearMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_RIGHT_REAR);
    	
    	leftMotors = new SpeedControllerGroup(leftFrontMotor, leftMiddleMotor, leftRearMotor);
    	rightMotors = new SpeedControllerGroup(rightFrontMotor, rightMiddleMotor, rightRearMotor);
    	
    	driveController = new DifferentialDrive(leftMotors, rightMotors);
    }
    
    public void initDefaultCommand() {
     setDefaultCommand(new Drive());
    }
    public void arcadeDrive(double xSpeed, double zRotation) {
    	driveController.arcadeDrive(xSpeed, zRotation);
    }
    
}

