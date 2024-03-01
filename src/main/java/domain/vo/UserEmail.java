package domain.vo;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.regex.Pattern;
import domain.exceptions.EmailValidationException;

@Getter
@EqualsAndHashCode
@ToString
public class UserEmail {

    private final String email;
    private static final Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public UserEmail(String email) throws EmailValidationException {
        if (!validateEmail(email)) {
            throw new EmailValidationException("Invalid email format");
        }
        this.email = email;
    }

    public static boolean validateEmail(String email) {
        return pattern.matcher(email).matches();
    }
}
