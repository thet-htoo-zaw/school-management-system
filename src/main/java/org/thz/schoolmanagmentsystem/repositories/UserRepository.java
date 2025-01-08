package org.thz.schoolmanagmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thz.schoolmanagmentsystem.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
