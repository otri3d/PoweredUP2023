package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClawSubsystem;

public class DefaultClawCommand extends CommandBase{
    private final ClawSubsystem s_claw;

    public DefaultClawCommand(ClawSubsystem claw){
        s_claw = claw;
        addRequirements(claw);
    }
    
    @Override
    public void initialize() {
        s_claw.setClawSpeed(0);
    }

    @Override
    public void execute() {//manual control
        if(RobotContainer.getOperatorController().getLeftBumper() && !s_claw.hasCube()){
            s_claw.setClawSpeed(-1); //close
        } else if(RobotContainer.getOperatorController().getRightBumper() && !s_claw.isOpen()) {
            s_claw.setClawSpeed(1); //open
        } else {
            s_claw.setClawSpeed(0);
        }
    }

}
