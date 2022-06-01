package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.Proprietario;
import projeto.fitosollos.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {
	
	@Autowired
	private ProprietarioRepository repository;
	
	public List<Proprietario> findAll(){
		return repository.findAll();
		
	}
	
	public Proprietario findById(Long id) {
		Optional<Proprietario> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Proprietario insert(Proprietario obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Proprietario update(Long id, Proprietario obj) {
		Proprietario entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Proprietario entity, Proprietario obj) {
		entity.setNome(obj.getNome());
		entity.setCpfcnpj(obj.getCpfcnpj());
		entity.setDdd(obj.getDdd());
		entity.setTelefone(obj.getTelefone());
		entity.setCidade(obj.getCidade());
		entity.setUf(obj.getUf());
		entity.setEndereco(obj.getEndereco());
		entity.setBairro(obj.getBairro());
		entity.setCep(obj.getCep());
		
	}	
	
}