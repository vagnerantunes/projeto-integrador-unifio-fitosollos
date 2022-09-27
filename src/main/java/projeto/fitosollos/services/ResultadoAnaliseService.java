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
import projeto.fitosollos.entities.ResultadoAnalise;
import projeto.fitosollos.repositories.ResultadoAnaliseRepository;

@Service
public class ResultadoAnaliseService {

	@Autowired
	private ResultadoAnaliseRepository repository;

	//listar todos
	public List<ResultadoAnalise> findAll() {
		return repository.findAll();
	}

	//listar por id
	public ResultadoAnalise findById(Integer id) {
		Optional<ResultadoAnalise> obj = repository.findById(id);
		return obj.get();
	}
	
	public ResultadoAnalise insert (ResultadoAnaliseNewDTO resultadoAnaliseNewDTO) {
		ResultadoAnalise resultadoAnalise = fromDTO(resultadoAnaliseNewDTO);
		repository.save(resultadoAnalise);
		return resultadoAnalise;
	}
	
	
	public void delete(Integer id) {
		Optional<ResultadoAnalise> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	
	public void update (Integer id, ResultadoAnaliseDTO resultadoAnaliseDTO) {
		ResultadoAnalise resultadoAnalise = fromDTO(resultadoAnaliseDTO);
		Optional<ResultadoAnalise> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		resultadoAnalise.setResId(id);
		repository.save(resultadoAnalise);
	}
	
	//utilitarios
	public ResultadoAnalise fromDTO(ResultadoAnaliseNewDTO resultadoAnaliseNewDTO) {
		Nematoide nematoide = new Nematoide(resultadoAnaliseNewDTO.getResNematoide(), null);
		Amostra amostra = new Amostra(resultadoAnaliseNewDTO.getResAmostra(), null, null, null, null, null, null, null, null, null, null, null, null);
		ResultadoAnalise resultadoAnalise = new ResultadoAnalise(null, resultadoAnaliseNewDTO.getResQtdSolo(), 
				resultadoAnaliseNewDTO.getResQtdRaiz(), resultadoAnaliseNewDTO.getResQtdOvos(), nematoide, amostra);
		
		return resultadoAnalise;
	}
	
	public ResultadoAnalise fromDTO(ResultadoAnaliseDTO resultadoAnaliseDTO) {
		Nematoide nematoide = new Nematoide(resultadoAnaliseDTO.getResNematoide(), null);
		Amostra amostra = new Amostra(resultadoAnaliseDTO.getResAmostra(), null, null, null, null, null, null, null, null, null, null, null, null);
		ResultadoAnalise resultadoAnalise = new ResultadoAnalise(null, resultadoAnaliseDTO.getResQtdSolo(), 
				resultadoAnaliseDTO.getResQtdRaiz(), resultadoAnaliseDTO.getResQtdOvos(), nematoide, amostra);
		
		return resultadoAnalise;
	}
}
