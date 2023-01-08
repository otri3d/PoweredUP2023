package frc.robot.commands;

import java.nio.file.ProviderMismatchException;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorHeight extends CommandBase {
    private final ElevatorSubsystem s_elevator;
    double setpoints;
    
    private final PIDController pid = new PIDController(1, 1, 1);


    public SetElevatorHeight(ElevatorSubsystem elevator, double setpoint){
        s_elevator = elevator;
        setpoints = setpoint;


    }

    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
        s_elevator.setElevatorSpeed(pid.calculate(setpoints));

    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        super.execute();
        s_elevator.setElevatorSpeed(pid.calculate(s_elevator.encoderPosition(), setpoints));
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
        s_elevator.setElevatorSpeed(0);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return pid.atSetpoint();
    }


}
