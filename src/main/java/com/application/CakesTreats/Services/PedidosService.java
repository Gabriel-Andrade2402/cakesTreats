package com.application.CakesTreats.Services;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.stereotype.Service;

import com.application.CakesTreats.Entitys.Pedido;
import com.application.CakesTreats.Entitys.Produto;
import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Entitys.Usuarios;
import com.application.CakesTreats.Enums.STATUS;
import com.application.CakesTreats.Repositorys.PedidosRepository;

@Service
public class PedidosService {
	private static PedidosRepository repository;

	public static void setRepository(PedidosRepository repository) {
		PedidosService.repository = repository;
	}

	public static Pedido procurarPorId(long id) {
		return repository.findById(id).get();
	}
	public static List<Pedido> recuperarPedidosUser(Usuarios user){
		Usuarios usuario=UsuariosService.buscarUsuario(user.getEmail());
		return repository.retornarListaPorUsuario(usuario.getId());
	}
	public static List<Pedido> criarPedido(String format) {
		try {
			java.util.Date dataNew = new java.util.Date();
			String data = formatarData(dataNew);
			List<Produto> lista = retornaListaDeProdutosNoFormat(format);
			Usuarios usuario = retornaUsuarioNoFormat(format);
			for (Produto p : lista) {
				Pedido pedido = new Pedido(null, STATUS.PRODUZINDO, usuario, data, null, p);
				repository.save(pedido);
			}
			return recuperarPedidosPorData(data, usuario.getId());
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Pedido> recuperarPedidosPorData(String data,long id){
		return repository.retornaListaPorData(data,id);
	}

	public static boolean deletarPedido(long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// Recuperar o formato enviado para reconhecer um usuario
	public static Usuarios retornaUsuarioNoFormat(String format) {
		String[] separarPorTipo = format.split("}");
		String[] separarPorChaveValor = separarPorTipo[0].split(":");
		return UsuariosService.buscarUsuario(separarPorChaveValor[1]);
	}

	// Recuperar o formato enviado para reconhecer os produtos
	public static List<Produto> retornaListaDeProdutosNoFormat(String format) {
		String[] separarPorTipo = format.split("}");
		String[] produtos = separarPorTipo[1].split(",");
		List<Produto> lista = new ArrayList();
		for (String s : produtos) {
			String[] separarPorChaveValor = s.split(":");
			Sabores sabor = SaboresService.retornaSaborPorNome(separarPorChaveValor[1]);
			Produto produ = ProdutoService.retornarProdutoPorNomeESabor(separarPorChaveValor[0], sabor);
			lista.add(produ);
		}
		return lista;
	}
	//Formata uma data
	private static String formatarData(java.util.Date dataNew) {
		String data = String.valueOf(dataNew.getDay()+16) + "/" + String.valueOf(dataNew.getMonth()+1) + "/"
				+ String.valueOf(dataNew.getYear()+1900) + "," + String.valueOf(dataNew.getHours()) + ":"
				+ String.valueOf(dataNew.getMinutes()) + ":"
				+String.valueOf(dataNew.getSeconds());
		return data;
	}


}
