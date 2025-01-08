package org.thz.schoolmanagmentsystem.services.admin;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thz.schoolmanagmentsystem.domain.User;
import org.thz.schoolmanagmentsystem.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @PostConstruct
    @Override
    public void createAdminAccount() {
        User adminUser = new User();

        adminUser.setUsername("admin");
        adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
        adminUser.setEmail("admin@gmail.com");

        userRepository.save(adminUser);
    }
}
