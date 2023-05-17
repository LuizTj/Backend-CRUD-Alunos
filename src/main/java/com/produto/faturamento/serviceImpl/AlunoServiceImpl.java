package com.produto.faturamento.serviceImpl;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.faturamento.model.Aluno;
import com.produto.faturamento.model.Endereco;
import com.produto.faturamento.repository.AlunoRepository;
import com.produto.faturamento.repository.EnderecoRepository;
import com.produto.faturamento.service.AlunoService;
import com.produto.faturamento.service.EnderecoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoServide;

	@Override
	public Iterable<Aluno> buscarTodos() {

		return alunoRepository.findAll();
	}

	@Override
	public Aluno buscarPorId(UUID id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.get();
	}

	@Override
	public void cadastrar(Aluno aluno) {
		// TODO Auto-generated method stub
		salvarAlunoComCep(aluno);
	}

	@Override
	public void atualizar(String cpf, Aluno aluno) {
		// TODO Auto-generated method stub
		Optional<Aluno> alunoOptional = alunoRepository.findByCpf(cpf);
		if (alunoOptional.isPresent()) {
			salvarAlunoComCep(aluno);
		}

	}

	@Override
	@Transactional
	public void deletar(String cpf) {
		// TODO Auto-generated method stub
		alunoRepository.deleteByCpf(cpf);
	}

	@Override
	public Aluno buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		Optional<Aluno> aluno = alunoRepository.findByCpf(cpf);

		return aluno.get();
		
	

	}
	
	@Override
	public Iterable<Aluno> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return  alunoRepository.findByNome(nome);
		
	}

	private void salvarAlunoComCep(Aluno aluno) {
		String cep = aluno.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = enderecoServide.buscaCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		aluno.setEndereco(endereco);
		alunoRepository.save(aluno);
	}

	
}
