package com.adbsilvajr.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adbsilvajr.cursomc.domain.Pedido;

@Repository	
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
