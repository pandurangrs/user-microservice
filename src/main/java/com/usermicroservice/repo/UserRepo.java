package com.usermicroservice.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.usermicroservice.entity.User;

public interface UserRepo  extends JpaRepository<User, Long>{

	Page<User> findByIsActiveTrue(Pageable pageable);

	Optional<User> findByUuid(String userUuid);

}
