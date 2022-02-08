package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Chassis;

/**
 *
 */
public class ChassisDriveCommand extends CommandBase {

    private final Chassis m_chassis;
    private final XboxController xboxController;

    public ChassisDriveCommand(Chassis subsystem, XboxController controller) {
        xboxController = controller;
        m_chassis = subsystem;
        addRequirements(m_chassis);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double speed = xboxController.getLeftY();
        double rotation = xboxController.getLeftX();
        m_chassis.arcadeDrive(speed, rotation);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
