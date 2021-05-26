package com.application.CakesTreats.Services;

import org.springframework.stereotype.Service;

import com.application.CakesTreats.Entitys.Produto;
import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Enums.STATUS;
import com.application.CakesTreats.Repositorys.ProdutoRepository;

@Service
public class ProdutoService {
	private static ProdutoRepository repository;
	public static void setRepository(ProdutoRepository repository) {
		ProdutoService.repository = repository;
	}
	public static STATUS retornaStatusDoProduto(Produto p) {
		p.setSabor(SaboresService.retornaSaborPorNome(p.getSabor().getNome()));
		return repository.retonarStatusDoProduto(p.getNome(),p.getSabor());
	}
	public static Produto procurarPorId(long id) {
		return repository.findById(id).get();
	}
	public static Produto retornarProdutoPorNomeESabor(String nome,Sabores sabor) {
		return repository.retonarProdutoPorNomeESabor(nome, sabor);
	}

}
