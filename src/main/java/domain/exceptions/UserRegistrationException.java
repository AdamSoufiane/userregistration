package domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Custom exception class for user registration errors.
 */
@Getter
@NoArgsConstructor
public class UserRegistrationException extends RuntimeException {

    private static final String DEFAULT_ERROR_CODE = "USER_REGISTRATION_ERROR";

    private final String errorCode;

    /**
     * Constructor for UserRegistrationException with a detailed error message.
     *
     * @param message the detailed error message
     */
    public UserRegistrationException(String message) {
        super(message);
        this.errorCode = DEFAULT_ERROR_CODE;
    }

    /**
     * Constructor for UserRegistrationException with a detailed error message and a cause.
     *
     * @param message the detailed error message
     * @param cause   the cause of the exception
     */
    public UserRegistrationException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = DEFAULT_ERROR_CODE;
    }

}