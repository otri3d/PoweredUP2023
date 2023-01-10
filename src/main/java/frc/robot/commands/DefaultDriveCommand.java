package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends CommandBase {
    private final DriveSubsystem s_drive;
    private final XboxController driver = RobotContainer.getDriverController();

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
        double leftSpeed = -driver.getLeftY()*s_drive.speedConstant();
        System.out.println(driver.getLeftY());
        double rightSpeed = -driver.getRightY()*s_drive.speedConstant(); 
        if(RobotContainer.getDriverController().getXButton()){
            s_drive.toggleSlowMode();
        }
        s_drive.setLeftSpeed(leftSpeed);
        s_drive.setRightSpeed(rightSpeed);
        SmartDashboard.putBoolean("Slow Mode Status", s_drive.slowModeStatus());
    }
}
