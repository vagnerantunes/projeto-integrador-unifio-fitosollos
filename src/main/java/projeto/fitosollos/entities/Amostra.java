package projeto.fitosollos.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Amostra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	private Instant chegada;

	private Instant saida;

	private Double peso;

	private String finalizada;
	
	private String cancelada;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "analise")
	private TipoAnalise analise;
	
	@ManyToOne
	@JoinColumn(name = "cultura")
	private Cultura cultura;
	
	@ManyToOne
	@JoinColumn(name = "proprietario")
	private Proprietario proprietario;
	
	@ManyToOne
	@JoinColumn(name = "tecnico")
	private ResponsavelTecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "laboratorio")
	private Laboratorio laboratorio;
	
	public Amostra() {		
	}

	public Amostra(Long id, String descricao, Instant chegada, Instant saida, Double peso, String finalizada,
			String cancelada, Usuario usuario, TipoAnalise analise, Cultura cultura, Proprietario proprietario,
			ResponsavelTecnico tecnico, Laboratorio laboratorio) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.chegada = chegada;
		this.saida = saida;
		this.peso = peso;
		this.finalizada = finalizada;
		this.cancelada = cancelada;
		this.usuario = usuario;
		this.analise = analise;
		this.cultura = cultura;
		this.proprietario = proprietario;
		this.tecnico = tecnico;
		this.laboratorio = laboratorio;
	}
	
}