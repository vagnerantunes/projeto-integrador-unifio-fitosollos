package projeto.fitosollos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.fitosollos.entities.ResultadoAnalise;
import projeto.fitosollos.repositories.ResultadoAnaliseRepository;

@Service
public class ResultadoAnaliseService {

	@Autowired
	private ResultadoAnaliseRepository repository;

	@Autowired
	private NematoideService nematoideService;

	@Autowired
	private AmostraService amostraService;

	public List<ResultadoAnalise> findAll() {
		return repository.findAll();
	}

	public ResultadoAnalise findById(Long id) {
		Optional<ResultadoAnalise> obj = repository.findById(id);
		return obj.get();

	}

	public ResultadoAnalise insert(ResultadoAnalise obj) {
		obj.setId(null);
		obj.setAmostra(amostraService.findById(obj.getAmostra().getId()));
		obj.setNematoide(nematoideService.findById(obj.getNematoide().getId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public ResultadoAnalise update(Long id, ResultadoAnalise obj) {
		ResultadoAnalise entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(ResultadoAnalise entity, ResultadoAnalise obj) {
		entity.setQtdSolo(obj.getQtdSolo());
		entity.setQtdRaiz(obj.getQtdRaiz());
		entity.setQtdOvos(obj.getQtdOvos());
		entity.setAmostra(obj.getAmostra());
		entity.setNematoide(obj.getNematoide());
	}

}