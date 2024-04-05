package edu.iu.aav.primesservice.controller;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.aav.primesservice.model.Customer;
import edu.iu.aav.primesservice.service.IAuthenticationService;
import edu.iu.aav.primesservice.service.TokenService;

@RestController
@CrossOrigin({"http://127.0.0.1:5500"})
public class AuthenticationController {

    private IAuthenticationService authenticationService;

    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    public AuthenticationController(IAuthenticationService authenticationService,
                                    AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        System.out.println("In Registers");
        try {
            return authenticationService.register(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
        return tokenService.generateToken(authentication);
    }
}