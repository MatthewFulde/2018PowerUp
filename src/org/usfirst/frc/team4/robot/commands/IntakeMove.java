package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.ControllerConstants;
import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeMove extends Command {

    public IntakeMove() {
        requires(Robot.m_intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(ControllerConstants.operatorLeftBumper.get()) {
    		Robot.m_intake.setMotorSpeed(.75);
    	}else if(ControllerConstants.operatorRightBumper.get()) {
    		Robot.m_intake.setMotorSpeed(-.75);
    	}else {
    		Robot.m_intake.Motors.stopMotor();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_intake.Motors.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}