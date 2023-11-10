// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** Add your docs here. */
public class DriveIOReal {

    private WPI_TalonSRX m_talonL;
    private WPI_TalonSRX m_talonR;

    public DriveIOReal() {

        this.m_talonL = new WPI_TalonSRX(1);
        this.m_talonR = new WPI_TalonSRX(0);

        this.m_talonL.configFactoryDefault();
        this.m_talonR.configFactoryDefault();

        this.m_talonL.setInverted(false);
        this.m_talonR.setInverted(true);

    }

}
