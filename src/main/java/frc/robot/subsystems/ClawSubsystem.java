package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase{
    private WPI_VictorSPX m_claw;

    public ClawSubsystem(){
        m_claw = new WPI_VictorSPX(Constants.CLAW_CAN);
    }

    public void setClawSpeed(double speed){
        m_claw.set(speed);
    }
}
