package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class BeltSubsystem extends SubsystemBase {  

    private WPI_VictorSPX beltMotor;


    public BeltSubsystem(){

        beltMotor = new WPI_VictorSPX(5);
    }

    public void setBeltMotor(double value) {
        beltMotor.set(ControlMode.PercentOutput, value);
    }

}
