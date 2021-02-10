package com.hrk.nikestore;

import com.hrk.nikestore.modules.user.model.Role;
import com.hrk.nikestore.modules.user.model.User;
import com.hrk.nikestore.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.Arrays;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
public class NikestoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(NikestoreApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
        builder.userDetailsService(s -> {
         User user = userRepository.findByEmail(s);
         return user;
        });
    }

}
