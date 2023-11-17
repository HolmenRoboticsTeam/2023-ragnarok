// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {

private WPI_TalonSRX m_RotatationMotor = new WPI_TalonSRX(0);
private WPI_TalonSRX m_AngleMotor = new WPI_TalonSRX(1);

  /** Creates a new Turret. */
  public Turret() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
