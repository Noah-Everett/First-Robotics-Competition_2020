package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants_Physical;
import frc.robot.subsystems.mechanisms.Climber;
import frc.robot.subsystems.mechanisms.Combine;

public class RunClimber extends CommandBase {
  private Climber m_climber;
  private Combine m_combine;
  private boolean pneumaticUpDown, motorOnOff, climberOnOff;
  
  public RunClimber(Climber climber_subsystem, Combine combine_subsystem, boolean pneumaticUpDown, boolean motorOnOff, boolean climberOnOff) {
    m_climber = climber_subsystem;
    m_combine = combine_subsystem;
    this.pneumaticUpDown = pneumaticUpDown;
    this.motorOnOff = motorOnOff;
    this.climberOnOff = climberOnOff;
    addRequirements(climber_subsystem);
  }

  @Override
  public void initialize() {
    m_climber.SetClimberMotor(0);
    m_climber.SetClimberSolenoid(true);
  }

  @Override
  public void execute() {
    if(climberOnOff == true){
      // Climber pneumatics
      if(pneumaticUpDown == true){
        m_climber.SetClimberSolenoid(true);
      }else if(pneumaticUpDown == false){
        m_climber.SetClimberSolenoid(false);
      }

      //Climber motor
      if(motorOnOff == true){
        m_climber.SetClimberMotor(Constants_Physical.CLIMBERMOTORSPEED);
      }else if(motorOnOff == false){
        m_climber.SetClimberMotor(0);
      }

      // Combine pneumatics
      if(pneumaticUpDown == true && motorOnOff == true){
        m_combine.SetCombinePosition(false);
      }else{
        m_combine.SetCombinePosition(true);
      }
    }else if(climberOnOff == false){
      m_climber.SetClimberSolenoid(false);
      m_climber.SetClimberMotor(-Constants_Physical.CLIMBERMOTORSPEED);
    }
    
  }

  @Override
  public void end(boolean interrupted) {
    m_climber.SetClimberMotor(0);
    m_climber.SetClimberSolenoid(true);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
