package com.application.CakesTreats.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.CakesTreats.Entitys.Usuarios;
import com.application.CakesTreats.Repositorys.UsuariosRepository;

@Service
public class UsuariosService {
	private static UsuariosRepository repository;
	public static void setRepository(UsuariosRepository repository) {
		UsuariosService.repository = repository;
	}
	public static List<Usuarios> retornaTodosUsuarios(){
		return repository.findAll();
	}
	public static Usuarios buscarUsuario(String email) {
		return repository.procurarPorEmail(email);
	}
	public static Usuarios Login(String email,String senha) {
		Usuarios usu= repository.procurarPorLogin(senha, email);
		if(usu==null) {
			return null;
		}
		return usu;
	}
	
	public static Usuarios cadastrar(String email,String senha,String nome,String telefone) {
		if(repository.procurarPorEmail(email)!=null)return null;
		Usuarios usuario= new Usuarios(null, nome, email, telefone, senha);
		repository.save(usuario);
		return usuario;
	} 
	public static Usuarios atualizar(String email,String senha,String nome,String telefone) {
		Usuarios usu= repository.procurarPorLogin(senha, email);
		usu.setNome(nome);
		usu.setEmail(email);
		usu.setSenha(senha);
		usu.setTelefone(telefone);
		repository.save(usu);
		return usu;
	} 
}
