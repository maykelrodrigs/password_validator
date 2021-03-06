package io.github.maykelrodrigs.iti;

import io.github.maykelrodrigs.iti.util.Regex;
import io.github.maykelrodrigs.iti.util.RegexUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegexUtilTest {

    @Test
    void when_regex_is_valid_return_true() {
        String value = "AbTp9!fok";
        boolean result = RegexUtil.isValid(Regex.PASSWORD, value);
        Assertions.assertTrue(result);
    }

    @Test
    void when_regex_is_false_return_false() {
        String value = "AbTp9 fok";
        boolean result = RegexUtil.isValid(Regex.PASSWORD, value);
        Assertions.assertFalse(result);
    }

    @Test
    void when_regex_is_null_return_false() {
        String value = "abc";
        boolean result = RegexUtil.isValid(null, value);
        Assertions.assertFalse(result);
    }

    @Test
    void when_value_is_null_return_false() {
        boolean result = RegexUtil.isValid(Regex.PASSWORD, null);
        Assertions.assertFalse(result);
    }

    @Test
    void when_value_non_duplicate_char_return_true() {
        String value = "abc123!@#$%^&*()-+";
        boolean result = RegexUtil.hasNoDuplicateChar(value);
        Assertions.assertTrue(result);
    }

    @Test
    void when_value_is_null_duplicate_char_return_false() {
        boolean result = RegexUtil.hasNoDuplicateChar(null);
        Assertions.assertFalse(result);
    }

    @Test
    void when_value_is_duplicate_char_return_false() {
        String value = "abc1-23!@#$%^&*()-+";
        boolean result = RegexUtil.hasNoDuplicateChar(value);
        Assertions.assertFalse(result);
    }

}
