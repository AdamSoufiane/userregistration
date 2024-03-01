package infrastructure.persistence;

import domain.entities.User;
import domain.exceptions.UserNotFoundException;
import domain.exceptions.UserRegistrationException;
import domain.ports.out.UserRepositoryPort;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Getter
@Setter
@NoArgsConstructor
public class PostgresUserRepositoryAdapter implements UserRepositoryPort {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        try {
            entityManager.persist(user);
            entityManager.flush();
            return user;
        } catch (PersistenceException e) {
            throw new UserRegistrationException("Unable to persist user", e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }
        try {
            List<User> users = entityManager.createNamedQuery("User.findByEmail", User.class)
                    .setParameter("email", email)
                    .getResultList();
            return users.stream().findFirst();
        } catch (PersistenceException e) {
            throw new UserRegistrationException("Unable to retrieve user by email", e);
        }
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        try {
            return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        } catch (PersistenceException e) {
            throw new UserRegistrationException("Unable to retrieve users", e);
        }
    }
}
