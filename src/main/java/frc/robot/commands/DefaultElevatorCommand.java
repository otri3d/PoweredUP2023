package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ElevatorSubsystem;

public class DefaultElevatorCommand extends CommandBase {
    private final ElevatorSubsystem s_elevator;
    private final XboxController operator = RobotContainer.getOperatorController();

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
        double elevatorDownSpeed = operator.getLeftTriggerAxis()*Constants.ELEVATOR_SPEED_REDUCED; 
        double elevatorUpSpeed = operator.getRightTriggerAxis()*Constants.ELEVATOR_SPEED_REDUCED;
        boolean condition1 = s_elevator.limitSwitchHit()==2 || s_elevator.limitSwitchHit()==3; //if upper limit is hit
        boolean condition2 = s_elevator.limitSwitchHit()==1 || s_elevator.limitSwitchHit()==3;
        int liftStatus = 2; //1 is moving 2 is neutral 3 is 

        if(!condition1){
            s_elevator.setElevatorSpeed(Math.min(0, elevatorUpSpeed));
        }
        else if(!condition2){
            s_elevator.setElevatorSpeed(Math.max(0, elevatorDownSpeed));
        }
        else{
            s_elevator.setElevatorSpeed(operator.getRightY()*Constants.ELEVATOR_SPEED_REDUCED);
        }



        // if(driver.getLeftTriggerAxis()>0 && driver.getRightTriggerAxis()<= 0){
        //     liftStatus = 1;
        // } 
        // else if(driver.getRightTriggerAxis()>0 && driver.getLeftTriggerAxis()<= 0){
        //     liftStatus = 3;
        // }



        //Elevator Movement

        // s_elevator.setElevatorSpeed(RobotContainer.getOperatorController().getRightY());
        // if(driver.getLeftTriggerAxis() > Constants.TRIGGER_DEADZONE && condition1 && liftStatus == 1){ //Set a deadzone to prevent accidental movement
        //     liftStatus = 1;
        //     s_elevator.setElevatorSpeed(-elevatorDownSpeed);
        // }
        // else if(driver.getRightTriggerAxis() > Constants.TRIGGER_DEADZONE && condition2 && liftStatus == 3){
        //     liftStatus = 3;
        //     s_elevator.setElevatorSpeed(elevatorUpSpeed);
        // }
        // else if(driver.getRightTriggerAxis()<=Constants.TRIGGER_DEADZONE && driver.getLeftTriggerAxis()<=Constants.TRIGGER_DEADZONE){
        //     liftStatus = 2;
        //     s_elevator.setElevatorSpeed(0);
        // }
    }
}
