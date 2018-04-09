package org.usfirst.frc.team4.robot.commands.autocommands;

import org.usfirst.frc.team4.robot.commands.AutoDrive;
import org.usfirst.frc.team4.robot.commands.Outtake;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FarleftSide extends CommandGroup {

	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
    public FarleftSide() {
    	if(gameData.length() > 0) {
    		if(gameData.charAt(0) == 'l') {
    			addSequential(new AutoDrive(0,0),0);
    			addSequential(new AutoDrive(0,0),0);
    			addSequential(new AutoDrive(0,0),0);
    		}else {
    			
    		}
//    			addSequential(new Outtake(), 5);
    	}
    	
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
