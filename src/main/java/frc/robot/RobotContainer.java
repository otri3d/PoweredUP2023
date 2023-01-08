package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem;

    private static XboxController driver;
    private static XboxController operator;

    public RobotContainer(){
        //DRIVE
        driveSubsystem = new DriveSubsystem();
        CommandScheduler.getInstance().setDefaultCommand(driveSubsystem, new DefaultDriveCommand(driveSubsystem));

        driver = new XboxController(0);
        operator = new XboxController(1);
    }

    public static XboxController getDriverController(){
        return driver;
    }

    public static XboxController getOperatorController(){
        return operator;
    }

}
