package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.TipoAnalise;
import projeto.fitosollos.repositories.TipoAnaliseRepository;

@Service
public class TipoAnaliseService {
	
	@Autowired
	private TipoAnaliseRepository repository;
	
	public List<TipoAnalise> findAll(){
		return repository.findAll();
		
	}
	
	public TipoAnalise findById(Integer id) {
		Optional<TipoAnalise> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public TipoAnalise insert(TipoAnalise obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public TipoAnalise update(Integer id, TipoAnalise obj) {
		TipoAnalise entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(TipoAnalise entity, TipoAnalise obj) {
		entity.setDescricao(obj.getDescricao());
	}	
	
}