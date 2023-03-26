package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class IdleClaw extends CommandBase {
  private final Claw m_claw;

  public IdleClaw(Claw claw) {
    this.m_claw = claw;

    addRequirements(claw);
  }

  @Override
  public void initialize() {
    m_claw.close();
  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return true;
  }

}