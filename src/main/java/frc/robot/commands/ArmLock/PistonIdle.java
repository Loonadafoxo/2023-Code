package frc.robot.commands.ArmLock;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lock;

public class PistonIdle extends CommandBase {
  private final Lock lock;
  public PistonIdle(Lock lock) {
    this.lock = lock;
    addRequirements(lock);
  }

  @Override
  public void initialize() {
    lock.lock();
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
