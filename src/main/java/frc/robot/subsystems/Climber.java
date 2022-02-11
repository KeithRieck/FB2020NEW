package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.*;

/**
 *
 */
public class Climber extends SubsystemBase {

    private CANSparkMax leftClimberMotor;
    private CANSparkMax rightClimberMotor;

    /**
     *
     */
    public Climber() {
        leftClimberMotor = new CANSparkMax(22, MotorType.kBrushless);
        leftClimberMotor.restoreFactoryDefaults();
        leftClimberMotor.setInverted(false);
        leftClimberMotor.setIdleMode(IdleMode.kBrake);
        leftClimberMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);

        rightClimberMotor = new CANSparkMax(24, MotorType.kBrushless);
        rightClimberMotor.restoreFactoryDefaults();
        rightClimberMotor.setInverted(false);
        rightClimberMotor.setIdleMode(IdleMode.kBrake);
        rightClimberMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);
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
