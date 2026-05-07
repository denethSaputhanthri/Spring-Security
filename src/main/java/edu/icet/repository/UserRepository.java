package edu.icet.repository;

import edu.icet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
        User findByUsername(String username);
}
