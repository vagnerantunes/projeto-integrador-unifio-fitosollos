package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.Amostra;
import projeto.fitosollos.repositories.AmostraRepository;

@Service
public class AmostraService {

	@Autowired
	private AmostraRepository repository;
 
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TipoAnaliseService tipoAnaliseService;
	
	@Autowired
	private CulturaService culturaService;
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@Autowired
	private ResponsavelTecnicoService responsavelTecnicoService;

	@Autowired
	private LaboratorioService laboratorioService;
	
	public List<Amostra> findAll() {
		return repository.findAll();
	}

	public Amostra findById(Long id) {
		Optional<Amostra> obj = repository.findById(id);
		return obj.get();

	}

	public Amostra insert(Amostra obj) {
		obj.setId(null);
		obj.setUsuario(usuarioService.findById(obj.getUsuario().getId()));
		obj.setAnalise(tipoAnaliseService.findById(obj.getAnalise().getId()));
		obj.setCultura(culturaService.findById(obj.getCultura().getId()));
		obj.setProprietario(proprietarioService.findById(obj.getProprietario().getId()));
		obj.setTecnico(responsavelTecnicoService.findById(obj.getTecnico().getId()));
		obj.setLaboratorio(laboratorioService.findById(obj.getLaboratorio().getId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Amostra update(Long id, Amostra obj) {
		Amostra entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Amostra entity, Amostra obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setChegada(obj.getChegada());
		entity.setSaida(obj.getSaida());
		entity.setPeso(obj.getPeso());
		entity.setFinalizada(obj.getFinalizada());
		entity.setCancelada(obj.getCancelada());
		entity.setUsuario(obj.getUsuario());	
		entity.setAnalise(obj.getAnalise());
		entity.setCultura(obj.getCultura());
		entity.setProprietario(obj.getProprietario());
		entity.setTecnico(obj.getTecnico());
		entity.setLaboratorio(obj.getLaboratorio());
	}

}