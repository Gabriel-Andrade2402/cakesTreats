package com.application.CakesTreats.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.CakesTreats.Entitys.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	@Query(value = "SELECT * FROM usuarios WHERE senha = :senha AND email = :email ", nativeQuery=true)
	Usuarios procurarPorLogin(@Param("senha") String senha, @Param("email") String email);
	@Query(value = "SELECT * FROM usuarios WHERE email = :email ", nativeQuery=true)
	Usuarios procurarPorEmail(@Param("email") String email);
}
