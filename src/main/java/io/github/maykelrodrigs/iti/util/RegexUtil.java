package io.github.maykelrodrigs.iti.util;

import java.util.regex.Pattern;

import static java.util.Objects.isNull;

public final class RegexUtil {

    RegexUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean isValid(final Regex regex, final String value) {
        if (isNull(regex) || isNull(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex.value());
        return pattern.matcher(value).matches();
    }

    public static boolean hasNoDuplicateChar(final String value) {
        if (isNull(value)) {
            return false;
        }
        Pattern pattern = Pattern.compile(Regex.DUPLICATE_CHAR.value());
        return pattern.matcher(value).matches();
    }

}
