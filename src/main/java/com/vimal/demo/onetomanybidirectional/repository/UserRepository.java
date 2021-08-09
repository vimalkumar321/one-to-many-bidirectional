package com.vimal.demo.onetomanybidirectional.repository;

import com.vimal.demo.onetomanybidirectional.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
