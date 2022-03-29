package com.example.bemanagementdevice.controller;

import com.example.bemanagementdevice.config.JwtUtil;
import com.example.bemanagementdevice.config.MyUserDetailsService;
import com.example.bemanagementdevice.model.Account;
import com.example.bemanagementdevice.model.ERole;
import com.example.bemanagementdevice.model.JwtRequest;
import com.example.bemanagementdevice.model.JwtResponse;
import com.example.bemanagementdevice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @PostMapping("/signin")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        String token = null;
        String username = null;
        ERole role = null;
        UserDetails userDetails;
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            return new JwtResponse(token, username,role);
        }
        userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        token = jwtUtil.generateToken(userDetails);
        username=jwtRequest.getUsername();
        role = accountService.findById(jwtRequest.getUsername()).getRole();
        return new JwtResponse(token, username, role);
    }
}
