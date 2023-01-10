package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    private WPI_VictorSPX m_left1, m_left2, m_right1, m_right2;
    private MotorControllerGroup m_left, m_right;
    private double speedConstant = Constants.MOTOR_SPEED_NORMAL;
    private boolean slowModeToggled = false;

    public DriveSubsystem(){
        m_left1 = new WPI_VictorSPX(Constants.LEFT_FRONT_CAN);
        m_left2 = new WPI_VictorSPX(Constants.LEFT_REAR_CAN);
        m_left = new MotorControllerGroup(m_left1, m_left2);

        m_right1 = new WPI_VictorSPX(Constants.RIGHT_FRONT_CAN);
        m_right2 = new WPI_VictorSPX(Constants.RIGHT_REAR_CAN);
        m_right = new MotorControllerGroup(m_right1, m_right2);

    }

    public void setLeftSpeed(double speed){
        m_left.set(speed * speedConstant);
    }

    public void setRightSpeed(double speed){
        m_right.set(speed * speedConstant);
    }

    public void toggleSlowMode(){
        if(!slowModeToggled){
            speedConstant = Constants.MOTOR_SPEED_REDUCED;
        }
        else{
            speedConstant = Constants.MOTOR_SPEED_NORMAL;
        }
    }
    public boolean slowModeStatus(){
        return slowModeToggled;
    }
}
