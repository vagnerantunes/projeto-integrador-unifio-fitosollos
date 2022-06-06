package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.dto.AmostraDTO;
import projeto.fitosollos.dto.AmostraNewDTO;
import projeto.fitosollos.entities.Amostra;
import projeto.fitosollos.entities.Cultura;
import projeto.fitosollos.entities.Laboratorio;
import projeto.fitosollos.entities.Proprietario;
import projeto.fitosollos.entities.ResponsavelTecnico;
import projeto.fitosollos.entities.TipoAnalise;
import projeto.fitosollos.entities.Usuario;
import projeto.fitosollos.repositories.AmostraRepository;

@Service
public class AmostraService {

	@Autowired
	private AmostraRepository repository;

	//listar todos
	public List<Amostra> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Amostra findById(Integer id) {
		Optional<Amostra> obj = repository.findById(id);
		return obj.get();
	}
	
	public Amostra insert (AmostraNewDTO amostraNewDTO) {
		Amostra amostra = fromDTO(amostraNewDTO);
		repository.save(amostra);
		return amostra;
	}
	
	public void delete(Integer id) {
		Optional<Amostra> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Amostra não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	public void update (Integer id, AmostraDTO amostraDTO) {
		Amostra amostra = fromDTO(amostraDTO);
		Optional<Amostra> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		amostra.setId(id);
		repository.save(amostra);
	}
	
	//utilitarios
	public Amostra fromDTO(AmostraNewDTO amostraNewDTO) {
		Usuario usuario = new Usuario(amostraNewDTO.getUsuario(), null, null);
		TipoAnalise tipoAnalise = new TipoAnalise(amostraNewDTO.getAnalise(), null);
		Cultura cultura = new Cultura(amostraNewDTO.getCultura(), null);
		Proprietario proprietario = new Proprietario(amostraNewDTO.getProprietario(), null, null, null, null, null, 
				null, null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(amostraNewDTO.getTecnico(), null, null, null, 
				null, null, null, null, null, null, null);
		Laboratorio laboratorio = new Laboratorio(amostraNewDTO.getLaboratorio(), null, null, null);
		Amostra amostra = new Amostra(null, amostraNewDTO.getDescricao(), amostraNewDTO.getChegada(), 
				amostraNewDTO.getSaida(), amostraNewDTO.getPeso(), amostraNewDTO.getFinalizada(), 
				amostraNewDTO.getCancelada(), usuario, tipoAnalise, cultura, proprietario, responsavelTecnico, 
				laboratorio);
		return amostra;
	}
	
	public Amostra fromDTO(AmostraDTO amostraDTO) {
		Usuario usuario = new Usuario(amostraDTO.getUsuario(), null, null);
		TipoAnalise tipoAnalise = new TipoAnalise(amostraDTO.getAnalise(), null);
		Cultura cultura = new Cultura(amostraDTO.getCultura(), null);
		Proprietario proprietario = new Proprietario(amostraDTO.getProprietario(), null, null, null, null, null, 
				null, null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(amostraDTO.getTecnico(), null, null, null, 
				null, null, null, null, null, null, null);
		Laboratorio laboratorio = new Laboratorio(amostraDTO.getLaboratorio(), null, null, null);
		Amostra amostra = new Amostra(null, amostraDTO.getDescricao(), amostraDTO.getChegada(), 
				amostraDTO.getSaida(), amostraDTO.getPeso(), amostraDTO.getFinalizada(), 
				amostraDTO.getCancelada(), usuario, tipoAnalise, cultura, proprietario, responsavelTecnico, laboratorio);
	
		return amostra;
	}
	
}
