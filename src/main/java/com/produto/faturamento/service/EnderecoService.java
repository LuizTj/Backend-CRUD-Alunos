package com.produto.faturamento.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.produto.faturamento.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface EnderecoService {
	
	@GetMapping("{cep}/json")
	Endereco buscaCep(@PathVariable ("cep") String cep);

}
