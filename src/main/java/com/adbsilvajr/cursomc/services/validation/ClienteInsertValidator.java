package com.adbsilvajr.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.adbsilvajr.cursomc.dto.ClienteNewDTO;
import com.adbsilvajr.cursomc.repositories.ClienteRepository;
import com.adbsilvajr.cursomc.resources.exceptions.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo() == null) {
			list.add(new FieldMessage("tipo", "Tipo esta vazio"));
		}

		if (!clienteRepository.findByEmail(objDto.getEmail()).equals(null)) {
			list.add(new FieldMessage("email", "Email ja cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}