package br.com.teste.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.teste.constante.Constantes;
import br.com.teste.entidade.Pessoa;
import br.com.teste.repositorio.PessoaRepository;
import br.com.teste.servico.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	private PessoaRepository pessoaRepository;

	@Autowired
	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa pesquisarPorId(Long id) {
		return pessoaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constantes.PESSOA_NAO_ENCONTRADA));
	}

	public void apagar(Long id) {
		pessoaRepository.findById(id).map(pessoa -> {
			pessoaRepository.delete(pessoa);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constantes.PESSOA_NAO_ENCONTRADA));
	}

	public void atualizar(Long id, Pessoa pessoaAtualizada) {
		pessoaRepository.findById(id).map(pessoa -> {
			pessoaAtualizada.setId(pessoa.getId());
			return pessoaRepository.save(pessoaAtualizada);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, Constantes.PESSOA_NAO_ENCONTRADA));
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
}
