// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants.ControllerPorts;
import frc.robot.commands.Hinge;
import frc.robot.commands.Roller;
import frc.robot.commands.RunMotor;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Subsystems
  private Intake intake = new Intake();

  // Commands
  private Command roller = new Roller(intake, 0.4);
  // private Command hingeForward = new Hinge(intake, -0.5, 0.5);
  private Command hingeReverse = new Hinge(intake, -0.5);

  private Command left = new RunMotor(intake, -0.5, 0.5);
  private Command right = new RunMotor(intake, 0.5, -0.5);
  // Command XboxControllers return buttons as trigger objects so they can be
  // binded directly to commands (removes the need for IO class)
  private final CommandXboxController driverController = new CommandXboxController(ControllerPorts.DRIVER_CONTROLLER);
  private final CommandXboxController operatorController = new CommandXboxController(
      ControllerPorts.OPERATOR_CONTROLLER);

  public RobotContainer() {
    configureButtonBindings();
  }

  public void configureButtonBindings() {
    driverController.b().whileTrue(roller);

    driverController.rightTrigger().whileTrue(left);
    driverController.leftTrigger().whileTrue(left);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
