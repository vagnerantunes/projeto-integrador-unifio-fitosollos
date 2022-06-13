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

import projeto.fitosollos.dto.ResponsavelTecnicoDTO;
import projeto.fitosollos.dto.ResponsavelTecnicoNewDTO;
import projeto.fitosollos.entities.ResponsavelTecnico;
import projeto.fitosollos.services.ResponsavelTecnicoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/tecnicos")
public class ResponsavelTecnicoResource {

	@Autowired
	private ResponsavelTecnicoService service;
	
	@GetMapping
	public ResponseEntity<List<ResponsavelTecnico>> findAll(){
		List<ResponsavelTecnico> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponsavelTecnico> findById(@PathVariable Integer id){
		ResponsavelTecnico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid ResponsavelTecnicoNewDTO responsavelTecnicoNewDTO){
		ResponsavelTecnico responsavelTecnico = service.insert(responsavelTecnicoNewDTO);
		//boas praticas, ao inserir um recurso retornar sua URI (endereco) onde foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(responsavelTecnico.getTecId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody @Valid ResponsavelTecnicoDTO responsavelTecnicoDTO){
		service.update(id, responsavelTecnicoDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.ok().build();
		
	}

}