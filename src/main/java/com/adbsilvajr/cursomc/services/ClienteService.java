package com.adbsilvajr.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbsilvajr.cursomc.domain.Cliente;
import com.adbsilvajr.cursomc.repositories.ClienteRepository;
import com.adbsilvajr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);

		// return obj.orElse(null);
		return obj.orElseThrow( () /*expressao lambda*/ -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
