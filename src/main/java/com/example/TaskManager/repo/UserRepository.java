package com.example.TaskManager.repo;

import com.example.TaskManager.models.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByUsername(@NotBlank String username);

    boolean existsByUsername(String username);
}
