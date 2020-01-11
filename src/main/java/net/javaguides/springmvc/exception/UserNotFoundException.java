package net.javaguides.springmvc.exception;

public class UserNotFoundException extends RuntimeException {

    private String errorMessage;

    public UserNotFoundException(int id, String errorMessage) {
        super(String.format("User id not found: %s", id));
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
