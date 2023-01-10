package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClawSubsystem;


public class ConeClawCommand extends CommandBase{
    private final ClawSubsystem s_claw;
    private boolean cancelcommand = false;
    private final XboxController operator;

    public ConeClawCommand(ClawSubsystem claw){
        s_claw = claw;
        addRequirements(claw);
        operator = RobotContainer.getOperatorController();
    }

    @Override
    public void initialize() {
        s_claw.so_cone.set(true);
        s_claw.so_release.set(false);
        System.out.println("Picked up cone");   
        cancelcommand = true;
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        // return cancelcommand;
        return s_claw.hasCone() || operator.getBButton();
    }
}