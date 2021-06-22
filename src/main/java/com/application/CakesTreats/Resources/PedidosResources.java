package com.application.CakesTreats.Resources;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.CakesTreats.Entitys.Pedido;
import com.application.CakesTreats.Services.PedidosService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosResources {
	@PostMapping(value = "/novo")
	public ResponseEntity<List<Pedido>> inserirPedido(@RequestBody String format) {
		List<Pedido> lista= PedidosService.criarPedido(format);
		return ResponseEntity.ok().body(lista);
	}
	@PostMapping(value="/delete")
	public ResponseEntity<Boolean> deletarPedido(@RequestBody long id){
		return ResponseEntity.ok().body(PedidosService.deletarPedido(id));
	}
}
