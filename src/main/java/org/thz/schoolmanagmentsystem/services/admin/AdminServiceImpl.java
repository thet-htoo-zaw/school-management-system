package org.thz.schoolmanagmentsystem.services.admin;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thz.schoolmanagmentsystem.domain.User;
import org.thz.schoolmanagmentsystem.enums.UserRole;
import org.thz.schoolmanagmentsystem.repositories.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    @Override
    public void createAdminAccount() {

        if (userRepository.findByRole(UserRole.ADMIN) == null){
            User adminUser = new User();

            adminUser.setUsername("admin");
            adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            adminUser.setEmail("admin@gmail.com");
            adminUser.setRole(UserRole.ADMIN);

            userRepository.save(adminUser);
        }

    }
}
