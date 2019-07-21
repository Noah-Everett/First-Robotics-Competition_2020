/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Move extends Command {
  double m_time, m_LeftSpeed, m_RightSpeed;
  public Move(double time, double LeftSpeed, double RightSpeed) {
    m_time = time;
    m_LeftSpeed = LeftSpeed;
    m_RightSpeed = RightSpeed;
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveTrain.LeftMotors(m_LeftSpeed);
    Robot.driveTrain.RightMotors(m_RightSpeed);
    setTimeout(m_time);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.LeftMotors(0);
    Robot.driveTrain.RightMotors(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
