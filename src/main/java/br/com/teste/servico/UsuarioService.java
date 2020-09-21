package br.com.teste.servico;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import br.com.teste.entidade.Usuario;

public interface UsuarioService {

    public Usuario salvar(Usuario usuario);

    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException;
}
