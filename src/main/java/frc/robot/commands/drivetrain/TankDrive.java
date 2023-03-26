package frc.robot.commands.drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;;

public class TankDrive extends CommandBase {
  private Drivetrain m_drivetrain;
  private DoubleSupplier m_leftSupplier;
  private DoubleSupplier m_rightSupplier;

  public TankDrive(Drivetrain drivetrain, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    m_drivetrain = drivetrain;
    m_leftSupplier = leftSupplier;
    m_rightSupplier = rightSupplier;

    addRequirements(m_drivetrain);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_drivetrain.drive(m_leftSupplier.getAsDouble(), m_rightSupplier.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }
}
