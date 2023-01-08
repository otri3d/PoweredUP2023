package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase {
    private final DriveSubsystem s_drive;

    public DefaultDriveCommand(DriveSubsystem drive){
        s_drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        s_drive.setLeftSpeed(0);
        s_drive.setRightSpeed(0);
    }

    @Override
    public void execute() {
        s_drive.setLeftSpeed(RobotContainer.getDriverController().getLeftY());
        s_drive.setRightSpeed(RobotContainer.getDriverController().getRightY());
    }
}
