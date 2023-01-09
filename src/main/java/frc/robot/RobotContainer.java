package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.DefaultElevatorCommand;
import frc.robot.commands.DefaultClawCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.ClawSubsystem;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem;
    private final ElevatorSubsystem elevatorSubsystem;
    private final ClawSubsystem clawSubsystem;

    private static XboxController driver;
    private static XboxController operator;

    public RobotContainer(){
        //CONTROLLERS
        driver = new XboxController(Constants.XBOX_PORT1);
        operator = new XboxController(Constants.XBOX_PORT2);
        //DRIVE
        driveSubsystem = new DriveSubsystem();
        CommandScheduler.getInstance().setDefaultCommand(driveSubsystem, new DefaultDriveCommand(driveSubsystem));
        
        //ELEVATOR
        elevatorSubsystem = new ElevatorSubsystem();
        CommandScheduler.getInstance().setDefaultCommand(elevatorSubsystem, new DefaultElevatorCommand(elevatorSubsystem));
        
        //CLAW
        clawSubsystem = new ClawSubsystem();
        CommandScheduler.getInstance().setDefaultCommand(clawSubsystem, new DefaultClawCommand(clawSubsystem));
    }

    public static XboxController getDriverController(){
        return driver;
    }

    public static XboxController getOperatorController(){
        return operator;
    }

}
