package com.adbsilvajr.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.adbsilvajr.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
