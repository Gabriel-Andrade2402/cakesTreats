package com.application.CakesTreats.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.application.CakesTreats.Repositorys.PedidosRepository;
import com.application.CakesTreats.Repositorys.ProdutoRepository;
import com.application.CakesTreats.Repositorys.SaboresRepository;
import com.application.CakesTreats.Repositorys.UsuariosRepository;
import com.application.CakesTreats.Services.PedidosService;
import com.application.CakesTreats.Services.ProdutoService;
import com.application.CakesTreats.Services.SaboresService;
import com.application.CakesTreats.Services.UsuariosService;

@Service
public class Inicializacao implements ApplicationRunner{
	@Autowired
	private ProdutoRepository repositoryProduto;
	@Autowired
	private PedidosRepository repositoryPedidos;
	@Autowired
	private UsuariosRepository repositoryUsuarios;
	@Autowired
	private SaboresRepository repositorySabores;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		PedidosService.setRepository(repositoryPedidos);
		UsuariosService.setRepository(repositoryUsuarios);
		ProdutoService.setRepository(repositoryProduto);
		SaboresService.setRepository(repositorySabores);
	}

}
