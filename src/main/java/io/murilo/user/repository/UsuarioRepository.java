package io.murilo.user.repository;

import io.murilo.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.login = ?1 ")
    Usuario findUsuarioByLogin(String login);
}
