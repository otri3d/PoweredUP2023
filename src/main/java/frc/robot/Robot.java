// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * Instantiate motors, sensors, create variables etc
 */
public class Robot extends TimedRobot {
	private RobotContainer m_container;

	@Override
	public void robotInit() {
		m_container = new RobotContainer();
	}

	@Override
	public void robotPeriodic() {
		CommandScheduler.getInstance().run(); //DO NOT DELETE ME
	}

	@Override
	public void teleopPeriodic() {
		CommandScheduler.getInstance().run(); //DO NOT DELETE ME
	}

}