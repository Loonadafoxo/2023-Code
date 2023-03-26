package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lock;
import frc.robot.subsystems.Drivetrain;


public class AutonOut extends CommandBase {
  private final Claw m_claw;
  private final Intake m_intake;
  private final Drivetrain m_drivetrain;
  private final Lock m_piston;
  private Timer autonTimer;
  private Boolean ground;
  public AutonOut(Drivetrain drivetrain, Claw claw, Intake intake, Lock piston) {
    this.m_claw = claw;
    addRequirements(claw);
    this.m_intake = intake;
    addRequirements(intake);
    this.m_drivetrain = drivetrain;
    addRequirements(drivetrain);
    this.m_piston = piston;
    addRequirements(piston);
    autonTimer = new Timer();
  }

  @Override
  public void initialize() {
    autonTimer.start();
    // Drivetrain.gyro.reset();
    ground = true;
  }

  @Override
  public void execute() {
    System.out.println("AUTO");
    /* Auton out */
    /* Claw */
    if(autonTimer.get() <= 1){ 
      m_claw.open();
      System.out.println("OPEN");
    } else {
      m_claw.close();
      System.out.println("CLOSE");
    }

    /* Arm */
    if(autonTimer.get() < 15){
      m_intake.setArmSpeed(.15);
    }

   /* Piston */
   if(autonTimer.get() < 15){
    m_piston.lock();
   }

   
      /* Gyro Drive */
  if (autonTimer.get() <= 1) {
    m_drivetrain.arcadeDrive(0, 0);
  } else if (autonTimer.get() <= 4) {
    m_drivetrain.arcadeDrive(.9, 0);
  } else if (autonTimer.get() < 3.1) {
    m_drivetrain.arcadeDrive(0, 0);
  }

      /* *Woroking* Gyro (Working... kinda.... 95% but really scary) */
  System.out.println("Stablize");
  float xRoll = Drivetrain.gyro.getRoll();

  if (xRoll > -7 && xRoll < 4 && !ground) {
    m_drivetrain.arcadeDrive(0, 0);
    System.out.println("Stop");
  }else 

  if (xRoll > 5) {
    m_drivetrain.arcadeDrive(-.4, 0);
    ground = false;
    System.out.println("Forward");
  } else 
  
  if (xRoll < -10) {
    m_drivetrain.arcadeDrive(.5, 0);
    System.out.println("Backward");
  } 

    /* Gyro (reworking degrees) */
    // System.out.println("Stablize");
    // float xRoll = Drivetrain.gyro.getRoll();
  
    // if (xRoll > -7 && xRoll < 4 && !ground) {
    //   m_drivetrain.arcadeDrive(0, 0);
    //   System.out.println("Stop");
    // }else 
  
    // if (xRoll > 5) {
    //   m_drivetrain.arcadeDrive(-.4, 0);
    //   ground = false;
    //   System.out.println("Forward");
    // } else 
    
    // if (xRoll < -10) {
    //   m_drivetrain.arcadeDrive(.5, 0);
    //   System.out.println("Backward");
    // } 

      /* drivetrain Taxi */
  //  if (autonTimer.get() <= 1) {
  //   m_drivetrain.arcadeDrive(0, 0);
  // } else if (autonTimer.get() <= 7) {
  //   m_drivetrain.arcadeDrive(.5, 0);
  // } else {
  //   m_drivetrain.arcadeDrive(0, 0);
  // }
  
        /* drivetrain Small ramp */
    //  if (autonTimer.get() <= 1) {
    //   m_drivetrain.arcadeDrive(0, 0);
    // } else if (autonTimer.get() <= 3.5) {
    //   m_drivetrain.arcadeDrive(.6, 0);
    // } else if (autonTimer.get() <= 3.6){
    //   m_drivetrain.arcadeDrive(0, 0);
    // } else if (autonTimer.get() <= 3.7){
    //   m_drivetrain.arcadeDrive(0, .8);
    // } else {
    //   m_drivetrain.arcadeDrive(0, 0);
    // }

    /* drivetrain Big ramp */
    // if (autonTimer.get() <= 1) {
    //   m_drivetrain.arcadeDrive(0, 0);
    // } else if (autonTimer.get() <= 4.5) {
    //   m_drivetrain.arcadeDrive(.6, 0);
    // } else if (autonTimer.get() <= 4.6){
    //   m_drivetrain.arcadeDrive(0, 0);
    // } else if (autonTimer.get() <= 4.7){
    //   m_drivetrain.arcadeDrive(0, .8);
    // } else {
    //   m_drivetrain.arcadeDrive(0, 0);
    // }

      /* 90 Degree turn (needs tweeking on the rotation) */
    // if (autonTimer.get() <= 1) {
    //   m_drivetrain.arcadeDrive(0, 0);
    // } else if (autonTimer.get() <= 3.5) {
    //   m_drivetrain.arcadeDrive(.6, 0);
    // } else if (autonTimer.get() <= 3.6){
    //   m_drivetrain.arcadeDrive(0, 0);
    // } else if (autonTimer.get() <= 5.7){
    //   m_drivetrain.arcadeDrive(0, .4);
    // } else {
    //   m_drivetrain.arcadeDrive(0, 0);
    // }

    

/* 
    // Auton in
        //drivetrain
        if(autonTimer.get() > 2.5){
          m_drivetrain.arcadeDriveIK(.3, 0, isFinished());
        }
    
        if (autonTimer.get() >= 2.5){
          m_drivetrain.arcadeDriveIK(0, 0, isFinished());
        }
    
        if(autonTimer.get() > 3){
          m_drivetrain.arcadeDriveIK(-.3, 0, isFinished());
        }
    
        if (autonTimer.get() > 5.5){
          m_drivetrain.arcadeDriveIK(0, 0, isFinished());
        }
    
        //claw
        if(autonTimer.get() > 0){
          m_claw.open();
        }
        if(autonTimer.get() > 2.5){
          m_claw.close();
        }
        // if(autonTimer.get() > 0){
        //   m_claw.open();
        // }
        // if(autonTimer.get() > 0){
        //   m_claw.open();
        // }
        // if(autonTimer.get() > 0){
        //   m_claw.open();
        // }
        // if(autonTimer.get() > 0){
        //   m_claw.open();
        // }
        // if(autonTimer.get() > 0){
        //   m_claw.open();
        // }
    
        // arm
        if(autonTimer.get() > 0){
          m_intake.setArmSpeed(-.5);
        }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        // if(autonTimer.get() > 0){
        //   m_intake.setArmSpeed(1);
        // }
        */
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
