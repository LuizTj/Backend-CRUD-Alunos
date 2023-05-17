package com.produto.faturamento.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.faturamento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	Usuario findByLogin(String Login);
	
}

