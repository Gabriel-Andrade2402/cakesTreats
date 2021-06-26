package com.application.CakesTreats.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Services.SaboresService;

@RestController
@RequestMapping(value="/sabores")
public class SaboresResources {
	@GetMapping(value="/teste")
	public ResponseEntity<Sabores> teste(@RequestBody Sabores sabor){
		return ResponseEntity.ok().body(SaboresService.retornaSaborPorNome(sabor.getNome()));
	}
	@PostMapping(value="novo")
	public ResponseEntity<Void> criarSabor(@RequestBody Sabores sabor){
		SaboresService.criarSabor(sabor);
		return ResponseEntity.ok().body(null);
	}
}
