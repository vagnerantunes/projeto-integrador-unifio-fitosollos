package projeto.fitosollos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.fitosollos.entities.Laboratorio;
import projeto.fitosollos.services.LaboratorioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/laboratorios")
public class LaboratorioResource {

	@Autowired
	private LaboratorioService service;
	
	@GetMapping
	public ResponseEntity<List<Laboratorio>> findAll(){
		List<Laboratorio> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Laboratorio> findById(@PathVariable Integer id){
		Laboratorio obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Laboratorio> insert(@RequestBody Laboratorio obj){
		obj = service.insert(obj);
		return ResponseEntity.noContent().build();		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Laboratorio> update(@PathVariable Integer id, 
			@RequestBody Laboratorio obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}