package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.constants.Constants_Joysticks;
import frc.robot.constants.Constants_Physical;
import frc.robot.subsystems.mechanisms.Combine;
import frc.robot.subsystems.mechanisms.DriveTrain;
import frc.robot.subsystems.mechanisms.Intake;
import frc.robot.subsystems.mechanisms.Shooter;
import frc.robot.subsystems.mechanisms.Pneumatics;
import frc.robot.subsystems.sensors.LimeLight;

public class ShootAdjust extends CommandBase {
  private final Shooter m_shooter;
  private final Intake m_intake;
  private final DriveTrain m_driveTrain;
  private final LimeLight m_limeLight;
  private final Combine m_combine;
  private final Pneumatics m_pneumatics;
  private double errorD, P, I, D, lastErrorX, lastTime, dt;
  private double DriveX, DriveY, leftDriveSpeed, rightDriveSpeed, angle;
  private Timer timer = new Timer();
  
  public ShootAdjust(Shooter shooter_subsystem, Intake intake_subsystem, DriveTrain driveTrain_subsystem, LimeLight limeLight_subsystem, Combine combine_subsystem, Pneumatics pneumatics_subsystem) {
    m_shooter = shooter_subsystem;
    m_intake = intake_subsystem;
    m_driveTrain = driveTrain_subsystem;
    m_limeLight = limeLight_subsystem;
    m_combine = combine_subsystem;
    m_pneumatics = pneumatics_subsystem;
    addRequirements(shooter_subsystem, intake_subsystem, driveTrain_subsystem, limeLight_subsystem, combine_subsystem, pneumatics_subsystem);
  }

  @Override
  public void initialize() {
    timer.start();
    m_shooter.SetLimeLightAngle(Constants_Physical.LIMELIGHTSERVO_AIMANGLE);
  }

  @Override
  public void execute() {
    // Set
    m_limeLight.SetPowerPort_StandardPipeline();
    // Calculations
      // Manual drive
      DriveX = RobotContainer.joystickLD.getRawAxis(Constants_Joysticks.axisX) * Constants_Joysticks.kP_TURN;
      DriveY = RobotContainer.joystickRD.getRawAxis(Constants_Joysticks.axisY);
      leftDriveSpeed = DriveX - DriveY;
      rightDriveSpeed = -DriveX - DriveY;
    // PID
      // Calculations
      dt = timer.getFPGATimestamp() - lastTime;
        // X
        if(Math.abs(m_limeLight.GetAngleX()) > 4){
          if(m_limeLight.GetAngleX() > 0){
            P = .42;
          }else if(m_limeLight.GetAngleX() < 0){
            P = -.42;
          }
        }else{
          P = 0;
        }
        if(Math.abs(m_limeLight.GetAngleX()) <= 4 && Math.abs(m_limeLight.GetAngleX()) > 1){
          if(I > .7){
            I = .7;
          }else if(I < -.7){
            I = -.7;
          }else{
            I += m_limeLight.GetAngleX() * 0.007;
          }
        }else{
          I = 0;
        }
        D = (m_limeLight.GetAngleX() - lastErrorX) / dt * 0.000001;
        // Y
        errorD = (m_limeLight.GetDistince() - Constants_Physical.SHOOTINGDISTANCE) * 0.001;
        if(errorD < 0.5){
          angle = 0.5;
        }else if(errorD < 0.79){
          angle = 0.79;
        }else{
          angle = errorD;
        }
      // Put values
      SmartDashboard.putNumber("P - Shooter Adjust", P);
      SmartDashboard.putNumber("I - Shooter Adjust", I);
      SmartDashboard.putNumber("D - Shooter Adjust", D);
      SmartDashboard.putNumber("Angle", errorD);
    // Set motors
    m_driveTrain.SetLeftMotors(P + I + D /*+ errorD*/ + leftDriveSpeed);
    m_driveTrain.SetRightMotors(-P - I - D /* + errorD*/ + rightDriveSpeed);
    m_shooter.SetShooterHoodAngle(angle); // .5 middle / 0.05 , 0.79 max
    // Set values
    lastErrorX = m_limeLight.GetAngleX();
    lastTime = timer.getFPGATimestamp();
  }

  @Override
  public void end(boolean interrupted) {
    // Set
    m_shooter.SetShooterSpeed(0);
    m_intake.SetIntakeSpeed(0);
    m_driveTrain.SetLeftMotors(0);
    m_driveTrain.SetRightMotors(0);
    m_limeLight.SetStandbyPipeline();
    m_combine.SetCombinePosition(true);
    m_pneumatics.SetCompressor(true);
    m_shooter.SetLimeLightAngle(.2);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
