package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.PIDSparkMotor;

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
    private PIDSparkMotor pidLeftFrontMotor;
    private PIDSparkMotor pidLeftRearMotor;
    private PIDSparkMotor pidRightFrontMotor;
    private PIDSparkMotor pidRightRearMotor;

    /**
     *
     */
    public Chassis() {
        leftFrontMotor = new CANSparkMax(CHASSIS_LEFT_FRONT_MOTOR_CAN_ID, MotorType.kBrushless);
        leftFrontMotor.restoreFactoryDefaults();
        leftFrontMotor.setInverted(true);
        leftFrontMotor.setIdleMode(IdleMode.kBrake);
        leftFrontMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);
        pidLeftFrontMotor = new PIDSparkMotor(leftFrontMotor, CHASSIS_PID_P, CHASSIS_PID_I, CHASSIS_PID_D);

        leftRearMotor = new CANSparkMax(CHASSIS_LEFT_REAR_MOTOR_CAN_ID, MotorType.kBrushless);
        leftRearMotor.restoreFactoryDefaults();
        leftRearMotor.setInverted(true);
        leftRearMotor.setIdleMode(IdleMode.kBrake);
        leftRearMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);
        pidLeftRearMotor = new PIDSparkMotor(leftRearMotor, CHASSIS_PID_P, CHASSIS_PID_I, CHASSIS_PID_D);

        leftMotors = new MotorControllerGroup(pidLeftFrontMotor, pidLeftRearMotor);
        addChild("leftMotors", leftMotors);

        rightFrontMotor = new CANSparkMax(CHASSIS_RIGHT_FRONT_MOTOR_CAN_ID, MotorType.kBrushless);
        rightFrontMotor.restoreFactoryDefaults();
        rightFrontMotor.setInverted(false);
        rightFrontMotor.setIdleMode(IdleMode.kBrake);
        rightFrontMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);
        pidRightFrontMotor = new PIDSparkMotor(rightFrontMotor, CHASSIS_PID_P, CHASSIS_PID_I, CHASSIS_PID_D);

        rightRearMotor = new CANSparkMax(CHASSIS_RIGHT_REAR_MOTOR_CAN_ID, MotorType.kBrushless);
        rightRearMotor.restoreFactoryDefaults();
        rightRearMotor.setInverted(false);
        rightRearMotor.setIdleMode(IdleMode.kBrake);
        pidRightRearMotor = new PIDSparkMotor(rightRearMotor, CHASSIS_PID_P, CHASSIS_PID_I, CHASSIS_PID_D);

        rightMotors = new MotorControllerGroup(pidRightFrontMotor, pidRightRearMotor);
        addChild("rightMotors", rightMotors);

        differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("differentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        leftEncoder = leftFrontMotor.getEncoder();
        rightEncoder = rightFrontMotor.getEncoder();

        setClosedLoop(CHASSIS_CLOSED_LOOP);
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

    public void setClosedLoop(boolean b) {
        pidLeftFrontMotor.setClosedLoop(b);
        pidLeftRearMotor.setClosedLoop(b);
        pidRightFrontMotor.setClosedLoop(b);
        pidRightRearMotor.setClosedLoop(b);
    }

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

