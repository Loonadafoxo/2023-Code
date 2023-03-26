package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class OpenClaw extends CommandBase {
  private final Claw m_claw;

  public OpenClaw(Claw claw) {
    this.m_claw = claw;

    addRequirements(claw);
  }

  @Override
  public void initialize() {
    m_claw.open();
    System.out.println("Claw open");
  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
