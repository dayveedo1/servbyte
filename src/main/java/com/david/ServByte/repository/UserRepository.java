package com.david.ServByte.repository;

import com.david.ServByte.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
