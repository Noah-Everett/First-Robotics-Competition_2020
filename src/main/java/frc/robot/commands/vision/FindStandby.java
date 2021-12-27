package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.sensors.LimeLight;

public class FindStandby extends CommandBase {
  private final LimeLight m_limeLight;
  
  public FindStandby(LimeLight limeLight_subsystem) {
    m_limeLight = limeLight_subsystem;
    addRequirements(limeLight_subsystem);
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("FindStandby", "true");
  }

  @Override
  public void execute() {
    m_limeLight.SetStandbyPipeline();
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("FindStandby", "false");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}