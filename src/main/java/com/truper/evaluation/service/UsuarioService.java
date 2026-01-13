package com.truper.evaluation.service;

import com.truper.evaluation.domain.dto.UpdatePasswordRequest;
import com.truper.evaluation.exception.NotFoundException;
import com.truper.evaluation.repository.UsuarioRepository;
import com.truper.evaluation.security.entity.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService (UsuarioRepository usuarioRepository,
                           PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void changeOwnPassword(String username, UpdatePasswordRequest request) {
        UsuarioEntity user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado: " + username));

        if (!passwordEncoder.matches(request.getActualPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Password actual incorrecto");
        }

        if (request.getActualPassword().equals(request.getNuevoPassword())) {
            throw new IllegalArgumentException("El nuevo password no puede ser igual al actual");
        }

        user.setPassword(passwordEncoder.encode(request.getNuevoPassword()));
        usuarioRepository.save(user);
    }
}
