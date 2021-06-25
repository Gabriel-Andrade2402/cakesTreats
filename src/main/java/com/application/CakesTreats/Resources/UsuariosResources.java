package com.application.CakesTreats.Resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.CakesTreats.Entitys.Usuarios;
import com.application.CakesTreats.Services.UsuariosService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosResources {

	@PostMapping(value = "/logar")
	public ResponseEntity<Usuarios> login(@RequestBody Usuarios usuario) {
		Usuarios usu = UsuariosService.Login(usuario.getEmail(), usuario.getSenha());
		if (usu != null) {
			return ResponseEntity.ok().body(usu);
		}else {
			return ResponseEntity.ok().body(null);
		}
	}
	@PostMapping(value="/cadastrar")
	public ResponseEntity<Usuarios> cadastrar(@RequestBody Usuarios usuario) {
		Usuarios usu = UsuariosService.cadastrar(usuario.getEmail(),usuario.getSenha(), usuario.getNome(), usuario.getTelefone());
		if (usu != null) {
			return ResponseEntity.ok().body(usu);
		}else {
			return ResponseEntity.ok().body(null);
		}
	}
	@PostMapping(value="/editar")
	public ResponseEntity<Usuarios> editar(@RequestBody Usuarios usuario) {
		Usuarios usu = UsuariosService.atualizar(usuario.getEmail(),usuario.getSenha(), usuario.getNome(), usuario.getTelefone());
		if (usu != null) {
			return ResponseEntity.ok().body(usu);
		}else {
			return ResponseEntity.ok().body(null);
		}
	}
	@GetMapping(value="/todos")
	public ResponseEntity<List<Usuarios>> retornaTodosUsuarios(){
		return ResponseEntity.ok().body(UsuariosService.retornaTodosUsuarios());
	}
}
