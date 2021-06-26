package com.application.CakesTreats.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.application.CakesTreats.Entitys.Produto;
import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Enums.STATUS;
import com.application.CakesTreats.Enums.TIPO;
import com.application.CakesTreats.Enums.UM;
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
		Sabores sabor= new Sabores(null, "morango");
		Sabores sabor2=new Sabores(null, "cholate");
		repositorySabores.save(sabor);
		repositorySabores.save(sabor2);
		Produto product=new Produto(null, "bolo1",55.00, TIPO.BOLO_tipo1,null, null, STATUS.PRODUZINDO, UM.kg, sabor2);
		Produto product2=new Produto(null, "bolo1",45.00, TIPO.BOLO_tipo1,null, null, STATUS.PRODUZINDO, UM.kg, sabor);
		repositoryProduto.save(product);
		repositoryProduto.save(product2);
		PedidosService.setRepository(repositoryPedidos);
		UsuariosService.setRepository(repositoryUsuarios);
		ProdutoService.setRepository(repositoryProduto);
		SaboresService.setRepository(repositorySabores);
	}

}
