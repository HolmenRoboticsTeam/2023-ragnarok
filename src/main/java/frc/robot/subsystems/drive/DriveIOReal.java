// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** Add your docs here. */
public class DriveIOReal {

    private WPI_TalonSRX m_talonFrontLeft = new WPI_TalonSRX(0);
    private WPI_TalonSRX m_talonBackLeft = new WPI_TalonSRX(1);

    private WPI_TalonSRX m_talonFrontRight = new WPI_TalonSRX(2);
    private WPI_TalonSRX m_talonBackRight = new WPI_TalonSRX(3);

    private DifferentialDrive m_DifferentialDrive = new DifferentialDrive(m_talonFrontLeft, m_talonFrontRight);

    public DriveIOReal() {

        this.m_talonFrontLeft.configFactoryDefault();
        this.m_talonBackLeft.configFactoryDefault();
        this.m_talonFrontRight.configFactoryDefault();
        this.m_talonBackRight.configFactoryDefault();

        this.m_talonFrontRight.setInverted(true);
        this.m_talonFrontLeft.setInverted(false);

        this.m_talonBackRight.follow(m_talonFrontRight);
        this.m_talonBackLeft.follow(m_talonFrontLeft);

        this.m_talonFrontRight.configOpenloopRamp(0.5);
        this.m_talonFrontLeft.configOpenloopRamp(0.5);
        this.m_talonFrontRight.configClosedloopRamp(0.5);
        this.m_talonFrontLeft.configClosedloopRamp(0.5);
    }

    /*
     * Drive method for drivetrain
     *
     * @param xSpeed       The robot's speed along the X axis
     * @param zRotation    The robot's rotation rate around the Z axis
     * @param squareInputs Decreases the input sensitivity at low speeds.
     */
    public void drive(double xSpeed, double zRotation, boolean isSquare) {
        m_DifferentialDrive.arcadeDrive(xSpeed, zRotation, isSquare);
    }

}
