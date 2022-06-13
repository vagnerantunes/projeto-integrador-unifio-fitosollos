package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.dto.ResponsavelTecnicoDTO;
import projeto.fitosollos.dto.ResponsavelTecnicoNewDTO;
import projeto.fitosollos.entities.Crq;
import projeto.fitosollos.entities.Laboratorio;
import projeto.fitosollos.entities.ResponsavelTecnico;
import projeto.fitosollos.repositories.ResponsavelTecnicoRepository;

@Service
public class ResponsavelTecnicoService {

	@Autowired
	private ResponsavelTecnicoRepository repository;

	//listar todos
	public List<ResponsavelTecnico> findAll() {
		return repository.findAll();
	}

	//listar por id
	public ResponsavelTecnico findById(Integer id) {
		Optional<ResponsavelTecnico> obj = repository.findById(id);
		return obj.get();
	}
	
	public ResponsavelTecnico insert (ResponsavelTecnicoNewDTO responsavelTecnicoNewDTO) {
		ResponsavelTecnico responsavelTecnico = fromDTO(responsavelTecnicoNewDTO);
		repository.save(responsavelTecnico);
		return responsavelTecnico;
	}
	
	public void delete(Integer id) {
		Optional<ResponsavelTecnico> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Responsável tecnico não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	public void update (Integer id, ResponsavelTecnicoDTO responsavelTecnicoDTO) {
		ResponsavelTecnico responsavelTecnico = fromDTO(responsavelTecnicoDTO);
		Optional<ResponsavelTecnico> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		responsavelTecnico.setTecId(id);
		repository.save(responsavelTecnico);
	}
	
	//utilitarios
	public ResponsavelTecnico fromDTO(ResponsavelTecnicoNewDTO responsavelTecnicoNewDTO) {
		Crq crq = new Crq(responsavelTecnicoNewDTO.getTecCrq(), null);
		Laboratorio laboratorio = new Laboratorio(responsavelTecnicoNewDTO.getTecLaboratorio(), null, null, null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(null, responsavelTecnicoNewDTO.getTecNome(), 
				responsavelTecnicoNewDTO.getTecDdd(), responsavelTecnicoNewDTO.getTecTelefone(), 
				responsavelTecnicoNewDTO.getTecCidade(), responsavelTecnicoNewDTO.getTecUf(), 
				responsavelTecnicoNewDTO.getTecEndereco(), responsavelTecnicoNewDTO.getTecBairro(), 
				responsavelTecnicoNewDTO.getTecCep(), crq, laboratorio);
		return responsavelTecnico;
	}
	
	public ResponsavelTecnico fromDTO(ResponsavelTecnicoDTO responsavelTecnicoDTO) {
		Crq crq = new Crq(responsavelTecnicoDTO.getTecCrq(), null);
		Laboratorio laboratorio = new Laboratorio(responsavelTecnicoDTO.getTecLaboratorio(), null, null, null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(null, responsavelTecnicoDTO.getTecNome(), 
				responsavelTecnicoDTO.getTecDdd(), responsavelTecnicoDTO.getTecTelefone(), 
				responsavelTecnicoDTO.getTecCidade(), responsavelTecnicoDTO.getTecUf(), 
				responsavelTecnicoDTO.getTecEndereco(), responsavelTecnicoDTO.getTecBairro(), 
				responsavelTecnicoDTO.getTecCep(), crq, laboratorio);
		return responsavelTecnico;
	}

}