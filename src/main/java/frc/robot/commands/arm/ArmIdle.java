package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ArmIdle extends CommandBase {
  private final Intake m_intake;

  public ArmIdle(Intake intake) {
    this.m_intake = intake;

    addRequirements(intake);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_intake.setArmSpeed(0.20);
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}
