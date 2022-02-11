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

    public static boolean DEBUG = false;
    public static int SPARKMAX_CURRENT_LIMIT = 4;
    public static int TALON_CURRENT_LIMIT = 4;

    public static void init(String... fileNames) {
        cleanAllPreferences();
        loadConfiguration(fileNames);
        printPreferences(System.out);

        DEBUG = Preferences.getBoolean("debug", false);
        SPARKMAX_CURRENT_LIMIT = Preferences.getInt("sparkmax.currentLimit", 4);
        TALON_CURRENT_LIMIT = Preferences.getInt("talon.currentLimit", 4);
    }
}
