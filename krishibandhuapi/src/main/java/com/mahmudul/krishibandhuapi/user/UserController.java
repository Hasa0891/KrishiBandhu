package com.mahmudul.krishibandhuapi.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahmudul.krishibandhuapi.config.JwtTokenUtil;
import com.mahmudul.krishibandhuapi.dtos.AuthRequestDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class UserController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final KUserDetailsService userDetailsService;

    public UserController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, KUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequestDTO authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        System.out.println(authRequest);
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return ResponseEntity.ok(jwtTokenUtil.generateToken(userDetails.getUsername()));
    }
}
