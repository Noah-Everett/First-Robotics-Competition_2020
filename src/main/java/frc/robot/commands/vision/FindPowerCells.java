package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.sensors.LimeLight;

public class FindPowerCells extends CommandBase {
  private final LimeLight m_limeLight;
  
  public FindPowerCells(LimeLight limeLight_subsystem) {
    m_limeLight = limeLight_subsystem;
    addRequirements(limeLight_subsystem);
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("FindPowerCells", "true");
  }

  @Override
  public void execute() {
    m_limeLight.SetPowerCellPipeline();
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("FindPowerCells", "false");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}