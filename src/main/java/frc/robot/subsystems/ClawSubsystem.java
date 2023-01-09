package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase{
    public Solenoid so_cone;
    public Solenoid so_cube;
    private Solenoid so_liftclaw;
    public Solenoid so_release;
    private DigitalInput s_cone, s_cube, s_open;

    public ClawSubsystem(){
        so_cone = new Solenoid(9, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_CLAWCONE);
        so_cube = new Solenoid(9, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_CLAWCUBE);
        so_release = new Solenoid(9, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_RELEASE);
        so_liftclaw = new Solenoid(9, PneumaticsModuleType.CTREPCM, Constants.SOLENOID_LIFTCLAW);
        s_cone = new DigitalInput(Constants.CONE_SWITCH_DIO);
        s_cube = new DigitalInput(Constants.CUBE_SWITCH_DIO);
        s_open = new DigitalInput(Constants.OPEN_SWITCH_DIO);
    }

    public void liftClaw(){
        so_liftclaw.set(true);
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
