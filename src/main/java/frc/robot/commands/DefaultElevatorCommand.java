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
        double elevatorDownSpeed = driver.getLeftTriggerAxis()*Constants.ELEVATOR_SPEED_REDUCED; 
        double elevatorUpSpeed = driver.getRightTriggerAxis()*Constants.ELEVATOR_SPEED_REDUCED;
        boolean condition1 = s_elevator.limitSwitchHit()==2 || s_elevator.limitSwitchHit()==3;
        boolean condition2 = s_elevator.limitSwitchHit()==1 || s_elevator.limitSwitchHit()==3;
        int liftStatus = 2; //1 is moving 2 is neutral 3 is 

        if(driver.getLeftTriggerAxis()>0 && driver.getRightTriggerAxis()<= 0){
            liftStatus = 1;
        } 
        else if(driver.getRightTriggerAxis()>0 && driver.getLeftTriggerAxis()<= 0){
            liftStatus = 3;
        }



        //Elevator Movement
        if(driver.getLeftTriggerAxis() > Constants.TRIGGER_DEADZONE && condition1 && liftStatus == 1){ //Set a deadzone to prevent accidental movement
            liftStatus = 1;
            s_elevator.setElevatorSpeed(-elevatorDownSpeed);
        }
        else if(driver.getRightTriggerAxis() > Constants.TRIGGER_DEADZONE && condition2 && liftStatus == 3){
            liftStatus = 3;
            s_elevator.setElevatorSpeed(elevatorUpSpeed);
        }
        else if(driver.getRightTriggerAxis()<=0 && driver.getRightTriggerAxis()<=0){
            liftStatus = 2;
            s_elevator.setElevatorSpeed(0);
        }
        System.out.println(liftStatus);
    }
}
