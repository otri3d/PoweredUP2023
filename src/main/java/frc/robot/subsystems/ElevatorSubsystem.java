package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase{
    private WPI_VictorSPX m_elevator1, m_elevator2;
    private MotorControllerGroup m_elevatorGroup;

    public ElevatorSubsystem(){
        m_elevator1 = new WPI_VictorSPX(Constants.ELEVATOR_CAN1);
        m_elevator2 = new WPI_VictorSPX(Constants.ELEVATOR_CAN2);
        m_elevatorGroup = new MotorControllerGroup(m_elevator1, m_elevator2);
    }

    public void raise(double speed){
        m_elevatorGroup.set(speed);
    }

    public void lower(double speed){
        m_elevatorGroup.set(-speed);
    }    
}
