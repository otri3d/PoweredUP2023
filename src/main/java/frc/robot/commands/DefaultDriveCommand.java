package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase {
    private final DriveSubsystem s_drive;
    private boolean slowModeToggled = false; 

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
        double leftSpeed = RobotContainer.getDriverController().getLeftY();
        double rightSpeed = RobotContainer.getDriverController().getRightY();
        if(RobotContainer.getDriverController().getXButton()){
            s_drive.toggleSlowMode();
        }
        s_drive.setLeftSpeed(leftSpeed);
        s_drive.setRightSpeed(rightSpeed);
        SmartDashboard.putBoolean("Slow Mode Status", s_drive.slowModeStatus());
    }
}
