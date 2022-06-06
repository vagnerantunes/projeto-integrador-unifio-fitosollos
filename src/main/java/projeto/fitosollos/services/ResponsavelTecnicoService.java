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
		
		responsavelTecnico.setId(id);
		repository.save(responsavelTecnico);
	}
	
	//utilitarios
	public ResponsavelTecnico fromDTO(ResponsavelTecnicoNewDTO responsavelTecnicoNewDTO) {
		Crq crq = new Crq(responsavelTecnicoNewDTO.getCrq(), null);
		Laboratorio laboratorio = new Laboratorio(responsavelTecnicoNewDTO.getLaboratorio(), null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(null, responsavelTecnicoNewDTO.getNome(), 
				responsavelTecnicoNewDTO.getDdd(), responsavelTecnicoNewDTO.getTelefone(), 
				responsavelTecnicoNewDTO.getCidade(), responsavelTecnicoNewDTO.getUf(), 
				responsavelTecnicoNewDTO.getEndereco(), responsavelTecnicoNewDTO.getBairro(), 
				responsavelTecnicoNewDTO.getCep(), crq, laboratorio);
		return responsavelTecnico;
	}
	
	public ResponsavelTecnico fromDTO(ResponsavelTecnicoDTO responsavelTecnicoDTO) {
		Crq crq = new Crq(responsavelTecnicoDTO.getCrq(), null);
		Laboratorio laboratorio = new Laboratorio(responsavelTecnicoDTO.getLaboratorio(), null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(null, responsavelTecnicoDTO.getNome(), 
				responsavelTecnicoDTO.getDdd(), responsavelTecnicoDTO.getTelefone(), 
				responsavelTecnicoDTO.getCidade(), responsavelTecnicoDTO.getUf(), 
				responsavelTecnicoDTO.getEndereco(), responsavelTecnicoDTO.getBairro(), 
				responsavelTecnicoDTO.getCep(), crq, laboratorio);
		return responsavelTecnico;
	}

}