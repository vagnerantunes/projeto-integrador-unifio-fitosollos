package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projeto.fitosollos.entities.Crq;
import projeto.fitosollos.repositories.CrqRepository;

@Service
public class CrqService {

	@Autowired
	private CrqRepository repository;

	public List<Crq> findAll() {
		return repository.findAll();
	}

	public Crq findById(Integer id) {
		Optional<Crq> obj = repository.findById(id);
		return obj.get();
	}
	
	@Transactional
	public Crq insert(Crq obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Crq update(Integer id, Crq obj) {
		Crq entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Crq entity, Crq obj) {
		entity.setCrqDescricao(obj.getCrqDescricao());
	}
	
}
