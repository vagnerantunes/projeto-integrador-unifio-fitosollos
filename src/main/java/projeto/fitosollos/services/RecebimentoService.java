package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.Recebimento;
import projeto.fitosollos.repositories.RecebimentoRepository;

@Service
public class RecebimentoService {

	@Autowired
	private RecebimentoRepository repository;

	@Autowired
	private AmostraService amostraService;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;


	public List<Recebimento> findAll() {
		return repository.findAll();
	}

	public Recebimento findById(Long id) {
		Optional<Recebimento> obj = repository.findById(id);
		return obj.get();
	}

	public Recebimento insert(Recebimento obj) {
		obj.setId(null);
		obj.setAmostra(amostraService.findById(obj.getAmostra().getId()));
		obj.setFormaPagamento(formaPagamentoService.findById(obj.getFormaPagamento().getId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Recebimento update(Long id, Recebimento obj) {
		Recebimento entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Recebimento entity, Recebimento obj) {
		entity.setFormaPagamento(obj.getFormaPagamento());
		entity.setAmostra(obj.getAmostra());
		entity.setValor(obj.getValor());
		entity.setHorario(obj.getHorario());
		
	}

}