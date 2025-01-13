package org.thz.schoolmanagmentsystem.services.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thz.schoolmanagmentsystem.domain.User;
import org.thz.schoolmanagmentsystem.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional< User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isEmpty()) { throw new UsernameNotFoundException("User not found", null);}

        return new org.springframework.security.core.userdetails.User(optionalUser.get().getUsername(),
                optionalUser.get().getPassword(),new ArrayList<>());
    }
}
