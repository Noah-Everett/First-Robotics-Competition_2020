package frc.robot;

import frc.robot.commands.autonomous.*;
import frc.robot.commands.climber.RunClimber;
import frc.robot.commands.drive.*;
import frc.robot.commands.intake.*;
import frc.robot.commands.shooter.*;
import frc.robot.commands.vision.*;
import frc.robot.subsystems.mechanisms.*;
import frc.robot.subsystems.sensors.*;
import frc.robot.constants.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.BooleanSupplier;

public class RobotContainer {

  public RobotContainer() {
    SmartDashboardAutonomousChooser(); 
    configureButtonBindings();
    m_driveTrain.setDefaultCommand(m_tankDrive);
    m_limeLight.setDefaultCommand(m_findStandby);
    m_climber.setDefaultCommand(m_offClimber);
  }

  private void configureButtonBindings() {
    jsbCombine.whileHeld(m_runCombine);
    jsbShootAdjust.whileHeld(m_shootAdjust);
    jsbRunShooter.whileHeld(m_runShooter);
    jsbIntakeForward.whileHeld(m_forwardIntake);
    jsbIntakeBackward.whileHeld(m_backwardIntake);
    // intakeTrigger.whenActive(m_limitSwitchIntake.withTimeout(intakeTimeout()));
    jsbIntakeForwardPalse.whenReleased(m_forwardPalseIntake.withTimeout(.05));
    jsbIntakeBackwardPalse.whenReleased(m_backwardPalseIntake.withTimeout(.05));
    jsbUpClimber.whileHeld(m_upClimber);
    jsbUpBot.whileHeld(m_upBot);
    jsbResetClimber.whileHeld(m_resetClimber);
  }

  public void SmartDashboardAutonomousChooser(){
    autonomousChooser.addDefault("Works", m_autoWorks);
    SmartDashboard.putData("Autonomous", autonomousChooser);
  }
  
  public Command getAutonomousCommand() { 
    return m_autoWorks;
  }

  // Subsystems
   // Mechanisms
    private final DriveTrain m_driveTrain = new DriveTrain();
    private final Shooter m_shooter = new Shooter();
    private final Intake m_intake = new Intake();
    private final Pneumatics m_pneumatics = new Pneumatics();
    private final Combine m_combine = new Combine();
    private final Climber m_climber = new Climber();
    // Sensors
    private final ADIS16470 m_adis16470 = new ADIS16470();
    private final LimeLight m_limeLight = new LimeLight();
  // Commands
    // Autonomous
    private final AutoWorks m_autoWorks = new AutoWorks(m_driveTrain, m_intake, m_shooter);
    // Drive train
    private final TankDrive m_tankDrive = new TankDrive(m_driveTrain);
    private final ShootAdjust m_shootAdjust = new ShootAdjust(m_shooter, m_intake, m_driveTrain, m_limeLight, m_combine, m_pneumatics);
    // Shooter
    private final RunShooter m_runShooter = new RunShooter(m_shooter, m_intake);
    // Vision
    private final FindPowerPort m_findPowerPort_Standard = new FindPowerPort(m_limeLight, 1);
    private final FindPowerPort m_findPowerPort_Two = new FindPowerPort(m_limeLight, 2);
    private final FindPowerPort m_findPowerPort_Three = new FindPowerPort(m_limeLight, 3);
    private final FindLoadingBay m_findLoadingBay = new FindLoadingBay(m_limeLight);
    private final FindPowerCells m_findPowerCells = new FindPowerCells(m_limeLight);
    private final FindStandby m_findStandby = new FindStandby(m_limeLight);
    // Intake/Combine
    private final RunIntake m_forwardIntake = new RunIntake(m_intake,true, true);
    private final RunIntake m_backwardIntake = new RunIntake(m_intake,false, true);
    private final RunIntake m_limitSwitchIntake = new RunIntake(m_intake, true, false);
    private final RunIntake m_forwardPalseIntake = new RunIntake(m_intake, true, true);
    private final RunIntake m_backwardPalseIntake = new RunIntake(m_intake, false, true);
    private final RunCombine m_runCombine = new RunCombine(m_combine);
    // Climber
    private final RunClimber m_upClimber = new RunClimber(m_climber, m_combine, true, true, true);
    private final RunClimber m_upBot = new RunClimber(m_climber, m_combine, false, true, true);
    private final RunClimber m_offClimber = new RunClimber(m_climber, m_combine, true, false, true);
    private final RunClimber m_resetClimber = new RunClimber(m_climber, m_combine, false, false, false);
    // Joysticks
  public static Joystick joystickLD = new Joystick(Constants_Joysticks.jsLEFTDRIVER);
  public static Joystick joystickRD = new Joystick(Constants_Joysticks.jsRIGHTDRIVER);
  public static Joystick joystickBC = new Joystick(Constants_Joysticks.jsBUTTONCONTROLLER);
    // Joystick buttons
    public static JoystickButton jsbCombine = new JoystickButton(joystickBC, Constants_Joysticks.jsbCOMBINE);
    public static JoystickButton jsbShootAdjust = new JoystickButton(joystickBC, Constants_Joysticks.jsbSHOOTADJUST);
    public static JoystickButton jsbRunShooter = new JoystickButton(joystickBC, Constants_Joysticks.jsbRUNSHOOTER);
    public static JoystickButton jsbIntakeForward = new JoystickButton(joystickBC, Constants_Joysticks.jsbINTAKEFORWARD);
    public static JoystickButton jsbIntakeBackward = new JoystickButton(joystickBC, Constants_Joysticks.jsbINTAKEBACKWARD);
    public static JoystickButton jsbIntakeForwardPalse = new JoystickButton(joystickBC, Constants_Joysticks.jsbINTAKEFORWARDPALSE);
    public static JoystickButton jsbIntakeBackwardPalse = new JoystickButton(joystickBC, Constants_Joysticks.jsbINTAKEBACKWARDPALSE);
    public static JoystickButton jsbUpClimber = new JoystickButton(joystickBC, Constants_Joysticks.jsbUPCLIMBER);
    public static JoystickButton jsbUpBot = new JoystickButton(joystickBC, Constants_Joysticks.jsbUPBOT);
    public static JoystickButton jsbResetClimber = new JoystickButton(joystickBC, Constants_Joysticks.jsbRESETCLIMBER);
    // Limit switch
  private final DigitalInput intakeLimitSwitch = new DigitalInput(Constants_Sensors.pINTAKELIMITSWITCH);
  private BooleanSupplier intakeBooleanSupplier = new BooleanSupplier(){
    @Override
    public boolean getAsBoolean() {
      return intakeLimitSwitch.get();
    }
  };
  private Trigger intakeTrigger = new Trigger(intakeBooleanSupplier);
  public static int storedPowerCells;
  private static double time;
  private double intakeTimeout(){
    if(storedPowerCells == 0){
      time = 0.5;
    }
    return time;
  }
  //Smartdashboard
  private final SendableChooser<Command> autonomousChooser = new SendableChooser<>();
}