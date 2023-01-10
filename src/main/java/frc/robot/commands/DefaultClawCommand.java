package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClawSubsystem;

public class DefaultClawCommand extends CommandBase{
    private static final Object[] holding = null;
    private final ClawSubsystem s_claw;
    private boolean holdingcube = false;
    private boolean holdingcone = false;

    public DefaultClawCommand(ClawSubsystem claw){
        s_claw = claw;
        addRequirements(claw);
    }
    
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        SmartDashboard.putBoolean("Holding cube", holdingcube);
        SmartDashboard.putBoolean("Holding cone", holdingcone);
        if(RobotContainer.getOperatorController().getYButton() && !holdingcube && !holdingcone){
            holdingcone = true;
            CommandScheduler.getInstance().schedule(new ConeClawCommand(s_claw));
        }

        if(RobotContainer.getOperatorController().getXButton() && !holdingcube && !holdingcone){
            holdingcube = true;
            CommandScheduler.getInstance().schedule(new CubeClawCommand(s_claw));
        }

        if(RobotContainer.getOperatorController().getBButton() && holdingcube){
            holdingcube = false;
            CommandScheduler.getInstance().schedule(new OpenClawCommand(s_claw));
        }
        //Release cone
        if((RobotContainer.getOperatorController().getAButton() && holdingcone)){
            holdingcone = false;
            CommandScheduler.getInstance().schedule(new OpenClawCommand(s_claw));
        }
        if(RobotContainer.getOperatorController().getLeftBumper())
            s_claw.liftClaw();
    }

}