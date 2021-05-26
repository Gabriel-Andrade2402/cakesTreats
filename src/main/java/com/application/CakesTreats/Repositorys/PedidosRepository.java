package com.application.CakesTreats.Repositorys;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.CakesTreats.Entitys.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long>{
	@Query(value = "SELECT * FROM pedidos WHERE data_pedida = :data AND usuario_id = :usuario", nativeQuery=true)
	List<Pedido> retornaListaPorData(@Param("data") String data,@Param("usuario")long id);
	
}
