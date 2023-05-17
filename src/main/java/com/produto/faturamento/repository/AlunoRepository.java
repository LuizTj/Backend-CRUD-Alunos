package com.produto.faturamento.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.produto.faturamento.model.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, UUID>{
	
	Optional<Aluno> findByCpf(String cpf);
	
	@Query("select a from Aluno a where a.nome like %?1%")
	Iterable<Aluno> findByNome(String nome);


	@Modifying(flushAutomatically = true)
	@Query("delete from Aluno a where a.cpf=:cpf")
	void deleteByCpf( @Param("cpf") String cpf);
}
