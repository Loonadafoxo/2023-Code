package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private Compressor m_compressor;

  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();

    m_robotContainer = new RobotContainer();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    m_compressor.disable();
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {
    m_compressor.enableDigital();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    m_autonomousCommand.schedule();
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    m_autonomousCommand.cancel();
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
