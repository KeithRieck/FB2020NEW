package frc.robot;

import edu.wpi.first.wpilibj.Preferences;
import static frc.robot.util.Config.cleanAllPreferences;
import static frc.robot.util.Config.loadConfiguration;
import static frc.robot.util.Config.printPreferences;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public class Constants {

    public static final int CHASSIS_LEFT_FRONT_MOTOR_CAN_ID = 2;
    public static final int CHASSIS_LEFT_REAR_MOTOR_CAN_ID = 3;
    public static final int CHASSIS_RIGHT_FRONT_MOTOR_CAN_ID = 4;
    public static final int CHASSIS_RIGHT_REAR_MOTOR_CAN_ID = 5;
    public static double CHASSIS_PID_P = 1.0;
    public static double CHASSIS_PID_I = 0.0;
    public static double CHASSIS_PID_D = 0.0;
    public static boolean CHASSIS_CLOSED_LOOP = false;

    public static boolean DEBUG;

    public static int SPARKMAX_LOWER_STALL_LIMIT;
    public static int SPARKMAX_LOWER_FREE_LIMIT;
    public static int SPARKMAX_LOWER_LIMIT_RPM;

    public static final int TALON_TIMEOUT = 30;
    public static int TALON_PEAK_CURRENT_LIMIT;
    public static int TALON_PEAK_CURRENT_DURATION;
    public static int TALON_CONTINUOUS_CURRENT_LIMIT;

    public static void init(String... fileNames) {
        cleanAllPreferences();
        loadConfiguration(fileNames);
        printPreferences(System.out);

        DEBUG = Preferences.getBoolean("DEBUG", false);
        CHASSIS_CLOSED_LOOP = Preferences.getBoolean("CHASSIS_CLOSED_LOOP", false);

        SPARKMAX_LOWER_STALL_LIMIT = Preferences.getInt("SPARKMAX_LOWER_STALL_LIMIT", 20);
        SPARKMAX_LOWER_FREE_LIMIT = Preferences.getInt("SPARKMAX_LOWER_FREE_LIMIT", 10);
        SPARKMAX_LOWER_LIMIT_RPM = Preferences.getInt("SPARKMAX_LOWER_LIMIT_RPM", 500);

        TALON_PEAK_CURRENT_LIMIT = Preferences.getInt("TALON_PEAK_CURRENT_LIMIT", 30);
        TALON_PEAK_CURRENT_DURATION = Preferences.getInt("TALON_PEAK_CURRENT_DURATION", 100);
        TALON_CONTINUOUS_CURRENT_LIMIT = Preferences.getInt("TALON_CONTINUOUS_CURRENT_LIMIT", 20);

        CHASSIS_PID_P = Preferences.getDouble("CHASSIS_PID_P", 1.0);
        CHASSIS_PID_I = Preferences.getDouble("CHASSIS_PID_I", 0.0);
        CHASSIS_PID_D = Preferences.getDouble("CHASSIS_PID_D", 0.0);
    }
}
