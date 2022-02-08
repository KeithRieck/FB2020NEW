package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    // The robot's subsystems
    public final Storage m_storage = new Storage();
    public final Shooter m_shooter = new Shooter();
    public final Loader m_loader = new Loader();
    public final Climber m_climber = new Climber();
    public final Chassis m_chassis = new Chassis();
    public final Acquisition m_acquisition = new Acquisition();

    // Joysticks
    private final XboxController xboxController1 = new XboxController(1);
    private final XboxController xboxController0 = new XboxController(0);


    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    private RobotContainer() {
        // Smartdashboard Subsystems

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("AcquisitionLowerCommand", new AcquisitionLowerCommand(m_acquisition));
        SmartDashboard.putData("AcquisitionRaiseCommand", new AcquisitionRaiseCommand(m_acquisition));
        SmartDashboard.putData("AcquisitionSpitCommand", new AcquisitionSpitCommand(m_acquisition));
        SmartDashboard.putData("ShootAllCommand", new ShootAllCommand(m_shooter));
        SmartDashboard.putData("ClimberRetractCommand", new ClimberRetractCommand(m_climber));
        SmartDashboard.putData("ClimberExtendCommand", new ClimberExtendCommand(m_climber));

        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        m_chassis.setDefaultCommand(new ChassisDriveCommand(m_chassis, xboxController0));

        // Configure autonomous sendable chooser

        m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Auto Mode", m_chooser);
    }

    public static RobotContainer getInstance() {
        return m_robotContainer;
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // Create some buttons
        final JoystickButton climberExtendButton = new JoystickButton(xboxController1, XboxController.Button.kY.value);
        climberExtendButton.whenPressed(new ClimberExtendCommand(m_climber), true);
        SmartDashboard.putData("climberExtendButton", new ClimberExtendCommand(m_climber));

        final JoystickButton climberRetractButton = new JoystickButton(xboxController1, XboxController.Button.kX.value);
        climberRetractButton.whenHeld(new ClimberRetractCommand(m_climber), true);
        SmartDashboard.putData("climberRetractButton", new ClimberRetractCommand(m_climber));

        final JoystickButton shootAllButton = new JoystickButton(xboxController1, XboxController.Button.kA.value);
        shootAllButton.whenPressed(new ShootAllCommand(m_shooter), true);
        SmartDashboard.putData("shootAllButton", new ShootAllCommand(m_shooter));

        final JoystickButton acquisitionSpitButton = new JoystickButton(xboxController0, XboxController.Button.kB.value);
        acquisitionSpitButton.whenPressed(new AcquisitionSpitCommand(m_acquisition), true);
        SmartDashboard.putData("acquisitionSpitButton", new AcquisitionSpitCommand(m_acquisition));

        final JoystickButton acquisitionRaisButton = new JoystickButton(xboxController0, XboxController.Button.kRightBumper.value);
        acquisitionRaisButton.whenPressed(new AcquisitionRaiseCommand(m_acquisition), true);
        SmartDashboard.putData("acquisitionRaisButton", new AcquisitionRaiseCommand(m_acquisition));

        final JoystickButton acquisitionLowerButton = new JoystickButton(xboxController0, XboxController.Button.kLeftBumper.value);
        acquisitionLowerButton.whenPressed(new AcquisitionLowerCommand(m_acquisition), true);
        SmartDashboard.putData("acquisitionLowerButton", new AcquisitionLowerCommand(m_acquisition));
    }

    public XboxController getxboxController0() {
        return xboxController0;
    }

    public XboxController getxboxController1() {
        return xboxController1;
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // The selected command will be run in autonomous
        return m_chooser.getSelected();
    }


}

