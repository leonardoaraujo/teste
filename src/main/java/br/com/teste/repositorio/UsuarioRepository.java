package br.com.teste.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.entidade.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
