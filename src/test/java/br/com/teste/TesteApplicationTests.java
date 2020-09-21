package br.com.teste;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.teste.rest.PessoaController;
import br.com.teste.rest.UsuarioController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class TesteApplicationTests {
	
	@Autowired
	private PessoaController pessoaController;
	
	@Autowired
	private UsuarioController usuarioController;
	

	@Test
	void contextLoads() {
		assertThat(pessoaController).isNotNull();
		assertThat(usuarioController).isNotNull();
	}
}
