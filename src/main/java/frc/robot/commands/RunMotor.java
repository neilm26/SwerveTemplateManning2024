// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class RunMotor extends Command {
  private Intake intake;
  private double speedLeft;
  private double speedRight;

  /** Creates a new test. */
  public RunMotor(Intake intake, double speedLeft, double speedRight) {
    this.intake = intake;
    this.speedLeft = speedLeft;
    this.speedRight = speedRight;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.testLeft(speedLeft);
    intake.testRight(speedRight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.testLeft(0);
    intake.testRight(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
