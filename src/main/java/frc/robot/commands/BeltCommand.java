package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BeltSubsystem;


public class BeltCommand extends CommandBase{
    private final BeltSubsystem beltSubsystem;

    public BeltCommand(BeltSubsystem subsystem) {
        beltSubsystem = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        beltSubsystem.setBeltMotor(.8);
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        beltSubsystem.setBeltMotor(0);
    }

}
