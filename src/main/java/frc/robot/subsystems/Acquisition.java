package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 *
 */
public class Acquisition extends SubsystemBase {

    private WPI_TalonSRX spinMotor;
    private CANSparkMax lowerMotor;

    /**
     *
     */
    public Acquisition() {

        spinMotor = new WPI_TalonSRX(10);
        spinMotor.configFactoryDefault();

        spinMotor.setInverted(false);
        spinMotor.setNeutralMode(NeutralMode.Coast);

        /* Set the peak and nominal outputs */
        spinMotor.configNominalOutputForward(0, 30);
        spinMotor.configNominalOutputReverse(0, 30);
        spinMotor.configPeakOutputForward(1, 30);
        spinMotor.configPeakOutputReverse(-1, 30);

        lowerMotor = new CANSparkMax(11, MotorType.kBrushless);

        lowerMotor.restoreFactoryDefaults();
        lowerMotor.setInverted(false);
        lowerMotor.setIdleMode(IdleMode.kCoast);
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

