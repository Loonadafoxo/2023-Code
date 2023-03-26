package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ArmDown extends CommandBase {
  private final Intake m_intake;

  public ArmDown(Intake intake) {
    this.m_intake = intake;

    addRequirements(intake);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    System.out.println("DOWNNNNNN");
    m_intake.setArmSpeed(-0.25);
  }

  @Override
  public void end(boolean interrupted) {
    m_intake.setArmSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}
