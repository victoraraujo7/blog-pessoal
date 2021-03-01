package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity // indica essa classe vai ser uma entidade do jpa hibernate
@Table(name = "postagem") // essa entidade no banco de dados irá virar uma tabela
public class Postagem {

	// criar os atributos dessa classe =sql

	@Id // o atributo id sera o id da postagem
	@GeneratedValue(strategy = GenerationType.IDENTITY) // igual ao auto_increment E ser chave primaria
	private long id;

	@NotNull // para ser obrigatorio o preenchimento do campo
	@Size(min = 5, max = 100) // definir a qtd de caracter
	private String titulo;

	@NotNull
	@Size(min = 10, max = 500)
	private String texto;

	// precisamos de uma data, importar biblioteca util
	// calcular a data que foi postada com um metodo
	@Temporal(TemporalType.TIMESTAMP) // dizer para o jpa hibertante que estamos trabalhando com o tempo
	private Date date = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	// inserir os getters e setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
