package com.application.CakesTreats.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.CakesTreats.Entitys.Produto;
import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Enums.STATUS;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	@Query(value = "SELECT status FROM produtos WHERE nome = :nome AND sabor_id = :sabor", nativeQuery=true)
	STATUS retonarStatusDoProduto(@Param("nome") String nome, @Param("sabor") Sabores sabor);
	@Query(value = "SELECT * FROM produtos WHERE nome = :nome AND sabor_id = :sabor", nativeQuery=true)
	Produto retonarProdutoPorNomeESabor(@Param("nome") String nome, @Param("sabor") Sabores sabor);
	@Query(value = "SELECT * FROM produtos WHERE nome = :nome", nativeQuery=true)
	Produto retonarProdutoPorNome(@Param("nome") String nome);

}
