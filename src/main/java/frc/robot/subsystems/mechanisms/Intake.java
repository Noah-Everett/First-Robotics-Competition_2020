package frc.robot.subsystems.mechanisms;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Motors;

import com.revrobotics.CANSparkMax;

public class Intake extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(Constants_Motors.pINTAKESPARKMAX, Constants_Motors.INTAKESPARKMAXTYPE);
  private int m_storedPowerCells;

  public Intake() {
  }

  public void SetIntakeSpeed(double intakeSpeed){
    intakeMotor.set(intakeSpeed);
  }

  public void SetStoredPowerCells(int storedPowerCells){
    m_storedPowerCells = storedPowerCells;
  }public void AddStoredPowerCells(int addPowerCells){
    m_storedPowerCells += addPowerCells;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Number Stored Balls", m_storedPowerCells);
  }
}
