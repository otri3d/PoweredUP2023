package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase {
    private final ElevatorSubsystem s_elevator;
    private final XboxController driver = RobotContainer.getDriverController();

    public DefaultElevatorCommand(ElevatorSubsystem elevator){ //Create Elevator command, and set elevator as a requirement to the command
        s_elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize(){
        s_elevator.setElevatorSpeed(0);
    }

    @Override
    public void execute(){
        double leftTriggerAxis = driver.getLeftTriggerAxis(); //Get axis
        double rightTriggerAxis = driver.getRightTriggerAxis();
        //Elevator Movement
        if(leftTriggerAxis > Constants.triggerDeadzone){ //Set a deadzone to prevent accidental movement
            s_elevator.setElevatorSpeed(-leftTriggerAxis);
        }
        else if(rightTriggerAxis > Constants.triggerDeadzone){
            s_elevator.setElevatorSpeed(rightTriggerAxis);
        }
        //Limit Switch
        if(s_elevator.limitSwitchHit()){ //Makes elevator stop if upper switch or lower switch hit anything     
            s_elevator.stopElevator();
        } 
    }
}
