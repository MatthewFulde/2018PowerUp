package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Climb;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    public SpeedControllerGroup Motors;
    
    public Climber() {
    	WPI_VictorSPX slaveMotor = new WPI_VictorSPX(RobotMap.CLIMBER_MOTOR_SLAVE);
    	WPI_VictorSPX masterMotor = new WPI_VictorSPX(RobotMap.CLIMBER_MOTOR_MASTER);
    
    	Motors = new SpeedControllerGroup(slaveMotor, masterMotor);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new Climb());
    }
    public void setMotorSpeed(double speed) {
    	Motors.set(speed);
    }
}

