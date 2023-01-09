package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class OpenClawCommand extends CommandBase{
    private final ClawSubsystem s_claw;
    private final XboxController operator;
    private String object;
    public OpenClawCommand(ClawSubsystem claw, String gameobject){
        s_claw = claw;
        object = gameobject;
        addRequirements(s_claw);
        operator = RobotContainer.getOperatorController();
    }

    @Override
    public void initialize(){
        if(object == "cube"){
            s_claw.so_cube.set(false);
            s_claw.so_release.set(true);
        }
        else if(object == "cone"){
            s_claw.so_cone.set(false);
            s_claw.so_release.set(true);
        }
        else{
            System.out.println("Wrong input.");
        }
    }

    @Override
    public void execute(){
    }

    @Override
    public void end(boolean interrupted){

    }
    
    @Override
    public boolean isFinished(){
        return true;
    }
}