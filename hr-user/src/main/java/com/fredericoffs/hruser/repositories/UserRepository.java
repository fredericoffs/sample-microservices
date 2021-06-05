package com.fredericoffs.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericoffs.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
