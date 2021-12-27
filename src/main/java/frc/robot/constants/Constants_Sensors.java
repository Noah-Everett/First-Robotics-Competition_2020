package frc.robot.constants;

import com.revrobotics.EncoderType;

public final class Constants_Sensors {
  // Gyro
  public static final int GYRODEGREES = 360; //# of degrees gyro measures
  // Encoders
    // Drive train
    public static final EncoderType DRIVELEFTENCODERTYPE = EncoderType.kQuadrature; //Left drive train encoder type (lets motor move and get values)
    public static final int DRIVELEFTENCODERNUMBEROFUPDATESPERROTATION = 4096; //Number of times the encoder updates per revolution
    public static final EncoderType DRIVERIGHTENCODERTYPE = EncoderType.kQuadrature; //Right drive train encoder type (lets motor move and get values)
    public static final int DRIVERIGHTENCODERNUMBEROFUPDATESPERROTATION = 4096; //Number of times the encoder updates per revolution
    // Shooter
    public static final EncoderType SHOOTERENCODERTYPE = EncoderType.kQuadrature; //Shooter wheel encoder type (lets motor move and get values)
    public static final int SHOOTERENCODERNUMBEROFREVOLUTIONSPERROTATION = 4096; //Number of times the encoder updates per revolution
  // Limit switch
  public static final int pINTAKELIMITSWITCH = 0;
  // LimeLight
  public static final double PIPELINEPOWERPORT_STANDARD = 0;
  public static final double PIPELINEPOWERPORT_TWO = 1;
  public static final double PIPELINEPOWERPORT_THREE = 2;
  public static final double PIPELINELOADINGBAY = 3;
  public static final double PIPELINEPOWERCELL = 4;
  public static final double PIPELINESTANDBY = 5;
  //Sonar
  public static final int pINTAKESONARONE = 1; //DIO ping 
  public static final int pINTAKESONARTWO = 0; //DIO response
}