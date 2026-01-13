package com.truper.evaluation.security.service;

import com.truper.evaluation.security.entity.UsuarioEntity;
import com.truper.evaluation.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

        private final UsuarioRepository usuarioRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UsuarioEntity u = usuarioRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe: " + username));

            return User.builder()
                    .username(u.getUsername())
                    .password(u.getPassword())
                    .roles(u.getPerfil().toUpperCase()) // admin -> ROLE_ADMIN, user -> ROLE_USER
                    .build();
        }
    }
