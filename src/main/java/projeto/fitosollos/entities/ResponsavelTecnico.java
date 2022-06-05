package projeto.fitosollos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ResponsavelTecnico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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
	
}