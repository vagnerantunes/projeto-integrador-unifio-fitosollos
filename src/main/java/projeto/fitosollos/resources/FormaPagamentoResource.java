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

import projeto.fitosollos.entities.FormaPagamento;
import projeto.fitosollos.services.FormaPagamentoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/fpagamentos")
public class FormaPagamentoResource {

	@Autowired
	private FormaPagamentoService service;
	
	@GetMapping
	public ResponseEntity<List<FormaPagamento>> findAll(){
		List<FormaPagamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FormaPagamento> findById(@PathVariable Long id){
		FormaPagamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<FormaPagamento> insert(@RequestBody FormaPagamento obj){
		obj = service.insert(obj);
		return ResponseEntity.noContent().build();		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FormaPagamento> update(@PathVariable Long id, @RequestBody FormaPagamento obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
