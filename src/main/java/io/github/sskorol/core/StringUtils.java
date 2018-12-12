package io.github.sskorol.core;

/**
 * Some utility class definition.
 */
public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor");
    }

    public static String wrap(final String input) {
        return '-' + input;
    }
}
