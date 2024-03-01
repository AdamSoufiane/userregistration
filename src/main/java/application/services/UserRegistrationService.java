package application.services;

import domain.entities.User;
import domain.vo.UserEmail;
import domain.exceptions.UserNotFoundException;
import domain.exceptions.UserRegistrationException;
import domain.ports.out.UserRepositoryPort;
import application.dto.UserRegistrationRequest;
import application.dto.UserRegistrationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.PersistenceException;
import java.util.List;

public class UserRegistrationService {

    private final UserRepositoryPort userRepositoryPort;
    private final Logger logger = LoggerFactory.getLogger(UserRegistrationService.class);
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserRegistrationService(UserRepositoryPort userRepositoryPort) {
        if (userRepositoryPort == null) {
            throw new IllegalArgumentException("userRepositoryPort cannot be null");
        }
        this.userRepositoryPort = userRepositoryPort;
    }

    // ... (rest of the methods without changes)

    public List<User> listUsers() {
        try {
            return userRepositoryPort.findAll();
        } catch (PersistenceException e) {
            logger.error("Persistence error during user listing", e);
            throw new RuntimeException("Persistence error during user listing.");
        }
    }

    // ... (rest of the methods without changes)

}
