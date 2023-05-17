package com.produto.faturamento.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Usuario {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String login;
	private String senha;
	private String role;
 
	
}
