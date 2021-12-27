package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Sensors;

import com.analog.adis16470.frc.ADIS16470_IMU;

public class ADIS16470 extends SubsystemBase {
  private final ADIS16470_IMU adis16470 = new ADIS16470_IMU();
  private double rawAngle, angle, rate, acceleration;
  private double otherAngle, gyroDegrees;

  public ADIS16470(){
    gyroDegrees = Constants_Sensors.GYRODEGREES;
  }

  //Gyro
  public double GetRawGyroAngle(){
    rawAngle = adis16470.getAngle();
    return rawAngle;
  }public double GetGyroAngle(){
    if(rawAngle > 0){
      angle = rawAngle - (Math.floor(rawAngle/gyroDegrees))*gyroDegrees;
    }else if(rawAngle < 0){
      angle = gyroDegrees + (rawAngle - (Math.floor(rawAngle/gyroDegrees))*gyroDegrees);
    }else if(rawAngle == 0){
      angle = 0;
    }
    return angle;
  }public double GetGyroRate(){
    rate = adis16470.getRate();
    return rate;
  }
  
  public int GetAngle(double angleImput){
    if(angleImput > 0){
      otherAngle = angleImput - (Math.floor(angleImput/gyroDegrees))*gyroDegrees;
    }else if(rawAngle < 0){
      otherAngle = gyroDegrees + (angleImput - (Math.floor(rawAngle/gyroDegrees))*gyroDegrees);
    }else if(rawAngle == 0){
      otherAngle = 0;
    }
    return (int)Math.round(otherAngle);
  }

  //Acelereometer
  public double GetGyroAcceleration(){
    acceleration = Math.sqrt(Math.pow(adis16470.getAccelInstantX(), 2) + Math.pow(adis16470.getAccelInstantY(), 2));
    return acceleration;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Gyro Angle", angle);
    SmartDashboard.putNumber("Gyro Rate", rate);
    SmartDashboard.putNumber("Accelation", acceleration);
  }
}