package com.hrk.nikestore.modules.user.service;

import com.hrk.nikestore.modules.user.model.User;
import com.hrk.nikestore.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByEmail(s);
            return user;
        } catch (Exception e) {
            throw new UsernameNotFoundException("User Not Found Dada");
        }
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
