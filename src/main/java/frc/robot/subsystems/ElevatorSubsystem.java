package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase{
    private WPI_VictorSPX m_elevator1, m_elevator2;
    private MotorControllerGroup m_elevatorGroup;
    private Encoder encoder = new Encoder(Constants.ENCODER_DIO1, Constants.ENCODER_DIO2, false, Encoder.EncodingType.k2X);
    

    public ElevatorSubsystem(){
        m_elevator1 = new WPI_VictorSPX(Constants.ELEVATOR_CAN1);
        m_elevator2 = new WPI_VictorSPX(Constants.ELEVATOR_CAN2);
        m_elevatorGroup = new MotorControllerGroup(m_elevator1, m_elevator2);
        encoder.setDistancePerPulse(4./256.);
    }

    public void setElevatorSpeed(double speed){
        m_elevatorGroup.set(speed);
    }
    
    public void encoderRate(){
        encoder.getRate();
    }

    public void encoderPosition(){
        encoder.getDistance();
    }

    public void encoderReset(){
        encoder.reset();
    }
}
