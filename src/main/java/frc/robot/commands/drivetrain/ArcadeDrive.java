package frc.robot.commands.drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;;

public class ArcadeDrive extends CommandBase {
  private Drivetrain m_drivetrain;
  private DoubleSupplier m_xSupplier;
  private DoubleSupplier m_rotationSupplier;

  public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier xSupplier, DoubleSupplier rotationSupplier) {
    m_drivetrain = drivetrain;
    m_xSupplier = xSupplier;
    m_rotationSupplier = rotationSupplier;

    addRequirements(m_drivetrain);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_xSupplier.getAsDouble(), m_rotationSupplier.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
  }
}
