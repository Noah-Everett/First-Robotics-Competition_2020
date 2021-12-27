package frc.robot.constants;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public final class Constants_Motors {
// Motors
  // Drive train
    // Left motors
    public static final int pDRIVELEFTSPARKMAX = 4; //Left wheels sparkmax
    public static final MotorType DRIVELEFTSPARKMAXTYPE = MotorType.kBrushed; //left drive train sparkmax motor type
    public static final int pDRIVELEFTSPARK = 9; //Left wheels spark
    // Right motors
    public static final int pDRIVERIGHTSPARKMAX = 3; //Right wheels sparkmax
    public static final MotorType DRIVERIGHTSPARKMAXTYPE = MotorType.kBrushed; //right drive train sparkmax motor type
    public static final int pDRIVERIGHTSPARK = 0; //Right wheels spark
  // Shooter
  public static final int pSHOOTERSPARKMAX = 1; //Shooter motor
  public static final MotorType SHOOTERSPARKMAXTYPE = MotorType.kBrushed; //Spark max shooter wheel motor type
  public static final int pSERVOHOOD = 5;
  public static final int pSERVOLIMELIGHT = 8; 
  // Intake
  public static final int pCOMBINESIDESPARK = 6;
  public static final int pCOMBINEFRONTSPARK = 7;
  public static final int pINTAKESPARKMAX = 2;
  public static final MotorType INTAKESPARKMAXTYPE = MotorType.kBrushed;
  // Climber
  public static final int pCLIMBERSPARK = 1;
}