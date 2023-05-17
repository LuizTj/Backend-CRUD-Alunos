package com.produto.faturamento.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produto.faturamento.model.Usuario;
import com.produto.faturamento.repository.UsuarioRepository;

@RestController
@RequestMapping("adm-crud")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public String cadastro(@RequestBody Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		Usuario u = repository.save(usuario);
		
		return "usuario cadastrado com sucesso";
	
	}
	@GetMapping
	public ResponseEntity<List<Usuario>>buscarTodos(){
		List<Usuario>u	= repository.findAll();
		
		return new ResponseEntity<List<Usuario>>(u,HttpStatus.OK);
	
	}
	
	@DeleteMapping
	public String deletar(@RequestParam("id") UUID id) {
		repository.deleteById(id);
		return "Usuario Deletado com sucesso";
	}
	
	@PutMapping
	public ResponseEntity<Usuario>atualizar(@RequestBody Usuario usuario){
		
		Optional<Usuario> uTemp = repository.findById(usuario.getId());
		
		if(uTemp.isEmpty()) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			
		}
		
		Usuario u = repository.save(usuario);
		
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		
	}
	
}
