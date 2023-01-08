package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClawSubsystem;

public class OpenClawCommand extends CommandBase{
    private final ClawSubsystem s_claw;
    private final XboxController operator;

    public OpenClawCommand(ClawSubsystem claw){
        s_claw = claw;
        addRequirements(claw);
        operator = RobotContainer.getOperatorController();
    }

    @Override
    public void initialize() {
        s_claw.setClawSpeed(0);
    }

    @Override
    public void execute() {
        s_claw.setClawSpeed(0.5); //open?
    }

    @Override
    public void end(boolean interrupted) {
        s_claw.setClawSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return s_claw.isOpen() || operator.getBButton();
    }
}
