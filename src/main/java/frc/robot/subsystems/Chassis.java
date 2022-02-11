package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import static frc.robot.Constants.*;

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
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;

    /**
     *
     */
    public Chassis() {
        leftFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
        leftFrontMotor.restoreFactoryDefaults();
        leftFrontMotor.setInverted(true);
        leftFrontMotor.setIdleMode(IdleMode.kBrake);
        leftFrontMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);

        leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);
        leftRearMotor.restoreFactoryDefaults();
        leftRearMotor.setInverted(true);
        leftRearMotor.setIdleMode(IdleMode.kBrake);
        leftRearMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);

        leftMotors = new MotorControllerGroup(leftFrontMotor, leftRearMotor);
        addChild("leftMotors", leftMotors);

        rightFrontMotor = new CANSparkMax(4, MotorType.kBrushless);
        rightFrontMotor.restoreFactoryDefaults();
        rightFrontMotor.setInverted(false);
        rightFrontMotor.setIdleMode(IdleMode.kBrake);
        rightFrontMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);

        rightRearMotor = new CANSparkMax(5, MotorType.kBrushless);
        rightRearMotor.restoreFactoryDefaults();
        rightRearMotor.setInverted(false);
        rightRearMotor.setIdleMode(IdleMode.kBrake);
        rightRearMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);

        rightMotors = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
        addChild("rightMotors", rightMotors);

        differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("differentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        leftEncoder = leftFrontMotor.getEncoder();
        rightEncoder = rightFrontMotor.getEncoder();
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

    public void arcadeDrive(double speed, double rotation) {
        differentialDrive.arcadeDrive(speed, rotation);
    }

    public void resetEncoder() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

    public double getEncoderDistance() {
        double distance = (leftEncoder.getPosition() + rightEncoder.getPosition()) / 2.0;
        return distance * 2.1;
    }
}

