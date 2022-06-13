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
		
		amostra.setAmoId(id);
		repository.save(amostra);
	}
	
	//utilitarios
	public Amostra fromDTO(AmostraNewDTO amostraNewDTO) {
		Usuario usuario = new Usuario(amostraNewDTO.getAmoUsuario(), null, null);
		TipoAnalise tipoAnalise = new TipoAnalise(amostraNewDTO.getAmoAnalise(), null);
		Cultura cultura = new Cultura(amostraNewDTO.getAmoCultura(), null);
		Proprietario proprietario = new Proprietario(amostraNewDTO.getAmoProprietario(), null, null, null, null, null, 
				null, null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(amostraNewDTO.getAmoTecnico(), null, null, null, 
				null, null, null, null, null, null, null);
		Laboratorio laboratorio = new Laboratorio(amostraNewDTO.getAmoLaboratorio(), null, null, null, null, null);
		Amostra amostra = new Amostra(null, amostraNewDTO.getAmoDescricao(), amostraNewDTO.getAmoChegada(), 
				amostraNewDTO.getAmoSaida(), amostraNewDTO.getAmoPeso(), amostraNewDTO.getAmoFinalizada(), 
				amostraNewDTO.getAmoCancelada(), usuario, tipoAnalise, cultura, proprietario, responsavelTecnico, 
				laboratorio);
		return amostra;
	}
	
	public Amostra fromDTO(AmostraDTO amostraDTO) {
		Usuario usuario = new Usuario(amostraDTO.getAmoUsuario(), null, null);
		TipoAnalise tipoAnalise = new TipoAnalise(amostraDTO.getAmoAnalise(), null);
		Cultura cultura = new Cultura(amostraDTO.getAmoCultura(), null);
		Proprietario proprietario = new Proprietario(amostraDTO.getAmoProprietario(), null, null, null, null, null, 
				null, null, null, null);
		ResponsavelTecnico responsavelTecnico = new ResponsavelTecnico(amostraDTO.getAmoTecnico(), null, null, null, 
				null, null, null, null, null, null, null);
		Laboratorio laboratorio = new Laboratorio(amostraDTO.getAmoLaboratorio(), null, null, null, null, null);
		Amostra amostra = new Amostra(null, amostraDTO.getAmoDescricao(), amostraDTO.getAmoChegada(), 
				amostraDTO.getAmoSaida(), amostraDTO.getAmoPeso(), amostraDTO.getAmoFinalizada(), 
				amostraDTO.getAmoCancelada(), usuario, tipoAnalise, cultura, proprietario, responsavelTecnico, laboratorio);
	
		return amostra;
	}
	
}
