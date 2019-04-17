package com.adbsilvajr.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbsilvajr.cursomc.domain.Pedido;
import com.adbsilvajr.cursomc.repositories.PedidoRepository;
import com.adbsilvajr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);

		// return obj.orElse(null);
		return obj.orElseThrow( () /*expressao lambda*/ -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
