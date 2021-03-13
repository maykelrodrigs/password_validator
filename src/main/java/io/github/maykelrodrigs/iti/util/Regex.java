package io.github.maykelrodrigs.iti.util;

public enum Regex {

    DUPLICATE_CHAR("^(?:([\\w-+!@#$%^&*()])(?!.*\\1))*$"),
    PASSWORD("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()-+])(?=.*[\\W_])\\S{9,}$");

    private final String value;

    Regex(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
