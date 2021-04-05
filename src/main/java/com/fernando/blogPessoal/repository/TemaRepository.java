 package com.fernando.blogPessoal.repository;

import java.util.List;

import com.fernando.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
