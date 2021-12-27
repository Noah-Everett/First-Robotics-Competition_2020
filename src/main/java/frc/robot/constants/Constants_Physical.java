package frc.robot.constants;

public final class Constants_Physical {
  // PID
  // Bot
  public static final double MOTORMOVEMENTPERCENTTHRESHOLDFORWARD = 0.15; //Anything above .16 will move, NOT 0.15
  public static final double MOTORMOVEMENTPERCENTTHRESHOLDTURNING = 0.28; //Anything above .28 will move, NOT 0.28
  public static final double HIGHTOFLIMELIGHT = 23;
  public static final double ANGLEOFLIMELIGHT = 39;
  public static final double DISTANCEFROMLIMELIGHTTOFRONTOFBOT = 18;
  // Shooter
  public static final double SHOOTERWHEELSPEED = 1;
  public static final double SHOOTERSPEEDUPTIME = 0.7;
  public static final double SHOOTINGDISTANCE = 72; //number of in. from target to shoot from 
  // Combine
  public static final double COMBINEMOTORSPEEDS = 1;
  // Power port
  public static final double HIGHTOFPOWERPORT = 87; //98.25
  public static final double DISTANCEFROMPOWERPORTWITHFULLPOWERONSHOOTERWHEEL = 96; //in. from power port when speeds of shooter wheel change
  // Intake
  public static final double INTAKERUNTIME = 0.6; //Seconds intake will run for when ball is detected
  public static final double INTAKEMOTORSPEED = -0.3; //Speed that the intake motor will run at
  public static final double INTAKEACTIVATIONDISTANCETHRESHOLD = 2; //number of inches-ish that the intake will activate
  // Autonomous
    // AutoWorks
    public static final double AUTONOMOUSWAITTIME = 5; //Number of seconds bot will wait after auto starts
    public static final double AUTONOMOUSTIMETOSHOOT  = 7; //Number of seconds bot will shoot for
    public static final double AUTONOMOUSDRIVETIME = 2.9; //Number of seconds bot will move for
  // Climber
  public static final double CLIMBERMOTORSPEED = 1;
  // Limelight servo angles
  public static final double LIMELIGHTSERVO_DRIVEANGLE = 0.2;
  public static final double LIMELIGHTSERVO_AIMANGLE = 0.3;
}