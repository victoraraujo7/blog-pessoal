package com.fernando.blogPessoal.repository;

import com.fernando.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
