package projeto.fitosollos.entities;

import java.io.Serializable;

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
public class ResultadoAnalise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 11, name = "RES_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resId;

	@Column(name = "RES_QTD_SOLO")
	private Double resQtdSolo;

	@Column(name = "RES_QTD_RAIZ")
	private Double resQtdRaiz;
	
	@Column(name = "RES_QTD_OVOS")
	private Double resQtdOvos;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "RES_NEM_ID")
	private Nematoide resNematoide;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "RES_AMO_ID")
	private Amostra resAmostra;

}