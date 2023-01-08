package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorHeightCommand extends CommandBase {
    private final ElevatorSubsystem s_elevator;
    double setpoints;
    
    private final PIDController pid = new PIDController(1, 1, 1); //TODO calculate gains


    public SetElevatorHeightCommand(ElevatorSubsystem elevator, double setpoint){
        s_elevator = elevator;
        setpoints = setpoint;
    }

    
    @Override
    public void initialize() {
        s_elevator.setElevatorSpeed(pid.calculate(setpoints));

    }

    @Override
    public void execute() {
        s_elevator.setElevatorSpeed(pid.calculate(s_elevator.encoderPosition(), setpoints));
    }

    @Override
    public void end(boolean interrupted) {
        s_elevator.setElevatorSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }


}
