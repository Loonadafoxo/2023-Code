// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ArmLock.PistonIdle;
import frc.robot.commands.ArmLock.PistonLock;
import frc.robot.commands.ArmLock.PistonDisable;
import frc.robot.commands.Auton.AutonOut;
import frc.robot.commands.arm.ArmDown;
import frc.robot.commands.arm.ArmIdle;
import frc.robot.commands.arm.ArmUp;
import frc.robot.commands.claw.CloseClaw;
import frc.robot.commands.claw.IdleClaw;
import frc.robot.commands.claw.OpenClaw;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lock;

public class RobotContainer {
  private XboxController m_controller;
  private CommandXboxController m_commandController;

  private Drivetrain m_drivetrain;
  private Intake m_intake;
  private Claw m_claw;
  private Lock m_lock;


  public RobotContainer() {
    m_controller = new XboxController(0);
    m_commandController = new CommandXboxController(0);

    m_drivetrain = new Drivetrain();
    
    m_drivetrain.setDefaultCommand(
      new ArcadeDrive(
        m_drivetrain, 
        () -> modifyAxis(m_controller.getLeftY()), 
        () -> modifyAxis(m_controller.getRightX())));

    m_intake = new Intake();
    m_intake.setDefaultCommand(new ArmIdle(m_intake));

    m_claw = new Claw();
    m_claw.setDefaultCommand(new IdleClaw(m_claw));

    m_lock = new Lock();
    m_lock.setDefaultCommand(new PistonIdle(m_lock));


    configureBindings();
  }

  private void configureBindings() {
    /* Arm */
    new Trigger(m_controller::getLeftBumper).whileTrue(new ArmDown(m_intake));
    new Trigger(m_controller::getRightBumper).whileTrue(new ArmUp(m_intake));
    /* CLaw */
    new Trigger(m_controller::getAButton).onTrue(new OpenClaw(m_claw));
    new Trigger(m_controller::getBButton).onTrue(new CloseClaw(m_claw));
    m_commandController.axisGreaterThan(XboxController.Axis.kLeftTrigger.value, 0.6).onTrue(new OpenClaw(m_claw));
    m_commandController.axisGreaterThan(XboxController.Axis.kRightTrigger.value, 0.6).onTrue(new CloseClaw(m_claw));

    /* Lock */
    new Trigger(m_controller::getXButton).onTrue(new PistonLock(m_lock));
    new Trigger(m_controller::getYButton).onTrue(new PistonDisable(m_lock));
  }

  public Command getAutonomousCommand() {
      return new AutonOut(m_drivetrain, m_claw, m_intake, m_lock);
  }

  public static double modifyAxis(double value) {
    // Deadband to prevent drift
    value = MathUtil.applyDeadband(value, Constants.Drivetrain.CONTROLLER_DEADBAND);

    // Square input
    // value = Math.copySign(value * value, value);

    return value;
  }
}
