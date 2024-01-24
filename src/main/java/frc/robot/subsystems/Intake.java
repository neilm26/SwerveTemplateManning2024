// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.SparkRelativeEncoder;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkLowLevel.MotorType;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  // double check spark IDs every time test board is reconnected if malfunctioning
  private CANSparkMax rollerMotor = new CANSparkMax(32, MotorType.kBrushless);
  private CANSparkMax motorLeft = new CANSparkMax(62, MotorType.kBrushless);
  private CANSparkMax motorRight = new CANSparkMax(15, MotorType.kBrushless);

  private RelativeEncoder encoderLeft;
  private RelativeEncoder encoderRight;

  private SparkPIDController leftController;
  private SparkPIDController rightController;

  public Intake() {
    rollerMotor.setIdleMode(IdleMode.kBrake);
    motorLeft.setIdleMode(IdleMode.kBrake);
    motorRight.setIdleMode(IdleMode.kBrake);

    encoderLeft = motorLeft.getEncoder(SparkRelativeEncoder.Type.kHallSensor, 42);
    encoderRight = motorRight.getEncoder(SparkRelativeEncoder.Type.kHallSensor, 42);
    motorLeft.setSmartCurrentLimit(75);
    motorRight.setSmartCurrentLimit(75);
    rollerMotor.setSmartCurrentLimit(75);
    encoderLeft.setVelocityConversionFactor(Constants.CONVERSIONFACTOR);
    encoderRight.setVelocityConversionFactor(Constants.CONVERSIONFACTOR);

    SparkPIDController leftController = motorLeft.getPIDController();
    leftController.setFeedbackDevice(encoderLeft);
    SparkPIDController rightController = motorRight.getPIDController();
    rightController.setFeedbackDevice(encoderRight);
    motorLeft.burnFlash();
    motorRight.burnFlash();
  }

  public void testLeft(double speed) {
    // motorLeft.set(speed);

    // leftController.setReference(Math.PI / 2, ControlType.kVelocity);
    // rightController.setReference(Math.PI / 2, ControlType.kVelocity);
  }

  public void testRight(double speed) {
    motorRight.set(speed);
  }

  public void setLeftOutput() {

  }

  public void setShooterSpeed(double speed) {
    // leftMotor.set(-speed);
    // rightMotor.set(speed);
  }

  public void setRollerSpeed(double speed) {
    rollerMotor.set(speed);
  }

  // public double leftMotorOutput() {
  // // return leftMotor.get();
  // }

  // public double rightMotorOutput() {
  // // return rightMotor.get();
  // }

  public double rollerOutput() {
    return rollerMotor.get();
  }

  @Override
  public void periodic() {
    // SmartDashboard.putNumber("right motor dutput", rightMotorOutput());
    // SmartDashboard.putNumber("left motor output", leftMotorOutput());
    SmartDashboard.putNumber("roller motor output", rollerOutput());
  }
}
