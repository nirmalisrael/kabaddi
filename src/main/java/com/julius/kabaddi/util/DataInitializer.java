package com.julius.kabaddi.util;

import com.julius.kabaddi.entity.Role;
import com.julius.kabaddi.entity.User;
import com.julius.kabaddi.repository.RoleRepository;
import com.julius.kabaddi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        try {
            Role role = roleRepository.findById("SUPER_ADMIN").orElse(null);
            User user = userRepository.findByUsername("admin").orElse(null);

            if (role == null) {
                Role adminRole = new Role("SUPER_ADMIN", "default role for super admin");
                role = roleRepository.save(adminRole);
            }
            if (user == null) {
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("admin"));
                Set<Role> roles = new HashSet<>();
                roles.add(role);
                adminUser.setRoles(roles);
                userRepository.save(adminUser);
            }
        } catch (Exception ex) {
            LOGGER.error("Something went wrong while creating default role and admin user! ", ex);
        }
    }
}
