// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  private final WPI_TalonSRX shooter = new WPI_TalonSRX(5);

  Compressor comp = new Compressor(PneumaticsModuleType.REVPH);
  DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);


  public ShooterSubsystem() {}

  public void solenoidOut(){
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void solenoidIn(){
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void solenoidOff(){
    solenoid.set(DoubleSolenoid.Value.kOff);
  }

  public void motorControl(double speed){
    shooter.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
