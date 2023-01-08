package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase{
    private WPI_VictorSPX m_elevator1, m_elevator2;
    private MotorControllerGroup m_elevatorGroup;
    private DigitalInput upper_limit, lower_limit;
    private Encoder encoder = new Encoder(Constants.ENCODER_DIO1, Constants.ENCODER_DIO2, false, Encoder.EncodingType.k2X);
    

    public ElevatorSubsystem(){ //Declare variables
        m_elevator1 = new WPI_VictorSPX(Constants.ELEVATOR_CAN1);
        m_elevator2 = new WPI_VictorSPX(Constants.ELEVATOR_CAN2);
        
        m_elevatorGroup = new MotorControllerGroup(m_elevator1, m_elevator2);
        upper_limit = new DigitalInput(Constants.UPPER_LIFT_LIMIT_DIO);
        lower_limit = new DigitalInput(Constants.LOWER_LIFT_LIMIT_DIO);
        encoder.setDistancePerPulse(4./256.);
    }

    public void setElevatorSpeed(double speed){ //Sets the elevator speed
        m_elevatorGroup.set(speed);
    }
    
    public void encoderRate(){ //Gets the rate of speed of the elevator
        encoder.getRate();
    }

    public double encoderPosition(){ //Gets the distance the elevator has travelled compared to the starting point
        encoder.getDistance();
    }

    public void encoderReset(){ 
        encoder.reset();
    }
    public void stopElevator(){ 
        m_elevatorGroup.set(0);
    }

    public int limitSwitchHit(){  //Method to return true when limit switches get hit
        if(!upper_limit.get()){
            return 1;
        }else if(!lower_limit.get()){
            return 2;
        }
        return 3;
    }
}
