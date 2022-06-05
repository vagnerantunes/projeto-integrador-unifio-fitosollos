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

import projeto.fitosollos.entities.ResponsavelTecnico;
import projeto.fitosollos.services.ResponsavelTecnicoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/tecnicos")
public class ResponsavelTecnicoResource {

	@Autowired
	private ResponsavelTecnicoService service;

	@GetMapping
	public ResponseEntity<List<ResponsavelTecnico>> findAll() {
		List<ResponsavelTecnico> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponsavelTecnico> findById(@PathVariable Integer id) {
		ResponsavelTecnico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<ResponsavelTecnico> insert(@RequestBody ResponsavelTecnico obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponsavelTecnico> update(@PathVariable Integer id, @RequestBody ResponsavelTecnico obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);		
	}

}