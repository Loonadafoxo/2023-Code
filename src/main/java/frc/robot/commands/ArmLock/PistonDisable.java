package frc.robot.commands.ArmLock;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lock;

public class PistonDisable extends CommandBase {
  private final Lock disable;
  public PistonDisable(Lock disable) {
    this.disable = disable;
    addRequirements(disable);
  }

  @Override
  public void initialize() {
    disable.disable();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
