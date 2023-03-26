package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ArmUp extends CommandBase {
  private final Intake m_intake;

  public ArmUp(Intake intake) {
    this.m_intake = intake;

    addRequirements(intake);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    System.out.println("UPPPPPPPP");
    m_intake.setArmSpeed(.4);
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
}
