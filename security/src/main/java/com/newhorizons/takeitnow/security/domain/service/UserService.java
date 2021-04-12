package com.newhorizons.takeitnow.security.domain.service;

import com.newhorizons.takeitnow.security.domain.entity.UserApplication;
import com.newhorizons.takeitnow.security.infraestructure.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApplication userApplication = userRepository.authenticationByUsername(username);
        if(userApplication == null){
            logger.error("Error en el login, no existe el usuario " + username + " .");
            throw new UsernameNotFoundException("Error en el login, no existe el usuario " + username + " .");
        }

        List<GrantedAuthority> authorities = userApplication.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .peek(a -> logger.info("Role: " + a.getAuthority()))
                .collect(Collectors.toList());

        logger.info("Usuario autenticado correctamente " + username + " .");

        return new User(userApplication.getUsername(), userApplication.getPassword(), userApplication.getActive(), true, true, true, authorities);
    }
}
