package com.adbsilvajr.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbsilvajr.cursomc.domain.Categoria;
import com.adbsilvajr.cursomc.repositories.CategoriaRepository;
import com.adbsilvajr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);

		// return obj.orElse(null);
		return obj.orElseThrow( () /*expressao lambda*/ -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
