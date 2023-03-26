package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  public final static AHRS gyro = new AHRS(edu.wpi.first.wpilibj.SPI.Port.kMXP);
  public static final String Gryosc = null;
    private final DifferentialDriveOdometry m_Odomety;
  
  private WPI_VictorSPX m_leftMotor1;
  private WPI_VictorSPX m_leftMotor2;
  private MotorControllerGroup m_leftMotor;

  private WPI_VictorSPX m_rightMotor1;
  private WPI_VictorSPX m_rightMotor2;
  private MotorControllerGroup m_rightMotor;

  private DifferentialDrive m_drive;
  
  public Drivetrain() {
    gyro.reset();
    gyro.calibrate();

    m_Odomety = new DifferentialDriveOdometry(gyro.getRotation2d(), 0, 0);
    m_Odomety.resetPosition(gyro.getRotation2d(), 0, 0, new Pose2d());

    m_leftMotor1 = new WPI_VictorSPX(Constants.Drivetrain.LEFT_MOTOR_1_ID);
    m_leftMotor2 = new WPI_VictorSPX(Constants.Drivetrain.LEFT_MOTOR_2_ID);
    m_leftMotor1.setNeutralMode(NeutralMode.Brake);
    m_leftMotor2.setNeutralMode(NeutralMode.Brake);
    m_leftMotor = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
    m_leftMotor.setInverted(true);


    m_rightMotor1 = new WPI_VictorSPX(Constants.Drivetrain.RIGHT_MOTOR_1_ID);
    m_rightMotor2 = new WPI_VictorSPX(Constants.Drivetrain.RIGHT_MOTOR_2_ID);
    m_rightMotor1.setNeutralMode(NeutralMode.Brake);
    m_rightMotor2.setNeutralMode(NeutralMode.Brake);
    m_rightMotor = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);
    m_rightMotor.setInverted(false);

    m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

 }

  public void drive(double leftSpeed, double rightSpeed) {
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double xSpeed, double rotationSpeed) {
    m_drive.arcadeDrive(xSpeed, rotationSpeed);
  }

  public double getTrurnRate() {
    return -gyro.getRate();
  }

  public double getHeading() {
    return gyro.getRotation2d().getDegrees();
  }

  public void resetOdometry(Pose2d pose) {
    m_Odomety.resetPosition(gyro.getRotation2d(), 0, 0, pose);
  }

  public void zeroHeading() {
    gyro.calibrate();
    gyro.reset();
  }

  public Gyro getGyro() {
    return gyro;
  }

  @Override
  public void periodic() {
    m_Odomety.update(gyro.getRotation2d(), getTrurnRate(), getHeading());
    System.out.println("Roll " + gyro.getRoll());
  }

public static void drivetrain(double d, double e) {
}

}
