package com.example.backend.web.rest;

import com.example.backend.config.util.JwtUtil;
import com.example.backend.model.User;
import com.example.backend.model.dto.AuthRequest;
import com.example.backend.model.dto.TokenRequest;
import com.example.backend.model.dto.UserDto;
import com.example.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:8080")
public class UserResource {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserResource(UserService userService,
                        JwtUtil jwtUtil,
                        AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/get-user-by-id/{userName}")
    public ResponseEntity<User> getUserById(@PathVariable String userName) {
        return userService.findUserByUsername(userName)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/user-expiration")
    public boolean userValidity(@RequestBody TokenRequest tokenRequest) {
        return !jwtUtil.isTokenExpired(tokenRequest.getToken());
    }

    @PostMapping("/get-user-by-token")
    public ResponseEntity<User> getUserByToken(@RequestBody TokenRequest tokenRequest) {
        String username = jwtUtil.extractUsername(tokenRequest.getToken());
        return userService.findUserByUsername(username).map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        return userService.register(userDto).map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()));
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}