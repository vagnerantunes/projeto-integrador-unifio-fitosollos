package projeto.fitosollos.entities;

import java.io.Serializable;
import java.time.Instant;

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
public class Amostra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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
	
	
}