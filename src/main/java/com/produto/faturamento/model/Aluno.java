package com.produto.faturamento.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	
	@Id 
	@GeneratedValue 
	private UUID id;
	private String nome;
	@ManyToOne
	private Endereco endereco;
	private String contato;
	private String cpf;
	

}
