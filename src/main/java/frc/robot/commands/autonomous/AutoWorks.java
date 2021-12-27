package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants_Physical;
import frc.robot.subsystems.mechanisms.DriveTrain;
import frc.robot.subsystems.mechanisms.Intake;
import frc.robot.subsystems.mechanisms.Shooter;

public class AutoWorks extends CommandBase {
  private final DriveTrain m_driveTrain;
  private final Intake m_intake;
  private final Shooter m_shooter;
  private Timer timer = new Timer();
  
  public AutoWorks(DriveTrain driveTrain_subsystem, Intake intake_subsystem, Shooter shooter_subsystem) {
    m_driveTrain = driveTrain_subsystem;
    m_intake = intake_subsystem;
    m_shooter = shooter_subsystem;
    addRequirements(driveTrain_subsystem, intake_subsystem, shooter_subsystem);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    if(timer.get() <= Constants_Physical.AUTONOMOUSWAITTIME){
      m_driveTrain.SetLeftMotors(0);
      m_driveTrain.SetRightMotors(0);
    }
    if(timer.get() > Constants_Physical.AUTONOMOUSWAITTIME && 
    timer.get() < (Constants_Physical.AUTONOMOUSWAITTIME + Constants_Physical.AUTONOMOUSDRIVETIME)){
      m_driveTrain.SetLeftMotors(0.25);
      m_driveTrain.SetRightMotors(0.2);
    }else if(timer.get() > (Constants_Physical.AUTONOMOUSWAITTIME + Constants_Physical.AUTONOMOUSDRIVETIME) && 
    timer.get() < (Constants_Physical.AUTONOMOUSWAITTIME + Constants_Physical.AUTONOMOUSDRIVETIME + Constants_Physical.SHOOTERSPEEDUPTIME)){
      m_driveTrain.SetLeftMotors(0);
      m_driveTrain.SetRightMotors(0);
      m_intake.SetIntakeSpeed(0);
      m_shooter.SetShooterSpeed(Constants_Physical.SHOOTERWHEELSPEED);
    }else if(timer.get() > (Constants_Physical.AUTONOMOUSWAITTIME + Constants_Physical.AUTONOMOUSDRIVETIME + Constants_Physical.SHOOTERSPEEDUPTIME) && 
    timer.get() < (Constants_Physical.AUTONOMOUSWAITTIME + Constants_Physical.AUTONOMOUSDRIVETIME + Constants_Physical.SHOOTERSPEEDUPTIME + Constants_Physical.AUTONOMOUSTIMETOSHOOT)){
      m_driveTrain.SetLeftMotors(0);
      m_driveTrain.SetRightMotors(0);
      m_intake.SetIntakeSpeed(Constants_Physical.INTAKEMOTORSPEED);
      m_shooter.SetShooterSpeed(Constants_Physical.SHOOTERWHEELSPEED);
    }else{
      m_driveTrain.SetLeftMotors(0);
      m_driveTrain.SetRightMotors(0);
      m_intake.SetIntakeSpeed(0);
      m_shooter.SetShooterSpeed(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    timer.stop();
    m_driveTrain.SetLeftMotors(0);
    m_driveTrain.SetRightMotors(0);
    m_intake.SetIntakeSpeed(0);
    m_shooter.SetShooterSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
