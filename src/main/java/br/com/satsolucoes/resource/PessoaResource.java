package br.com.satsolucoes.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.satsolucoes.model.Pessoa;
import br.com.satsolucoes.repository.PessoaRepository;
import br.com.satsolucoes.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaResource {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private PessoaService service;

	@GetMapping
	public List<Pessoa> getPessoas() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
		var optPessoa = repository.findById(id);

		return !optPessoa.isEmpty() ? ResponseEntity.ok(optPessoa.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa) {
		var pessoaSalva = repository.save(pessoa);

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		var pessoaAtualizada = service.updatePessoa(id, pessoa);

		return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
		service.deletePessoa(id);

		return ResponseEntity.ok().build();
	}
}
