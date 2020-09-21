package br.com.teste.servico;

import java.util.List;

import br.com.teste.entidade.Pessoa;

public interface PessoaService {

	public Pessoa salvar(Pessoa pessoa);

	public Pessoa pesquisarPorId(Long id);

	public void apagar(Long id);

	public void atualizar(Long id, Pessoa pessoaAtualizada);

	public List<Pessoa> findAll();
}
