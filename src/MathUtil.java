/**
 * Utility class, currently contains functions for generating random values.
 */
public class MathUtil {
    public static int getRandomInt(final int min, final int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static double getRandomDouble(final double min, final double max) {
        return (Math.random() * (max - min)) + min;
    }
}
