package projeto.fitosollos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Proprietario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpfcnpj;
	private String ddd;
	private String telefone;
	private String cidade;
	private String uf;
	private String endereco;
	private String bairro;
	private String cep;
	
	public Proprietario() {
	}

	public Proprietario(Long id, String nome, String cpfcnpj, String ddd, String telefone, String cidade, String uf,
			String endereco, String bairro, String cep) {
		this.id = id;
		this.nome = nome;
		this.cpfcnpj = cpfcnpj;
		this.ddd = ddd;
		this.telefone = telefone;
		this.cidade = cidade;
		this.uf = uf;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	
	
}
