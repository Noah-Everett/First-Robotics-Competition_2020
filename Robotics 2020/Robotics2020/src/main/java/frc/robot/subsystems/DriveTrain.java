/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.GatorDrive;
public class DriveTrain extends Subsystem {
  Spark FrontLeft = new Spark(RobotMap.MOTOR_FRONTLEFT);
  Spark FrontRight = new Spark(RobotMap.MOTOR_FRONTRIGHT);
  Spark RearLeft = new Spark(RobotMap.MOTOR_REARLEFT);
  Spark RearRight = new Spark(RobotMap.MOTOR_REARRIGHT);
  public double DriveY_Axis = Robot.m_oi.Joystick_LDriver.getRawAxis(RobotMap.AXISNUMBER_Y);
  public double DriveX_Axis = Robot.m_oi.Joystick_RDriver.getRawAxis(RobotMap.AXISNUMBER_X);
  double DriveSpeed_Left;
  double DriveSpeed_Right;
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GatorDrive());
  }
  public void LeftMotors(double DriveSpeed_Left){
	  FrontLeft.set(DriveSpeed_Left);
    RearLeft.set(DriveSpeed_Left);
  }
  public void RightMotors(double DriveSpeed_Right){
    FrontRight.set(DriveSpeed_Right);
    RearRight.set(DriveSpeed_Right);
  }
}
