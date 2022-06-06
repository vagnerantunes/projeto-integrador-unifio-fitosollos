package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.dto.RecebimentoDTO;
import projeto.fitosollos.dto.RecebimentoNewDTO;
import projeto.fitosollos.entities.Amostra;
import projeto.fitosollos.entities.FormaPagamento;
import projeto.fitosollos.entities.Recebimento;
import projeto.fitosollos.repositories.RecebimentoRepository;

@Service
public class RecebimentoService {

	@Autowired
	private RecebimentoRepository repository;

	
	//listar todos
	public List<Recebimento> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Recebimento findById(Integer id) {
		Optional<Recebimento> obj = repository.findById(id);
		return obj.get();
	}
	
	public Recebimento insert (RecebimentoNewDTO recebimentoNewDTO) {
		Recebimento recebimento = fromDTO(recebimentoNewDTO);
		repository.save(recebimento);
		return recebimento;
	}
	
	public void delete(Integer id) {
		Optional<Recebimento> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	public void update (Integer id, RecebimentoDTO recebimentoDTO) {
		Recebimento recebimento = fromDTO(recebimentoDTO);
		Optional<Recebimento> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		recebimento.setId(id);
		repository.save(recebimento);
	}
	
	//utilitarios
	public Recebimento fromDTO(RecebimentoNewDTO recebimentoNewDTO) {
		Amostra amostra = new Amostra(recebimentoNewDTO.getAmostra(), null, null, null, null, null, null, null, null, 
				null, null, null, null);
		FormaPagamento formaPagamento = new FormaPagamento(recebimentoNewDTO.getFormaPagamento(), null);
		Recebimento recebimento = new Recebimento(null, recebimentoNewDTO.getValor(), recebimentoNewDTO.getHorario(), 
				formaPagamento, amostra);
		
		return recebimento;
	}
	
	public Recebimento fromDTO(RecebimentoDTO recebimentoDTO) {
		Amostra amostra = new Amostra(recebimentoDTO.getAmostra(), null, null, null, null, null, null, null, null, 
				null, null, null, null);
		FormaPagamento formaPagamento = new FormaPagamento(recebimentoDTO.getFormaPagamento(), null);
		Recebimento recebimento = new Recebimento(null, recebimentoDTO.getValor(), recebimentoDTO.getHorario(), 
				formaPagamento, amostra);
		
		return recebimento;
	}
	
}