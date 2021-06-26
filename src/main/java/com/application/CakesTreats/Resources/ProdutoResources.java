package com.application.CakesTreats.Resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.CakesTreats.Entitys.Produto;
import com.application.CakesTreats.Enums.STATUS;
import com.application.CakesTreats.Services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResources {
	
	@PostMapping(value="/status")
	public ResponseEntity<STATUS> recuperarStatusDeProdutoComSabor(@RequestBody Produto p){
		return ResponseEntity.ok().body(ProdutoService.retornaStatusDoProduto(p));
	}
	@PostMapping(value="/recuperar")
	public ResponseEntity<Produto> recuperarProduto(@RequestBody Produto p){
		return ResponseEntity.ok().body(ProdutoService.retornarProdutoPorNomeESabor(p.getNome(),p.getSabor()));
	}
	@PostMapping(value="/teste")
	public ResponseEntity<List<Produto>> teste(){
		return ResponseEntity.ok().body(ProdutoService.retornarTodosProdutos());
	}
	@PostMapping(value="/novo")
	public ResponseEntity<Void> criarProduto(@RequestBody Produto p){
		ProdutoService.criarProduto(p);
		return ResponseEntity.ok().body(null);
	}
}
