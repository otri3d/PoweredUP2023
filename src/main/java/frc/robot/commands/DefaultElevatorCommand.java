package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase {
    private final ElevatorSubsystem s_elevator;
    private final XboxController driver = RobotContainer.getDriverController();

    public DefaultElevatorCommand(ElevatorSubsystem elevator){
        s_elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        double leftTriggerAxis = driver.getLeftTriggerAxis();
        double rightTriggerAxis = driver.getRightTriggerAxis();
        if(leftTriggerAxis > Constants.triggerDeadzone){
            s_elevator.setElevatorSpeed(-leftTriggerAxis);
        }else if(rightTriggerAxis > Constants.triggerDeadzone){
            s_elevator.setElevatorSpeed(rightTriggerAxis);
        }
        
    }

    
}
