package com.newhorizons.takeitnow.products.presentation.web.controller;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.AuthRequestDto;
import com.newhorizons.takeitnow.products.application.mainmodule.dto.AuthResponseDto;
import com.newhorizons.takeitnow.products.domain.service.UserService;
import com.newhorizons.takeitnow.products.presentation.web.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> Login(@RequestBody AuthRequestDto authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
            UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
            String jwt = jwtUtility.buildToken(userDetails);

            return new ResponseEntity<>(new AuthResponseDto(jwt), HttpStatus.OK);
        }
        catch (BadCredentialsException ex)
        {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
