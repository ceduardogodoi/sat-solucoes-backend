package br.com.satsolucoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.satsolucoes.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
