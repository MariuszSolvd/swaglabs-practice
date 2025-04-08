package com.solvd.utilis;

public enum AuthError {
    DO_NOT_MATCH_SERVICE("Username and password do not match any user in this service."),
    USERNAME_REQUIRED("Username is required"),
    PASSWORD_REQUIRED("Password is required"),
    LOCKED_USER("Sorry, this user has been locked out.")
    ;

    private final String message;

    AuthError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
