package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.sensors.LimeLight;

public class FindPowerPort extends CommandBase {
  private final LimeLight m_limeLight;
  private int zoom;
  
  public FindPowerPort(LimeLight limeLight_subsystem, int zoom) {
    m_limeLight = limeLight_subsystem;
    this.zoom = zoom;
    addRequirements(limeLight_subsystem);
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("FindPowerPort", "true");
  }

  @Override
  public void execute() {
    if(zoom == 1){
      m_limeLight.SetPowerPort_StandardPipeline();
    }else if(zoom == 2){
      m_limeLight.SetPowerPort_TwoPipeline();
    }else if(zoom == 3){
      m_limeLight.SetPowerPort_ThreePipeline();
    }
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("FindPowerPort", "false");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
