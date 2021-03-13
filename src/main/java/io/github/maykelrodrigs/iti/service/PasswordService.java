package io.github.maykelrodrigs.iti.service;

import io.github.maykelrodrigs.iti.util.Regex;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()-+])(?=.*[\\W_])\\S{9,}$";

    public boolean validate(final String password) {
        if (Regex.hasDuplicateChar(password)) {
            return false;
        }
        return Regex.isValid(REGEX_PASSWORD, password);
    }

}
