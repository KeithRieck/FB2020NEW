package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.Constants.*;

/**
 *
 */
public class Loader extends SubsystemBase {
    private WPI_TalonSRX leftBeltMotor;
    private WPI_TalonSRX rightBeltMotor;

    /**
     *
     */
    public Loader() {
        leftBeltMotor = new WPI_TalonSRX(20);

        /* Factory default hardware to prevent unexpected behavior */
        leftBeltMotor.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
        leftBeltMotor.setInverted(false);
        leftBeltMotor.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
        leftBeltMotor.configNominalOutputForward(0, 30);
        leftBeltMotor.configNominalOutputReverse(0, 30);
        leftBeltMotor.configPeakOutputForward(1, 30);
        leftBeltMotor.configPeakOutputReverse(-1, 30);

        leftBeltMotor.configPeakCurrentLimit(TALON_PEAK_CURRENT_LIMIT, TALON_TIMEOUT);
        leftBeltMotor.configPeakCurrentDuration(TALON_PEAK_CURRENT_DURATION, TALON_TIMEOUT);
        leftBeltMotor.configContinuousCurrentLimit(TALON_CONTINUOUS_CURRENT_LIMIT, TALON_TIMEOUT);
        leftBeltMotor.enableCurrentLimit(TALON_PEAK_CURRENT_LIMIT > 0);

        rightBeltMotor = new WPI_TalonSRX(21);

        /* Factory default hardware to prevent unexpected behavior */
        rightBeltMotor.configFactoryDefault();

        /* Invert Motor? and set Break Mode */
        rightBeltMotor.setInverted(false);
        rightBeltMotor.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
        rightBeltMotor.configNominalOutputForward(0, 30);
        rightBeltMotor.configNominalOutputReverse(0, 30);
        rightBeltMotor.configPeakOutputForward(1, 30);
        rightBeltMotor.configPeakOutputReverse(-1, 30);

        rightBeltMotor.configPeakCurrentLimit(TALON_PEAK_CURRENT_LIMIT, TALON_TIMEOUT);
        rightBeltMotor.configPeakCurrentDuration(TALON_PEAK_CURRENT_DURATION, TALON_TIMEOUT);
        rightBeltMotor.configContinuousCurrentLimit(TALON_CONTINUOUS_CURRENT_LIMIT, TALON_TIMEOUT);
        rightBeltMotor.enableCurrentLimit(TALON_PEAK_CURRENT_LIMIT > 0);
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

