// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class DrivetrainSubsystem extends SubsystemBase {
  
  private final WPI_VictorSPX frontLeft = new WPI_VictorSPX(1);
  private final WPI_VictorSPX frontRight = new WPI_VictorSPX(3);
  private final WPI_VictorSPX backLeft = new WPI_VictorSPX(0);
  private final WPI_VictorSPX backRight = new WPI_VictorSPX(2);

  private final MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
  private final MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);

  DifferentialDrive drive = new DifferentialDrive(left, right);

  public DrivetrainSubsystem() {
    left.setInverted(true);
  }

  public void drive(DoubleSupplier x, DoubleSupplier zRot){
    drive.arcadeDrive(0.5*x.getAsDouble(), 0.5*zRot.getAsDouble());
  }

  @Override
  public void periodic() {}
}
