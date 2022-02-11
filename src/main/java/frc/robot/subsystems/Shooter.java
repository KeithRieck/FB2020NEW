package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.*;

/**
 *
 */
public class Shooter extends SubsystemBase {
    private WPI_TalonSRX shooterMotor;

    /**
     *
     */
    public Shooter() {
        shooterMotor = new WPI_TalonSRX(25);

        /* Factory default hardware to prevent unexpected behavior */
        shooterMotor.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
        shooterMotor.setInverted(false);
        shooterMotor.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
        shooterMotor.configNominalOutputForward(0, 30);
        shooterMotor.configNominalOutputReverse(0, 30);
        shooterMotor.configPeakOutputForward(1, 30);
        shooterMotor.configPeakOutputReverse(-1, 30);

        shooterMotor.configPeakCurrentLimit(TALON_PEAK_CURRENT_LIMIT, TALON_TIMEOUT);
        shooterMotor.configPeakCurrentDuration(TALON_PEAK_CURRENT_DURATION, TALON_TIMEOUT);
        shooterMotor.configContinuousCurrentLimit(TALON_CONTINUOUS_CURRENT_LIMIT, TALON_TIMEOUT);
        shooterMotor.enableCurrentLimit(TALON_PEAK_CURRENT_LIMIT > 0);
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

