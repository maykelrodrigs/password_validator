package io.github.maykelrodrigs.iti;

import io.github.maykelrodrigs.iti.util.Regex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    void when_regex_is_valid_return_true() {
        String regex = "^[A-Za-z]{2}";
        String value = "ab";
        boolean result = Regex.isValid(regex, value);
        Assertions.assertTrue(result);
    }

    @Test
    void when_regex_is_false_return_false() {
        String regex = "^[A-Za-z]{2}";
        String value = "abc";
        boolean result = Regex.isValid(regex, value);
        Assertions.assertFalse(result);
    }

    @Test
    void when_regex_is_null_return_false() {
        String value = "abc";
        boolean result = Regex.isValid(null, value);
        Assertions.assertFalse(result);
    }

    @Test
    void when_value_is_null_return_false() {
        String regex = "^[A-Za-z]{2}";
        boolean result = Regex.isValid(regex, null);
        Assertions.assertFalse(result);
    }

}
