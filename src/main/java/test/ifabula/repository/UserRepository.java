package test.ifabula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.ifabula.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndIsDeleted(String email, boolean isDeleted);
}
