package br.com.teste.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.entidade.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
