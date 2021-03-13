package io.github.maykelrodrigs.iti.service;

import io.github.maykelrodrigs.iti.util.Regex;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public boolean validate(final String password) {
        return Regex.isValid("", password);
    }

}
