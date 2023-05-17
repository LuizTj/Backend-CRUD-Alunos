package com.produto.faturamento.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity 
public class Endereco {
	
	@Id 
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	
	
	
}
