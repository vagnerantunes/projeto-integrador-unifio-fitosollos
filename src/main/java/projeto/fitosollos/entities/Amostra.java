package projeto.fitosollos.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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
	@Column(length = 11, name = "AMO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer amoId;

	@Column(length = 45, name = "AMO_DESCRICAO")
	private String amoDescricao;

	@Column(name = "AMO_DH_CHEGADA")
	private Instant amoChegada;
	
	@Column(name = "AMO_DH_SAIDA")
	private Instant amoSaida;

	@Column(name = "AMO_PESO")
	private Double amoPeso;

	@Column(length = 1,name = "AMO_FINALIZADA")
	private String amoFinalizada;
	
	@Column(length = 1,name = "AMO_CANCELADA")
	private String amoCancelada;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "AMO_USU_ID")
	private Usuario amoUsuario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "AMO_TIP_ID")
	private TipoAnalise amoAnalise;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "AMO_CUL_ID")
	private Cultura amoCultura;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "AMO_PRO_ID")
	private Proprietario amoProprietario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "AMO_TEC_ID")
	private ResponsavelTecnico amoTecnico;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "AMO_LAB_ID")
	private Laboratorio amoLaboratorio;
	
	
}