package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BeltSubsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeCommand extends CommandBase{
    private final IntakeSubsystem intakeSubsystem;
    public IntakeCommand(IntakeSubsystem intakeSubsystem, BeltSubsystem beltSubsystem) {
        this.intakeSubsystem = intakeSubsystem;


        addRequirements(intakeSubsystem, beltSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.setRollerMotor(0.4);


    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.setRollerMotor(0);
    }
}
