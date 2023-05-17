package com.produto.faturamento.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produto.faturamento.model.Aluno;
import com.produto.faturamento.service.AlunoService;

@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("alunos")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<Iterable<Aluno>> buscarTodos(){
		return ResponseEntity.ok(alunoService.buscarTodos());
	}
	
	@GetMapping("/consulta-cpf/{cpf}")
	public ResponseEntity<Aluno> buscarAlunoPorCpf(@PathVariable String cpf){
		Aluno aluno = alunoService.buscarPorCpf(cpf);
		return ResponseEntity.ok(aluno);
	}
	
	@GetMapping("/consulta-nome/{nome}")
	public ResponseEntity<Iterable<Aluno>> buscarAlunoPorNome (@PathVariable String nome){
		return ResponseEntity.ok(alunoService.buscarPorNome(nome));
	
	}
	@PostMapping
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno){
		alunoService.cadastrar(aluno);
		return ResponseEntity.ok(aluno);
	}
	
	@DeleteMapping
	public void excluir(@RequestParam ("cpf") String cpf) {
		alunoService.deletar(cpf);
		
	}
	
	@PutMapping
	public ResponseEntity<Aluno> atualizarCadastro(@RequestBody Aluno aluno){
		alunoService.atualizar(aluno.getCpf(), aluno);
		return ResponseEntity.ok(aluno);
	}
	
	
}

