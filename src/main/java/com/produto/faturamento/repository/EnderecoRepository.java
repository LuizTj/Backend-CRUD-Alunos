package com.produto.faturamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.faturamento.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
