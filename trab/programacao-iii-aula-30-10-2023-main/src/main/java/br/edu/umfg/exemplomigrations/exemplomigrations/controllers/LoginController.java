package br.edu.umfg.exemplomigrations.exemplomigrations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastro")
    public Map<String, Object> cadastrarUsuario(@RequestBody Usuario usuario) {
        Map<String, Object> response = new HashMap<>();

        // Verificar se o email já está cadastrado
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            response.put("success", false);
            response.put("message", "Este email já está cadastrado.");
        } else {
            usuarioRepository.save(usuario);
            response.put("success", true);
            response.put("message", "Usuário cadastrado com sucesso.");
        }

        return response;
    }

    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam String email, @RequestParam String senha) {
        Map<String, Object> response = new HashMap<>();

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailAndSenha(email, senha);

        if (usuarioOptional.isPresent()) {
            response.put("success", true);
            response.put("message", "Cliente logado com sucesso.");
        } else {
            response.put("success", false);
            response.put("message", "Credenciais inválidas.");
        }

        return response;
    }
}

