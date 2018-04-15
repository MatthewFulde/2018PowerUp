package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoElevator extends Command {

	PIDController lift;
	double setpoint; 
	
    public AutoElevator(double setpoint) {
        this.setpoint = setpoint;
    	requires(Robot.m_elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lift = new PIDController(0,0,0, new PIDSource() {
			PIDSourceType type = PIDSourceType.kDisplacement;
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				type = pidSource;
				
			}
			
			@Override
			public double pidGet() {
				// TODO Auto-generated method stub
				return Robot.m_elevator.getPot();
			}
			
			@Override
			public PIDSourceType getPIDSourceType() {
				return type;
			}
		}, new PIDOutput() {
			
			@Override
			public void pidWrite(double output) {
				Robot.m_elevator.setMotorSpeed(output);	
			}
		});
    	lift.setAbsoluteTolerance(1);
    	lift.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
