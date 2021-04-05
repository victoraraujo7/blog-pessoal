package com.fernando.blogPessoal.controller;

import com.fernando.blogPessoal.model.UserLogin;
import com.fernando.blogPessoal.model.Usuario;
import com.fernando.blogPessoal.repository.UsuarioRepository;
import com.fernando.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/logar")
    public ResponseEntity<UserLogin> authentication(@RequestBody Optional<UserLogin> user){
        return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
        Optional<Usuario> user = Optional.ofNullable(usuarioService.cadastrarUsuario(usuario));
        try {
            return ResponseEntity.ok(user.get());
        }catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
        Optional<Usuario> user = Optional.ofNullable(usuarioService.atualizarUsuario(usuario));
        try {
            return ResponseEntity.ok(user.get());
        }catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
