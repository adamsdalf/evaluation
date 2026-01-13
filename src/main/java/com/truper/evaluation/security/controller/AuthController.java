package com.truper.evaluation.security.controller;

import com.truper.evaluation.domain.dto.UpdatePasswordRequest;
import com.truper.evaluation.security.dto.UserRequest;
import com.truper.evaluation.security.dto.UserResponse;
import com.truper.evaluation.security.service.JwtService;
import com.truper.evaluation.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import java.util.Map;

@RestController
@RequestMapping("v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authenticationManager,
                          UserDetailsService userDetailsService,
                          JwtService jwtService, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new UserResponse(token));
    }


    @PutMapping("/password")
    public ResponseEntity<Map<String,String>> changeMyPassword(
            Authentication authentication,
            @Valid @RequestBody UpdatePasswordRequest request
    ) {
        String username = authentication.getName();
        usuarioService.changeOwnPassword(username, request);
        return ResponseEntity.ok(Map.of("message","Password actualizado"));
    }


}

