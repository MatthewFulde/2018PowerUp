package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.ElevatorMove;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	public SpeedControllerGroup Motors;

	public Elevator() {
		WPI_VictorSPX leftMotor = new WPI_VictorSPX(RobotMap.ELEVATOR_MOTOR_LEFT);
		WPI_VictorSPX rightMotor = new WPI_VictorSPX(RobotMap.ELEVATOR_MOTOR_RIGHT);
		
		Motors = new SpeedControllerGroup(leftMotor, rightMotor);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorMove());
    }
    
    public void setMotorSpeed(double speed) {
    	Motors.set(speed);
    }
}

