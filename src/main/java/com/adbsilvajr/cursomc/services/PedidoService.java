package com.adbsilvajr.cursomc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adbsilvajr.cursomc.domain.ItemPedido;
import com.adbsilvajr.cursomc.domain.PagamentoComBoleto;
import com.adbsilvajr.cursomc.domain.Pedido;
import com.adbsilvajr.cursomc.domain.enums.EstadoPagamento;
import com.adbsilvajr.cursomc.repositories.ItemPedidoRepository;
import com.adbsilvajr.cursomc.repositories.PagamentoRepository;
import com.adbsilvajr.cursomc.repositories.PedidoRepository;
import com.adbsilvajr.cursomc.repositories.ProdutoRepository;
import com.adbsilvajr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);

		// return obj.orElse(null);
		return obj.orElseThrow(() /* expressao lambda */ -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	/*
	 * { "cliente" : {"id" : 1}, "enderecoDeEntrega" : {"id" : 1}, "pagamento" : {
	 * "numeroDeParcelas" : 10, "@type": "pagamentoComCartao" }, "itens" : [ {
	 * "quantidade" : 2, "produto" : {"id" : 3} }, { "quantidade" : 1, "produto" :
	 * {"id" : 1} } ] }
	 */
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);

		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}

		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());

		for (ItemPedido ip : obj.getItens()) {
			ip.setDescondo(0.0);
			ip.setPreco(produtoRepository.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedido(obj);
			// itemPedidoRepository.save(ip);
		}

		itemPedidoRepository.saveAll(obj.getItens());

		return obj;
	}

}
