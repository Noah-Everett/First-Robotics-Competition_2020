package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.constants.Constants_Physical;
import frc.robot.subsystems.mechanisms.Intake;
import frc.robot.subsystems.mechanisms.Shooter;

public class RunShooter extends CommandBase {
  private final Shooter m_shooter;
  private final Intake m_intake;
  private Timer timer = new Timer();
  
  public RunShooter(Shooter shooter_subsystem, Intake intake_subsystem) {
    m_shooter = shooter_subsystem;
    m_intake = intake_subsystem;
    addRequirements(shooter_subsystem, intake_subsystem);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    if(timer.get() <= Constants_Physical.SHOOTERSPEEDUPTIME){
      m_shooter.SetShooterSpeed(Constants_Physical.SHOOTERWHEELSPEED);
      m_intake.SetIntakeSpeed(-Constants_Physical.INTAKEMOTORSPEED/4);
    }else if(timer.get() > Constants_Physical.SHOOTERSPEEDUPTIME){
      m_shooter.SetShooterSpeed(Constants_Physical.SHOOTERWHEELSPEED);
      m_intake.SetIntakeSpeed(Constants_Physical.INTAKEMOTORSPEED);
      m_intake.SetStoredPowerCells(0);
      RobotContainer.storedPowerCells = 0;
    }else{
      m_shooter.SetShooterSpeed(0);
      m_intake.SetIntakeSpeed(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    timer.stop();
    m_shooter.SetShooterSpeed(0);
    m_intake.SetIntakeSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
