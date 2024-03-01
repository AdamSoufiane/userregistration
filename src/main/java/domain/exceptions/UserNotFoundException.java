package domain.exceptions;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2L;
    private final String userId;
}