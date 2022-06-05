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
public class ResultadoAnalise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double qtdSolo;

	private Double qtdRaiz;

	private Double qtdOvos;
	
	@ManyToOne
	@JoinColumn(name = "nematoide")
	private Nematoide nematoide;
	
	@ManyToOne
	@JoinColumn(name = "amostra")
	private Amostra amostra;

}