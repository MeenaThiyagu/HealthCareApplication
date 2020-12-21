package com.pharmaceutical.app.HealthcareApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pharmaceutical.app.HealthcareApplication.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
