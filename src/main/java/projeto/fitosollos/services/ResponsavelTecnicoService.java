package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.ResponsavelTecnico;
import projeto.fitosollos.repositories.ResponsavelTecnicoRepository;

@Service
public class ResponsavelTecnicoService {

	@Autowired
	private ResponsavelTecnicoRepository repository;

	@Autowired
	private LaboratorioService laboratorioService;

	@Autowired
	private CrqService crqService;

	public List<ResponsavelTecnico> findAll() {
		return repository.findAll();
	}

	public ResponsavelTecnico findById(Long id) {
		Optional<ResponsavelTecnico> obj = repository.findById(id);
		return obj.get();

	}

	public ResponsavelTecnico insert(ResponsavelTecnico obj) {
		obj.setId(null);
		obj.setLaboratorio(laboratorioService.findById(obj.getLaboratorio().getId()));
		obj.setCrq(crqService.findById(obj.getCrq().getId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public ResponsavelTecnico update(Long id, ResponsavelTecnico obj) {
		ResponsavelTecnico entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(ResponsavelTecnico entity, ResponsavelTecnico obj) {
		entity.setNome(obj.getNome());
		entity.setDdd(obj.getDdd());
		entity.setTelefone(obj.getTelefone());
		entity.setCidade(obj.getCidade());
		entity.setUf(obj.getUf());
		entity.setEndereco(obj.getEndereco());
		entity.setBairro(obj.getBairro());
		entity.setBairro(obj.getBairro());
		entity.setCep(obj.getCep());
		entity.setLaboratorio(obj.getLaboratorio());
		entity.setCrq(obj.getCrq());
	}

}