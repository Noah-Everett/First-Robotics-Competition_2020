package frc.robot.subsystems.mechanisms;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Pneumatics;
import frc.robot.constants.Constants_Motors;

public class Climber extends SubsystemBase {
  private final DoubleSolenoid piston = new DoubleSolenoid(Constants_Pneumatics.pCLIMBERSOLENOIDONE, Constants_Pneumatics.pCLIMBERSOLENOIDTWO);
  private final Spark motor = new Spark(Constants_Motors.pCLIMBERSPARK);

  public Climber() {
  }

  public void SetClimberSolenoid(boolean upDown){
    if(upDown == true){
      piston.set(Value.kForward);
    }else if(upDown == false){
      piston.set(Value.kReverse);
    }
  }

  public void SetClimberMotor(double climberSpeed){
    motor.set(climberSpeed);
  }

  @Override
  public void periodic() {
  }
}
