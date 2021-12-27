package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants_Physical;
import frc.robot.subsystems.mechanisms.Combine;

public class RunCombine extends CommandBase {
  private final Combine m_combine;

  public RunCombine(Combine combine_subsystem) {
    m_combine = combine_subsystem;
    addRequirements(combine_subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_combine.SetCombinePosition(false);
    m_combine.SetCombineMotorSpeeds(Constants_Physical.COMBINEMOTORSPEEDS);
  }

  @Override
  public void end(boolean interrupted) {
    m_combine.SetCombinePosition(true);
    m_combine.SetCombineMotorSpeeds(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
