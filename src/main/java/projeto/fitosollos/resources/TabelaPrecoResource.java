package projeto.fitosollos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.fitosollos.dto.TabelaPrecoDTO;
import projeto.fitosollos.dto.TabelaPrecoNewDTO;
import projeto.fitosollos.entities.TabelaPreco;
import projeto.fitosollos.services.TabelaPrecoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/precos")
public class TabelaPrecoResource {
	
	@Autowired
	private TabelaPrecoService service;
	
	@GetMapping
	public ResponseEntity<List<TabelaPreco>> findAll(){
		List<TabelaPreco> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TabelaPreco> findById(@PathVariable Integer id){
		TabelaPreco obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid TabelaPrecoNewDTO tabelaPrecoNewDTO){
		TabelaPreco tabelaPreco = service.insert(tabelaPrecoNewDTO);
		
		//boas praticas, ao inserir um recurso retornar sua URI (endereco) onde foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(tabelaPreco.getTabId()).toUri(); 
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody @Valid TabelaPrecoDTO tabelaPrecoDTO){
		service.update(id, tabelaPrecoDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
