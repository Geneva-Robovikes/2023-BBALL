package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OutputSubsystem;

public class OutputCommand extends CommandBase{
    private final OutputSubsystem outputSubsystem;

    public OutputCommand(OutputSubsystem subsystem) {
        outputSubsystem = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        outputSubsystem.setOutputMotors(.4);
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        outputSubsystem.setOutputMotors(0);
    }
}
