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
public class Recebimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "REC_ID")
	private Integer recId;

	@NotNull
	@Column(name = "REC_VALOR")
	private Double recValor;

	@NotNull
	@Column(name = "REC_HORARIO")
	private Instant recHorario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "REC_FPG_ID")
	private FormaPagamento recFormaPagamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "REC_AMO_ID")
	private Amostra recAmostra;
	
}