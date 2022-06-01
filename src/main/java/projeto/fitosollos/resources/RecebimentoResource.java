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

import projeto.fitosollos.entities.Recebimento;
import projeto.fitosollos.services.RecebimentoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/recebimentos")
public class RecebimentoResource {

	@Autowired
	private RecebimentoService service;

	@GetMapping
	public ResponseEntity<List<Recebimento>> findAll() {
		List<Recebimento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Recebimento> findById(@PathVariable Long id) {
		Recebimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Recebimento> insert(@RequestBody Recebimento obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Recebimento> update(@PathVariable Long id, @RequestBody Recebimento obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);		
	}

}
