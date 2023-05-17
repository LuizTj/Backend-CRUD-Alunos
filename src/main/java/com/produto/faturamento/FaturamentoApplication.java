package com.produto.faturamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FaturamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaturamentoApplication.class, args);
		
	}

}
