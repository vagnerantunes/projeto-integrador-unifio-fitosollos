package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.Laboratorio;
import projeto.fitosollos.repositories.LaboratorioRepository;

@Service
public class LaboratorioService {
	
	@Autowired
	private LaboratorioRepository repository;
	
	public List<Laboratorio> findAll(){
		return repository.findAll();
		
	}
	
	public Laboratorio findById(Integer id) {
		Optional<Laboratorio> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Laboratorio insert(Laboratorio obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Laboratorio update(Integer id, Laboratorio obj) {
		Laboratorio entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Laboratorio entity, Laboratorio obj) {
		entity.setLabRazaoSocial(obj.getLabRazaoSocial());
		entity.setLabNomeFantasia(obj.getLabNomeFantasia());
		entity.setLabCnpj(obj.getLabCnpj());
		entity.setLabEndereco(obj.getLabEndereco());
		entity.setLabTelefone(obj.getLabTelefone());
	}	
	
}