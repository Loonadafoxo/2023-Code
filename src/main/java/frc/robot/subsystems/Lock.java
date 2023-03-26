package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lock extends SubsystemBase {
  private Solenoid hold;

  public Lock() {
    hold = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Arm.SOLENOID_ID_2);
  }

  public void lock(){
    hold.set(false);
  }

  public void disable(){
    hold.set(true);
  }

  @Override
  public void periodic() {
  }
}
