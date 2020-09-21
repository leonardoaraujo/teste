package br.com.teste.servico.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.teste.constante.Constantes;
import br.com.teste.entidade.Pessoa;
import br.com.teste.repositorio.PessoaRepository;
import br.com.teste.service.impl.PessoaServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class PessoaServiceImplTest {

	@SpyBean
	PessoaServiceImpl service;

	@MockBean
	PessoaRepository repository;

	@Test
	void deveBuscarTodasPessoas() {
		List<Pessoa> pessoaLista = repository.findAll();
		assertThat(pessoaLista).isNotNull();
	}
	
	@Test
	void deveBuscarPessoaPorId() {
		Optional<Pessoa> pessoa = repository.findById(1L);
		assertThat(pessoa).isNotNull();
	}
	
	@Test
	void deveSalvarPessoa() {
		Pessoa pessoaCadastro = new Pessoa();
		Pessoa pessoa = criarPessoa();
		pessoaCadastro = service.salvar(pessoa);
		assertThat(pessoaCadastro != null);
	}
	
	
	private static Pessoa criarPessoa() {
		return Pessoa.builder()
			.id(5L)
			.nome("Fulana")
			.sexo("Feminino")
			.email("fulana@gmail.com")
			.cpf("39566848005")
			.naturalidade("Carioca")
			.nacionalidade("Brasileira")
			.dataNascimento(LocalDate.now() )
			.build();
		
	}
}
