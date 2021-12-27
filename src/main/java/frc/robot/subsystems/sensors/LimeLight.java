package frc.robot.subsystems.sensors;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants_Physical;
import frc.robot.constants.Constants_Sensors;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLight extends SubsystemBase {
  private NetworkTable table; 
  private NetworkTableEntry tx, ty, ta, getpipe;
  private double x, y, area, pipeline, distance;

  public LimeLight() {
    //LimeLight network table
    table = NetworkTableInstance.getDefault().getTable("limelight");
      //Table values
      tx = table.getEntry("tx");
      ty = table.getEntry("ty");
      ta = table.getEntry("ta");
      getpipe = table.getEntry("pipeline");
        //Read values
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0); 
        pipeline = getpipe.getDouble(Constants_Sensors.PIPELINESTANDBY);
  }

  //Setting pipeline value
  public void SetPowerPort_StandardPipeline(){
    getpipe.setNumber(Constants_Sensors.PIPELINEPOWERPORT_STANDARD);
  }public void SetPowerPort_TwoPipeline(){
    getpipe.setNumber(Constants_Sensors.PIPELINEPOWERPORT_TWO);
  }public void SetPowerPort_ThreePipeline(){
    getpipe.setNumber(Constants_Sensors.PIPELINEPOWERPORT_THREE);
  }public void SetLoadingBayPipeline(){
    getpipe.setNumber(Constants_Sensors.PIPELINELOADINGBAY);
  }public void SetPowerCellPipeline(){
    getpipe.setNumber(Constants_Sensors.PIPELINEPOWERCELL);
  }public void SetStandbyPipeline(){
    getpipe.setNumber(Constants_Sensors.PIPELINESTANDBY);
  }

  //Get network table values
  public double GetAngleX(){
    return x;
  }public double GetAngleY(){
    return y;
  }public double GetArea(){
    return area;
  }public double GetPipeline(){
    return pipeline;
  }

  //Use network table values
  public double GetDistince(){
    distance = (Constants_Physical.HIGHTOFPOWERPORT - Constants_Physical.HIGHTOFLIMELIGHT)/(Math.atan((Constants_Physical.ANGLEOFLIMELIGHT + y) * Math.PI / 180));
    return distance - Constants_Physical.DISTANCEFROMLIMELIGHTTOFRONTOFBOT;
  }

  @Override
  public void periodic() {
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0); 
    pipeline = getpipe.getDouble(Constants_Sensors.PIPELINESTANDBY); 
    SmartDashboard.putNumber("LimeLight_X", x);
    SmartDashboard.putNumber("LimeLight_Y", y);
    SmartDashboard.putNumber("LimeLight_Area", area);
    SmartDashboard.putNumber("LimeLight_Distance", GetDistince());
  }
}