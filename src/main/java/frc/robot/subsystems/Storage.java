package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.*;

/**
 *
 */
public class Storage extends SubsystemBase {
    private CANSparkMax storageMotor;

    /**
     *
     */
    public Storage() {
        storageMotor = new CANSparkMax(12, MotorType.kBrushless);
        storageMotor.restoreFactoryDefaults();
        storageMotor.setInverted(false);
        storageMotor.setIdleMode(IdleMode.kBrake);
        storageMotor.setSmartCurrentLimit(SPARKMAX_LOWER_STALL_LIMIT, SPARKMAX_LOWER_FREE_LIMIT, SPARKMAX_LOWER_LIMIT_RPM);
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
