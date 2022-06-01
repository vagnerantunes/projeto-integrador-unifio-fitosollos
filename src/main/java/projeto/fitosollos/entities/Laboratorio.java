package projeto.fitosollos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Laboratorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cnpj;
	private String endereco;
	private String telefone;

	public Laboratorio() {
	}

	public Laboratorio(Long id, String cnpj, String endereco, String telefone) {
		this.id = id;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
}