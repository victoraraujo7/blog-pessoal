package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// herdar de uma outra interface Jpa.Repository 
//e indicar os parametros(entidades)  e qual a tipagem do id chave primaria no tipo primitivo "Long"
@Repository	// indicar para o string que essa classe se trata de um repositorio
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
// consulta pelo tipo da postagem
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
