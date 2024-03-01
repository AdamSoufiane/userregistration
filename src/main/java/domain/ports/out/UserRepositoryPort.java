package domain.ports.out;

import domain.entities.User;
import domain.vo.UserEmail;
import java.util.Optional;
import domain.exceptions.UserRegistrationException;
import domain.exceptions.UserNotFoundException;

public interface UserRepositoryPort {

    User saveUser(User user) throws UserRegistrationException;

    Optional<User> findUserByEmail(UserEmail email);

    boolean deleteUser(User user) throws UserNotFoundException;

}