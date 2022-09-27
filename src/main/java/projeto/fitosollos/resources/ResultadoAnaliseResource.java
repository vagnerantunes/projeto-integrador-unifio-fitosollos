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

import projeto.fitosollos.dto.ResultadoAnaliseDTO;
import projeto.fitosollos.dto.ResultadoAnaliseNewDTO;
import projeto.fitosollos.entities.ResultadoAnalise;
import projeto.fitosollos.services.ResultadoAnaliseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/resultados")
public class ResultadoAnaliseResource {

	@Autowired
	private ResultadoAnaliseService service;
	
	@GetMapping
	public ResponseEntity<List<ResultadoAnalise>> findAll(){
		List<ResultadoAnalise> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResultadoAnalise> findById(@PathVariable Integer id){
		ResultadoAnalise obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid ResultadoAnaliseNewDTO resultadoAnaliseNewDTO){
		ResultadoAnalise resultadoAnalise = service.insert(resultadoAnaliseNewDTO);
		
		//boas praticas, ao inserir um recurso retornar sua URI (endereco) onde foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(resultadoAnalise.getResId()).toUri(); 
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody @Valid ResultadoAnaliseDTO resultadoAnaliseDTO){
		service.update(id, resultadoAnaliseDTO);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
		
	}
	
	
}