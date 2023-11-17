// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//hello world
/** Add your docs here. */
public class DriveIOReal {

    private WPI_TalonSRX m_talonFrontLeft = new WPI_TalonSRX(0);
    private WPI_TalonSRX m_talonBackLeft = new WPI_TalonSRX(1);

    private WPI_VictorSPX m_victorFrontRight = new WPI_VictorSPX(2);
    private WPI_VictorSPX m_victorBackRight = new WPI_VictorSPX(3);

    private WPI_VictorSPX m_victorHRight = new WPI_VictorSPX(4);
    private WPI_VictorSPX m_victorHLeft = new WPI_VictorSPX(5);

    private DifferentialDrive m_DifferentialDrive = new DifferentialDrive(m_talonFrontLeft, m_victorFrontRight);

    public DriveIOReal() {

        this.m_talonFrontLeft.configFactoryDefault();
        this.m_talonBackLeft.configFactoryDefault();
        this.m_victorFrontRight.configFactoryDefault();
        this.m_victorBackRight.configFactoryDefault();

        this.m_victorFrontRight.setInverted(true);
        this.m_talonFrontLeft.setInverted(false);

        this.m_victorBackRight.follow(m_victorFrontRight);
        this.m_talonBackLeft.follow(m_talonFrontLeft);
        this.m_victorHRight.follow(m_victorHLeft);

        this.m_victorFrontRight.configOpenloopRamp(0.5);
        this.m_talonFrontLeft.configOpenloopRamp(0.5);
        this.m_victorFrontRight.configClosedloopRamp(0.5);
        this.m_talonFrontLeft.configClosedloopRamp(0.5);
    }
//hello world
    /**
     * Drive method for drivetrain
     *
     * @param xSpeed       The robot's speed along the X axis
     * @param ySpeed       The robot's speed along the Y axis
     * @param zRotation    The robot's rotation rate around the Z axis
     * @param squareInputs Decreases the input sensitivity at low speeds.
     */
    public void drive(double xSpeed, double ySpeed, double zRotation, boolean isSquare) {
        m_DifferentialDrive.arcadeDrive(ySpeed, zRotation, isSquare);
        m_victorHLeft.set(xSpeed);
    }

}
