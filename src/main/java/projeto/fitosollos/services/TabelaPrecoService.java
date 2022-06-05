package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.dto.TabelaPrecoDTO;
import projeto.fitosollos.dto.TabelaPrecoNewDTO;
import projeto.fitosollos.entities.Laboratorio;
import projeto.fitosollos.entities.TabelaPreco;
import projeto.fitosollos.entities.TipoAnalise;
import projeto.fitosollos.repositories.TabelaPrecoRepository;

@Service
public class TabelaPrecoService {
	
	@Autowired
	private TabelaPrecoRepository repository;

	//listar todos
	public List<TabelaPreco> findAll() {
		return repository.findAll();
	}

	//listar por id
	public TabelaPreco findById(Integer id) {
		Optional<TabelaPreco> obj = repository.findById(id);
		return obj.get();
	}
	
	public TabelaPreco insert (TabelaPrecoNewDTO tabelaPrecoNewDTO) {
		TabelaPreco tabelaPreco = fromDTO(tabelaPrecoNewDTO);
		repository.save(tabelaPreco);
		return tabelaPreco;
	}
	
	public void delete(Integer id) {
		Optional<TabelaPreco> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	public void update (Integer id, TabelaPrecoDTO tabelaPrecoDTO) {
		TabelaPreco tabelaPreco = fromDTO(tabelaPrecoDTO);
		Optional<TabelaPreco> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		tabelaPreco.setId(id);
		repository.save(tabelaPreco);
	}
	
	//utilitarios
		public TabelaPreco fromDTO(TabelaPrecoNewDTO tabelaPrecoNewDTO) {
			TipoAnalise tipoAnalise = new TipoAnalise(tabelaPrecoNewDTO.getAnalise(), null);
			Laboratorio laboratorio = new Laboratorio(tabelaPrecoNewDTO.getLaboratorio(), null, null, null);
			TabelaPreco tabelaPreco = new TabelaPreco(null, tabelaPrecoNewDTO.getValor(), tipoAnalise, laboratorio);
			return tabelaPreco;
		}
		
		public TabelaPreco fromDTO(TabelaPrecoDTO tabelaPrecoDTO) {
			TipoAnalise tipoAnalise = new TipoAnalise(tabelaPrecoDTO.getAnalise(), null);
			Laboratorio laboratorio = new Laboratorio(tabelaPrecoDTO.getLaboratorio(), null, null, null);
			TabelaPreco tabelaPreco = new TabelaPreco(null, tabelaPrecoDTO.getValor(), tipoAnalise, laboratorio);
			return tabelaPreco;
		}

}
