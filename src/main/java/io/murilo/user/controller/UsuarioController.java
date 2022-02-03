package io.murilo.user.controller;

import io.murilo.user.Model.Usuario;
import io.murilo.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
