package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  private Solenoid m_solenoid;

  public Claw() {
    m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Arm.SOLENOID_ID_1);
  }

  public void open() {
    m_solenoid.set(true);
  }

  public void close() {
    m_solenoid.set(false);
  }

  @Override
  public void periodic() {
    super.periodic();
  }
}
