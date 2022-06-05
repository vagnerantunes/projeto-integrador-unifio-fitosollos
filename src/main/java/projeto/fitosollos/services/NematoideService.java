package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projeto.fitosollos.entities.Nematoide;
import projeto.fitosollos.repositories.NematoideRepository;

@Service
public class NematoideService {

	@Autowired
	private NematoideRepository repository;

	public List<Nematoide> findAll() {
		return repository.findAll();
	}

	public Nematoide findById(Integer id) {
		Optional<Nematoide> obj = repository.findById(id);
		return obj.get();

	}
	
	@Transactional
	public Nematoide insert(Nematoide obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Nematoide update(Integer id, Nematoide obj) {
		Nematoide entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Nematoide entity, Nematoide obj) {
		entity.setDescricao(obj.getDescricao());
	}
	
}