package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase{
    private WPI_VictorSPX m_claw, m_pivot;
    private DigitalInput s_cone, s_cube, s_open;

    public ClawSubsystem(){
        m_claw = new WPI_VictorSPX(Constants.CLAW_CAN);
        m_pivot = new WPI_VictorSPX(Constants.PIVOT_CAN);
        s_cone = new DigitalInput(Constants.CONE_SWITCH_DIO);
        s_cube = new DigitalInput(Constants.CUBE_SWITCH_DIO);
        s_open = new DigitalInput(Constants.OPEN_SWITCH_DIO);
    }

    public void setClawSpeed(double speed){
        m_claw.set(speed);
    }

    public boolean hasCone(){
        return s_cone.get();
    }

    public boolean hasCube(){
        return s_cube.get();
    }
    
    public boolean isOpen(){
        return s_open.get();
    }
}
