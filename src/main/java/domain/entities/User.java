package domain.entities;

import domain.vo.UserEmail;
import domain.exceptions.UserRegistrationException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter
@Setter
@ToString(exclude = "password")
public class User {

    private Long id;
    private String name;
    private UserEmail email;
    private String password;

    public User(String name, UserEmail email, String password) {
        if (name == null || email == null || password == null) {
            throw new UserRegistrationException("Name, email, and password cannot be null.");
        }
        if (name.length() > 50) {
            throw new UserRegistrationException("Name cannot be longer than 50 characters.");
        }
        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
    }

    public void setEmail(UserEmail email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
