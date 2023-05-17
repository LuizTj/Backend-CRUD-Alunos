package com.produto.faturamento.service;

import java.util.UUID;

import com.produto.faturamento.model.Aluno;

public interface AlunoService {

		Iterable<Aluno> buscarTodos();
		
		Aluno buscarPorId(UUID id);
		
		Aluno buscarPorCpf(String cpf);
		
		Iterable<Aluno> buscarPorNome(String nome);
		
		void cadastrar(Aluno aluno);
		
		void atualizar(String cpf, Aluno aluno);
		
		void deletar(String cpf);
		
		
		
}
