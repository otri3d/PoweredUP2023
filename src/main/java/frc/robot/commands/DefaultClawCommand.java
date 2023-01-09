package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
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
        s_claw.so_cube.set(false);
        s_claw.so_cone.set(false);
        s_claw.so_cube.set(false);
    }

    @Override
    public void execute() {
        if(RobotContainer.getOperatorController().getYButton())
            CommandScheduler.getInstance().schedule(new ConeClawCommand(s_claw));

        if(RobotContainer.getOperatorController().getXButton())
            CommandScheduler.getInstance().schedule(new CubeClawCommand(s_claw));

        if(RobotContainer.getOperatorController().getAButton())
            CommandScheduler.getInstance().schedule(new OpenClawCommand(s_claw, "cube"));

        if(RobotContainer.getOperatorController().getBButton())
            CommandScheduler.getInstance().schedule(new OpenClawCommand(s_claw, "cone"));
    }

}