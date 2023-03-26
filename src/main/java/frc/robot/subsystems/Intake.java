package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private WPI_VictorSPX m_leftMotor;
  private WPI_VictorSPX m_rightMotor;
  private MotorControllerGroup m_motor;

  public Intake() {
    m_leftMotor = new WPI_VictorSPX(Constants.Arm.LEFT_MOTOR_ID);
    m_leftMotor.setInverted(true);
    m_rightMotor = new WPI_VictorSPX(Constants.Arm.RIGHT_MOTOR_ID);
    m_rightMotor.setInverted(true);
    m_motor = new MotorControllerGroup(m_leftMotor, m_rightMotor);

  }

  public void setArmSpeed(double speed) {
    m_motor.set(-speed);
  }

  @Override
  public void periodic() {
  }
}
