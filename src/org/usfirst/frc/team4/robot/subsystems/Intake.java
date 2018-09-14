package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.IntakeMove;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public SpeedControllerGroup Motors;
	
	
	public Intake() {
		WPI_VictorSPX leftMotor = new WPI_VictorSPX(RobotMap.INTAKE_MOTOR_LEFT);
		WPI_VictorSPX rightMotor = new WPI_VictorSPX(RobotMap.INTAKE_MOTOR_RIGHT);
		
		leftMotor.setInverted(true);
		
		Motors = new SpeedControllerGroup(leftMotor, rightMotor);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeMove());
    }
    public void setMotorSpeed(double speed) {
    	Motors.set(speed);
    }
   
}

