package frc.robot.subsystems.mechanisms;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Motors;
import frc.robot.constants.Constants_Pneumatics;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;

public class Combine extends SubsystemBase {
  private final Spark sideMotor = new Spark(Constants_Motors.pCOMBINESIDESPARK);
  private final Spark frontMotor = new Spark(Constants_Motors.pCOMBINEFRONTSPARK);
  private final DoubleSolenoid rightSolenoid = new DoubleSolenoid(Constants_Pneumatics.pCOMBINERIGHTDOUBLESOLENOIDONE, Constants_Pneumatics.pCOMBINERIGHTDOUBLESOLENOIDTWO);
  private final DoubleSolenoid leftSolenoid = new DoubleSolenoid(Constants_Pneumatics.pCOMBINELEFTDOUBLESOLENOIDONE, Constants_Pneumatics.pCOMBINELEFTDOUBLESOLENOIDTWO);

  public Combine() {
  }

  public void SetCombineMotorSpeeds(double combineMotorSpeeds){
    sideMotor.set(-combineMotorSpeeds);
    frontMotor.set(combineMotorSpeeds);
  }

  public void SetCombinePosition(boolean updown){
    if(updown == true){
      rightSolenoid.set(Value.kForward);
      leftSolenoid.set(Value.kForward);
    }else if(updown == false){
      rightSolenoid.set(Value.kReverse);
      leftSolenoid.set(Value.kReverse);
    }
  }

  @Override
  public void periodic() {
  }
}