package br.com.teste.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.teste.entidade.Pessoa;
import br.com.teste.service.impl.PessoaServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

	private PessoaServiceImpl pessoaService;

	@Autowired
	public PessoaController(PessoaServiceImpl pessoaService) {
		this.pessoaService = pessoaService;
	}
	

    @GetMapping
    public List<Pessoa> obterTodos(){
        return pessoaService.findAll();
    }

	@PostMapping("/salvar/")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody @Valid Pessoa pessoa) {
		try {
			pessoaService.salvar(pessoa);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@GetMapping("/pesquisar/{id}")
	public Pessoa pesquisarPorId(@PathVariable Long id) {
		return pessoaService.pesquisarPorId(id);
	}

	@DeleteMapping("/apagar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		pessoaService.apagar(id);
	}

	@PutMapping("/atualizar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa pessoaAtualizada) {
		pessoaService.atualizar(id, pessoaAtualizada);
	}

}
