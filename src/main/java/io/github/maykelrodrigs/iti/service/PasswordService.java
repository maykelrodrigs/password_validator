package io.github.maykelrodrigs.iti.service;

import io.github.maykelrodrigs.iti.util.Regex;
import io.github.maykelrodrigs.iti.util.RegexUtil;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public boolean validate(final String password) {
        if (!RegexUtil.hasNoDuplicateChar(password)) {
            return false;
        }
        return RegexUtil.isValid(Regex.PASSWORD.value(), password);
    }

}
