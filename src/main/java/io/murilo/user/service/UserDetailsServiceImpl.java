package io.murilo.user.service;

import io.murilo.user.model.Usuario;
import io.murilo.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuarioByLogin(s);

        if(usuario == null)
            throw new UsernameNotFoundException("Username não encontrado");

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
    }
}
