package frc.robot.subsystems.mechanisms;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Motors;
import frc.robot.constants.Constants_Sensors;
import frc.robot.constants.Constants_Physical;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends SubsystemBase {
  private CANSparkMax motor = new CANSparkMax(Constants_Motors.pSHOOTERSPARKMAX, Constants_Motors.SHOOTERSPARKMAXTYPE);
  private CANEncoder encoder = motor.getEncoder(Constants_Sensors.SHOOTERENCODERTYPE, Constants_Sensors.SHOOTERENCODERNUMBEROFREVOLUTIONSPERROTATION);
  private Servo servoHood = new Servo(Constants_Motors.pSERVOHOOD);
  private Servo servoLimeLight = new Servo(Constants_Motors.pSERVOLIMELIGHT);
  private double shooterWheelSpeed, putshooterwheelspeed;

  public Shooter() {
    motor.restoreFactoryDefaults();
  }

  //Wheel speed calabrator
  public double ShooterWheelSpeed(double distince){
    if(distince >= Constants_Physical.DISTANCEFROMPOWERPORTWITHFULLPOWERONSHOOTERWHEEL){
      shooterWheelSpeed = 1.0;
    }else if(distince < Constants_Physical.DISTANCEFROMPOWERPORTWITHFULLPOWERONSHOOTERWHEEL){
      shooterWheelSpeed = 0.5;
    }
    return shooterWheelSpeed;
  }

  //Shooter wheel speeds
  public void SetShooterSpeed(double putshooterwheelspeed) {
    motor.set(putshooterwheelspeed);
  }public double GetShooterEncoderSpeed(){
    return encoder.getVelocity();
  }
  
  //Set angles
  public void SetShooterHoodAngle(double angle){
    servoHood.set(angle);
  }public void SetLimeLightAngle(double angleLimeLight){
    servoLimeLight.set(angleLimeLight);
  }

  @Override 
  public void periodic() {
    SmartDashboard.putNumber("Encoder - Shooter Wheel Speed", GetShooterEncoderSpeed());
    SmartDashboard.putNumber("Shooter Wheel Set Speed", putshooterwheelspeed);
  }
}
