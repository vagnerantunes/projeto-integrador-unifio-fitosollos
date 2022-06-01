package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.Cultura;
import projeto.fitosollos.repositories.CulturaRepository;

@Service
public class CulturaService {
	
	@Autowired
	private CulturaRepository repository;
	
	public List<Cultura> findAll(){
		return repository.findAll();
		
	}
	
	public Cultura findById(Long id) {
		Optional<Cultura> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Cultura insert(Cultura obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Cultura update(Long id, Cultura obj) {
		Cultura entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Cultura entity, Cultura obj) {
		entity.setDescricao(obj.getDescricao());
		
	}	
	
}