package projeto.fitosollos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class ResponsavelTecnico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String ddd;

	private String telefone;

	private String cidade;

	private String uf;
	
	private String endereco;
	
	private String bairro;
	
	private String cep;

	@ManyToOne
	@JoinColumn(name = "crq")
	private Crq crq;
	
	@ManyToOne
	@JoinColumn(name = "laboratorio")
	private Laboratorio laboratorio;
	
	
	public ResponsavelTecnico() {		
	}


	public ResponsavelTecnico(Long id, String nome, String ddd, String telefone, String cidade, String uf,
			String endereco, String bairro, String cep, Crq crq, Laboratorio laboratorio) {
		super();
		this.id = id;
		this.nome = nome;
		this.ddd = ddd;
		this.telefone = telefone;
		this.cidade = cidade;
		this.uf = uf;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
		this.crq = crq;
		this.laboratorio = laboratorio;
	}
	
}