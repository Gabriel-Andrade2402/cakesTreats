package com.application.CakesTreats.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.CakesTreats.Entitys.Sabores;
import com.application.CakesTreats.Enums.STATUS;

@Repository
public interface SaboresRepository extends JpaRepository<Sabores, Long>{
	@Query(value = "SELECT * FROM sabores WHERE nome = :nome", nativeQuery=true)
	Sabores retonarSaborPorNome(@Param("nome") String nome);
	@Query(value = "SELECT status FROM produtos WHERE nome = :nome", nativeQuery=true)
	STATUS retonarStatusDoSabor(@Param("nome") String nome);
}
