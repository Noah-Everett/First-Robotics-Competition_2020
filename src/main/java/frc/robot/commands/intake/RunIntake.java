package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.constants.Constants_Physical;
import frc.robot.subsystems.mechanisms.Intake;

public class RunIntake extends CommandBase {
  private final Intake m_intake;
  private boolean forwardBackward, buttonLimit;
  private boolean reset;

  public RunIntake(Intake intake_subsystem, boolean forwardBackward, boolean buttonLimit) {
    m_intake = intake_subsystem;
    addRequirements(intake_subsystem);
    this.forwardBackward = forwardBackward;
    this.buttonLimit = buttonLimit;
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("RunIntake", "true");
    reset = true;
  }

  @Override
  public void execute() {
    if(buttonLimit == false){
      m_intake.SetIntakeSpeed(Constants_Physical.INTAKEMOTORSPEED);
      if(reset == true){
        RobotContainer.storedPowerCells += 1;
        reset = false;
      }
    }else if(buttonLimit == true && forwardBackward == true){
      m_intake.SetIntakeSpeed(Constants_Physical.INTAKEMOTORSPEED);
    }else if(buttonLimit == true && forwardBackward == false){
      m_intake.SetIntakeSpeed(-Constants_Physical.INTAKEMOTORSPEED);
    }
  }
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("RunIntake", "false");
    m_intake.SetIntakeSpeed(0);
    reset = true;
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}