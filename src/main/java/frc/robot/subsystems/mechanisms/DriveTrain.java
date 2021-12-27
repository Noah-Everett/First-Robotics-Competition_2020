package frc.robot.subsystems.mechanisms;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Motors;
import frc.robot.constants.Constants_Sensors;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;

public class DriveTrain extends SubsystemBase {
  private double leftMotorSpeed, rightMotorSpeed;
  //Motor controllers
  private final CANSparkMax leftDriveMotor_SparkMax = new CANSparkMax(Constants_Motors.pDRIVELEFTSPARKMAX, Constants_Motors.DRIVELEFTSPARKMAXTYPE);
  private final Spark leftDriveMotor_Spark = new Spark(Constants_Motors.pDRIVELEFTSPARK);
  private final CANSparkMax rightDriveMotor_SparkMax = new CANSparkMax(Constants_Motors.pDRIVERIGHTSPARKMAX, Constants_Motors.DRIVERIGHTSPARKMAXTYPE);
  private final Spark rightDriveMotor_Spark = new Spark(Constants_Motors.pDRIVERIGHTSPARK);
  //Encoders
  private CANEncoder leftEncoder = leftDriveMotor_SparkMax.getEncoder(Constants_Sensors.DRIVELEFTENCODERTYPE, Constants_Sensors.DRIVELEFTENCODERNUMBEROFUPDATESPERROTATION);
  private CANEncoder rightEncoder = rightDriveMotor_SparkMax.getEncoder(Constants_Sensors.DRIVERIGHTENCODERTYPE, Constants_Sensors.DRIVERIGHTENCODERNUMBEROFUPDATESPERROTATION);
  
  public DriveTrain() {
  } 
  
  //Set motor speeds
  public void SetLeftMotors(double leftMotorSpeed){
    this.leftMotorSpeed = leftMotorSpeed;
    // if(leftMotorSpeed > Constants.MOTORMOVEMENTPERCENTTHRESHOLD){
    //   leftDriveMotor_SparkMax.set(leftMotorSpeed);
    //   leftDriveMotor_Spark.set(-leftMotorSpeed);
    // }else{
    //   leftDriveMotor_SparkMax.set(0);
    //   leftDriveMotor_Spark.set(0);
    // }
    leftDriveMotor_SparkMax.set(-leftMotorSpeed);
      leftDriveMotor_Spark.set(leftMotorSpeed);
  }public void SetRightMotors(double rightMotorSpeed){
    this.rightMotorSpeed = rightMotorSpeed;
    // if(rightMotorSpeed > Constants.MOTORMOVEMENTPERCENTTHRESHOLD){
    //   rightDriveMotor_SparkMax.set(rightMotorSpeed);
    //   rightDriveMotor_Spark.set(-rightMotorSpeed);
    // }else{
    // rightDriveMotor_SparkMax.set(0);
    // rightDriveMotor_Spark.set(0);
    // }
    rightDriveMotor_SparkMax.set(rightMotorSpeed);
      rightDriveMotor_Spark.set(-rightMotorSpeed);
  }

  //Read motor speeds
  public double GetLeftMotorSpeed(){
    return leftEncoder.getVelocity();
  }public double GetRightMotorSpeed(){
    return rightEncoder.getVelocity();
  }

  public void AimShooter(double leftSteeringAdjust, double rightSteeringAdjust){
    //leftMotorSpeed += leftSteeringAdjust;
    //rightMotorSpeed += rightSteeringAdjust;
    leftMotorSpeed += .5;
    rightMotorSpeed += -.5;
  }
  
  public void periodic() {
    SmartDashboard.putNumber("Left Drive Motors Set Speed", leftMotorSpeed);
    SmartDashboard.putNumber("Right Drive Motors Set Speed", rightMotorSpeed);
    SmartDashboard.putNumber("Encoder - Left Drive Motors Speed", GetLeftMotorSpeed());
    SmartDashboard.putNumber("Encoder - Right Drive Motors Speed", GetRightMotorSpeed());
  }
}