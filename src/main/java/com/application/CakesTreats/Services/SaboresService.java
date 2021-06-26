package com.application.CakesTreats.Services;

import org.springframework.stereotype.Service;

import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Repositorys.SaboresRepository;

@Service
public class SaboresService {

	private static SaboresRepository repository;
	public static void setRepository(SaboresRepository reposi) {
		repository = reposi;
	}
	public static Sabores retornaSaborPorNome(String nome) {
		return repository.retonarSaborPorNome(nome);
	}
	public static void criarSabor(Sabores sabor) {
		repository.save(sabor);
	}
}
