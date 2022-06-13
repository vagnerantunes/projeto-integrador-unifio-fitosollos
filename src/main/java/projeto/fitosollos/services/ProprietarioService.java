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
	
	public Proprietario findById(Integer id) {
		Optional<Proprietario> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Proprietario insert(Proprietario obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Proprietario update(Integer id, Proprietario obj) {
		Proprietario entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Proprietario entity, Proprietario obj) {
		entity.setProNome(obj.getProNome());
		entity.setProCpfCnpj(obj.getProCpfCnpj());
		entity.setProDdd(obj.getProDdd());
		entity.setProTelefone(obj.getProTelefone());
		entity.setProCidade(obj.getProCidade());
		entity.setProUf(obj.getProUf());
		entity.setProEndereco(obj.getProEndereco());
		entity.setProBairro(obj.getProBairro());
		entity.setProCep(obj.getProCep());
		
	}	
	
}