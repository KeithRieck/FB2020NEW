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

        DEBUG = Preferences.getBoolean("debug", false);

        SPARKMAX_LOWER_STALL_LIMIT = Preferences.getInt("SPARKMAX_LOWER_STALL_LIMIT", 20);
        SPARKMAX_LOWER_FREE_LIMIT = Preferences.getInt("SPARKMAX_LOWER_FREE_LIMIT", 10);
        SPARKMAX_LOWER_LIMIT_RPM = Preferences.getInt("SPARKMAX_LOWER_LIMIT_RPM", 500);

        TALON_PEAK_CURRENT_LIMIT = Preferences.getInt("TALON_PEAK_CURRENT_LIMIT", 30);
        TALON_PEAK_CURRENT_DURATION = Preferences.getInt("TALON_PEAK_CURRENT_DURATION", 100);
        TALON_CONTINUOUS_CURRENT_LIMIT = Preferences.getInt("TALON_CONTINUOUS_CURRENT_LIMIT", 20);
    }
}
