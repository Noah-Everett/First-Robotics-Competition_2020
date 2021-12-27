package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.mechanisms.DriveTrain;
import frc.robot.RobotContainer;
import frc.robot.constants.Constants_Joysticks;
 
public class TankDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField","PMD.SingularField"})
  private final DriveTrain m_driveTrain;
  private double DriveX, DriveY, leftDriveSpeed, rightDriveSpeed;

  public TankDrive(DriveTrain driveTrain_subsystem) {
    m_driveTrain = driveTrain_subsystem;
    addRequirements(driveTrain_subsystem);
  }
 
  @Override
  public void initialize() {
    SmartDashboard.putString("TankDrive", "true");
  }
  
  @Override
  public void execute() {
    DriveX = RobotContainer.joystickLD.getRawAxis(Constants_Joysticks.axisX) * Constants_Joysticks.kP_TURN;
    DriveY = RobotContainer.joystickRD.getRawAxis(Constants_Joysticks.axisY);
    leftDriveSpeed = DriveX - DriveY;
    rightDriveSpeed = -DriveX - DriveY;
    /*
    if(DriveX != 0){
      leftDriveSpeed = DriveX - DriveY;
      rightDriveSpeed = -DriveX - DriveY;
    }else if(DriveX == 0){
      if(m_driveTrain.GetLeftMotorSpeed() == m_driveTrain.GetRightMotorSpeed()){
        leftDriveSpeed = DriveX - DriveY; //FIGURE OUT HOW TO USE ENCODERS TO DRIVE STRAIGHT. TRYING TO FIGURE OUT HOW TO MAKE LEFTDRIVESPEED START AT 1 SO IT CAN BE SUBTRACTED FROM
        rightDriveSpeed = -DriveX - DriveY;
      }
    }
      if(m_driveTrain.GetLeftMotorSpeed() != m_driveTrain.GetRightMotorSpeed()){
        if(m_driveTrain.GetLeftMotorSpeed() > m_driveTrain.GetRightMotorSpeed()){
          //leftDriveSpeed = leftDriveSpeed - Constants.DRIVETRAINWHEELSPEEDSADJUSTMENTVALUE;
        }else if(m_driveTrain.GetLeftMotorSpeed() < m_driveTrain.GetRightMotorSpeed()){
          //rightDriveSpeed = rightDriveSpeed - Constants.DRIVETRAINWHEELSPEEDSADJUSTMENTVALUE;
        }
      }
    SmartDashboard.putNumber("Left DriveTrain Motor Speed", m_driveTrain.GetLeftMotorSpeed());
    SmartDashboard.putNumber("Right DriveTrain Motor Speed", m_driveTrain.GetRightMotorSpeed());
*/
    m_driveTrain.SetLeftMotors(leftDriveSpeed);
    m_driveTrain.SetRightMotors(rightDriveSpeed);
  }
  
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.SetLeftMotors(0);
    m_driveTrain.SetRightMotors(0);
    SmartDashboard.putString("TankDrive", "false");
  }
  
  @Override
  public boolean isFinished() {
    return false;
  }
}