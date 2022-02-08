package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 *
 */
public class Chassis extends SubsystemBase {
    private CANSparkMax leftFrontMotor;
    private CANSparkMax leftRearMotor;
    private MotorControllerGroup leftMotors;
    private CANSparkMax rightFrontMotor;
    private CANSparkMax rightRearMotor;
    private MotorControllerGroup rightMotors;
    private DifferentialDrive differentialDrive;

    /**
     *
     */
    public Chassis() {
        leftFrontMotor = new CANSparkMax(2, MotorType.kBrushless);

        leftFrontMotor.restoreFactoryDefaults();
        leftFrontMotor.setInverted(true);
        leftFrontMotor.setIdleMode(IdleMode.kBrake);

        leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);

        leftRearMotor.restoreFactoryDefaults();
        leftRearMotor.setInverted(true);
        leftRearMotor.setIdleMode(IdleMode.kBrake);

        leftMotors = new MotorControllerGroup(leftFrontMotor, leftRearMotor);
        addChild("leftMotors", leftMotors);

        rightFrontMotor = new CANSparkMax(4, MotorType.kBrushless);

        rightFrontMotor.restoreFactoryDefaults();
        rightFrontMotor.setInverted(false);
        rightFrontMotor.setIdleMode(IdleMode.kBrake);


        rightRearMotor = new CANSparkMax(5, MotorType.kBrushless);

        rightRearMotor.restoreFactoryDefaults();
        rightRearMotor.setInverted(false);
        rightRearMotor.setIdleMode(IdleMode.kBrake);


        rightMotors = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
        addChild("rightMotors", rightMotors);


        differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("differentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

