package frc.robot.subsystems.mechanisms;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  private final Compressor compressor = new Compressor();
    
  public Pneumatics() {
  }

  public void SetCompressor(boolean onoff){
    if(onoff == true){
      compressor.start();
    }else if(onoff == false){
      compressor.stop();
    }
  }

  @Override
  public void periodic() {
    compressor.stop();
  }
}
