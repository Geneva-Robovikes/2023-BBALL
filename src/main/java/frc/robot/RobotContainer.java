package frc.robot;

import java.io.IOException;
import java.nio.file.Path;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DefaultCommand;


import frc.robot.commands.BeltCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OutputCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.BeltSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.OutputSubsystem;

public class RobotContainer {
  private XboxController controller = new XboxController(0);

  public final DriveSubsystem driveSubsystem = new DriveSubsystem();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final OutputSubsystem launchSubsystem = new OutputSubsystem();
  public final BeltSubsystem beltSubsystem = new BeltSubsystem();


  //Add Teleop Commands Here!
  public final DriveCommand driveCommand = new DriveCommand(driveSubsystem, controller);
  public final BeltCommand beltCommand = new BeltCommand(beltSubsystem);
  public final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, beltSubsystem);
  public final OutputCommand outputCommand = new OutputCommand(launchSubsystem);
  public final DefaultCommand defaultCommand = new DefaultCommand(driveSubsystem);

  
  public RobotContainer() {
    CommandScheduler.getInstance().setDefaultCommand(driveSubsystem, defaultCommand);
    configureButtonBindings();
  }

    
  private void configureButtonBindings() {
    JoystickButton intakeButton = new JoystickButton(controller, 1);
    JoystickButton launchButton = new JoystickButton(controller, 4);
    JoystickButton beltButton = new JoystickButton(controller, 3);

    intakeButton.toggleWhenPressed(intakeCommand);
    launchButton.toggleWhenPressed(outputCommand);
    beltButton.toggleWhenPressed(beltCommand);
  }
}