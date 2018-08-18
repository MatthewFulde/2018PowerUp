package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
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

    public Encoder leftEncoders;
    public Encoder rightEncoders;
    
    AHRS gyro;
    
    public Chassis() {
    	WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_LEFT_FRONT);
    	WPI_TalonSRX leftMiddleMotor = new WPI_TalonSRX(RobotMap.CHASSIS_MOTOR_LEFT_MIDDLE);
    	WPI_VictorSPX leftRearMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_LEFT_REAR);
    	
    	WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_RIGHT_FRONT);
    	WPI_TalonSRX rightMiddleMotor = new WPI_TalonSRX(RobotMap.CHASSIS_MOTOR_RIGHT_MIDDLE);
    	WPI_VictorSPX rightRearMotor = new WPI_VictorSPX(RobotMap.CHASSIS_MOTOR_RIGHT_REAR);
    	
    	leftMotors = new SpeedControllerGroup(leftFrontMotor, leftMiddleMotor, leftRearMotor);
    	rightMotors = new SpeedControllerGroup(rightFrontMotor, rightMiddleMotor, rightRearMotor);
    	
    	leftEncoders = new Encoder(RobotMap.CHASSIS_ENCODER_LEFT_BACKWARD, RobotMap.CHASSIS_ENCODER_LEFT_FORWARD);
    	rightEncoders = new Encoder(RobotMap.CHASSIS_ENCODER_RIGHT_BACKWARD, RobotMap.CHASSIS_ENCODER_RIGHT_FORWARD);

    	leftEncoders.setDistancePerPulse(0);
    	rightEncoders.setDistancePerPulse(0);
    	
    	gyro = new AHRS(SerialPort.Port.kMXP);
    	
    	driveController = new DifferentialDrive(leftMotors, rightMotors);
    }
    
    public void initDefaultCommand() {
     setDefaultCommand(new Drive());
    }
    public void arcadeDrive(double xSpeed, double zRotation) {
    	driveController.arcadeDrive(xSpeed, zRotation);
    }
    public double getRightDistance() {
    	return rightEncoders.getDistance();
    }
    public double getLeftDistance() {
    	return leftEncoders.getDistance();
    }
    public double getDistance() {
    	return (getLeftDistance() + getRightDistance())/2;
    }
    public double getAngle() {
    	return gyro.getAngle();
    }
    public void reset() {
    	leftEncoders.reset();
    	rightEncoders.reset();
    	gyro.reset();
    }
    
}