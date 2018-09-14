package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.ElevatorMove;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Elevator extends Subsystem {

	public SpeedControllerGroup Motors;

	public Potentiometer pot;
	
	public Elevator() {
//		WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_LEFT);
//		WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_RIGHT);
		WPI_VictorSPX leftMotor = new WPI_VictorSPX(RobotMap.ELEVATOR_MOTOR_LEFT);
		WPI_VictorSPX rightMotor = new WPI_VictorSPX(RobotMap.ELEVATOR_MOTOR_RIGHT);
		
		Motors = new SpeedControllerGroup(leftMotor, rightMotor);
		
		pot = new AnalogPotentiometer(RobotMap.ELEVATOR_POT);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorMove());
    }
    
    public void setMotorSpeed(double speed) {
    	Motors.set(speed);
    }
    public double getPot() {
    	return pot.get();
    }
}

