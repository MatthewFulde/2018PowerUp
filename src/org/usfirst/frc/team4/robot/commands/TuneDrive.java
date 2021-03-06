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
public class TuneDrive extends Command {

	PIDController drive;
	
    public TuneDrive() {
        requires(Robot.m_chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive = new PIDController(0,0,0, new PIDSource() {
			PIDSourceType type = PIDSourceType.kDisplacement;
    		
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				type = pidSource;
				
			}
			
			@Override
			public double pidGet() {
				return Robot.m_chassis.getDistance();
			}
			
			@Override
			public PIDSourceType getPIDSourceType() {
				return type;
			}
		}, new PIDOutput() {
			
			@Override
			public void pidWrite(double output) {
					Robot.m_chassis.arcadeDrive(output, 0);
				
			}
		});
    	drive.setAbsoluteTolerance(3);
    	drive.setSetpoint(100);
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
