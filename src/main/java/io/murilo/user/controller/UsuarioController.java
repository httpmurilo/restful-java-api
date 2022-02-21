package io.murilo.user.controller;

import io.murilo.user.model.Usuario;
import io.murilo.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        Usuario usuario = usuarioRepository.getById(id);
        return  ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return  new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Usuario> postUser(@RequestBody Usuario user) {
        Usuario savedUser = salvarUsuario(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return  ResponseEntity.ok("Usuário deletado com sucesso");
    }

    @PutMapping(value = "/")
    public ResponseEntity<Usuario> putUser(@RequestBody Usuario user) {
        Usuario savedUser = salvarUsuario(user);
        return ResponseEntity.ok(savedUser);
    }

    protected Usuario salvarUsuario(@RequestBody Usuario user) {
        return usuarioRepository.save(user);
    }

}
