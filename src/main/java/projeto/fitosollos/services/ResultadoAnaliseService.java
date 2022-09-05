package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.dto.ResultadoAnaliseDTO;
import projeto.fitosollos.dto.ResultadoAnaliseNewDTO;
import projeto.fitosollos.entities.Amostra;
import projeto.fitosollos.entities.Nematoide;
import projeto.fitosollos.entities.Venda;
import projeto.fitosollos.repositories.ResultadoAnaliseRepository;

@Service
public class ResultadoAnaliseService {

	@Autowired
	private ResultadoAnaliseRepository repository;

	//listar todos
	public List<Venda> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Venda findById(Integer id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.get();
	}
	
	public Venda insert (ResultadoAnaliseNewDTO resultadoAnaliseNewDTO) {
		Venda resultadoAnalise = fromDTO(resultadoAnaliseNewDTO);
		repository.save(resultadoAnalise);
		return resultadoAnalise;
	}
	
	
	public void delete(Integer id) {
		Optional<Venda> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	
	public void update (Integer id, ResultadoAnaliseDTO resultadoAnaliseDTO) {
		Venda resultadoAnalise = fromDTO(resultadoAnaliseDTO);
		Optional<Venda> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		resultadoAnalise.setResId(id);
		repository.save(resultadoAnalise);
	}
	
	//utilitarios
	public Venda fromDTO(ResultadoAnaliseNewDTO resultadoAnaliseNewDTO) {
		Nematoide nematoide = new Nematoide(resultadoAnaliseNewDTO.getResNematoide(), null);
		Amostra amostra = new Amostra(resultadoAnaliseNewDTO.getResAmostra(), null, null, null, null, null, null, null, null, null, null, null, null);
		Venda resultadoAnalise = new Venda(null, resultadoAnaliseNewDTO.getResQtdSolo(), 
				resultadoAnaliseNewDTO.getResQtdRaiz(), resultadoAnaliseNewDTO.getResQtdOvos(), nematoide, amostra);
		
		return resultadoAnalise;
	}
	
	public Venda fromDTO(ResultadoAnaliseDTO resultadoAnaliseDTO) {
		Nematoide nematoide = new Nematoide(resultadoAnaliseDTO.getResNematoide(), null);
		Amostra amostra = new Amostra(resultadoAnaliseDTO.getResAmostra(), null, null, null, null, null, null, null, null, null, null, null, null);
		Venda resultadoAnalise = new Venda(null, resultadoAnaliseDTO.getResQtdSolo(), 
				resultadoAnaliseDTO.getResQtdRaiz(), resultadoAnaliseDTO.getResQtdOvos(), nematoide, amostra);
		
		return resultadoAnalise;
	}
}
