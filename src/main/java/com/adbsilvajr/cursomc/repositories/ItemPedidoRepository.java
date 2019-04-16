package com.adbsilvajr.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adbsilvajr.cursomc.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository< ItemPedido, Integer> {

}
