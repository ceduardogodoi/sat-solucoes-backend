package br.com.satsolucoes.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.satsolucoes.model.Pessoa;
import br.com.satsolucoes.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa findById(Long id) {
		var optPessoa = repository.findById(id).get();

		if (optPessoa == null) {
			throw new NoSuchElementException();
		}

		return optPessoa;
	}

	public Pessoa updatePessoa(Long id, Pessoa pessoa) {
		var pessoaEncontrada = findById(id);

		BeanUtils.copyProperties(pessoa, pessoaEncontrada, "id");

		return repository.save(pessoaEncontrada);
	}

	public void deletePessoa(Long id) {
		findById(id);

		repository.deleteById(id);
	}

}
