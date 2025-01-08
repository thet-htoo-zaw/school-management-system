package org.thz.schoolmanagmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thz.schoolmanagmentsystem.domain.User;
import org.thz.schoolmanagmentsystem.enums.UserRole;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByRole(UserRole role);
}
