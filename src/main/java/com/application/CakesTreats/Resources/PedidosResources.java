package com.application.CakesTreats.Resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.CakesTreats.Entitys.Pedido;
import com.application.CakesTreats.Entitys.Usuarios;
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
	@PostMapping(value="/usuario")
	public ResponseEntity<List<Pedido>> recuperarPedidosUser(@RequestBody Usuarios user){
		return ResponseEntity.ok().body(PedidosService.recuperarPedidosUser(user));
	}
}
