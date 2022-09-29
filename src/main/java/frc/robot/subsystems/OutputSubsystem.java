package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OutputSubsystem extends SubsystemBase {
    private VictorSPX leftMotor;
    private VictorSPX rightMotor;

    public OutputSubsystem() {
        leftMotor = new VictorSPX(6);
        rightMotor = new VictorSPX(7);
    }

    public void setOutputMotors(double value) {
        leftMotor.set(ControlMode.PercentOutput, -value);
        rightMotor.set(ControlMode.PercentOutput, -value);
    }

}
