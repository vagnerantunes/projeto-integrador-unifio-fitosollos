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
public class ResultadoAnalise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double qtdSolo;

	private Double qtdRaiz;

	private Double qtdOvos;
	
	@ManyToOne
	@JoinColumn(name = "nematoide")
	private Nematoide nematoide;
	
	@ManyToOne
	@JoinColumn(name = "amostra")
	private Amostra amostra;
	
	public ResultadoAnalise() {		
	}

	public ResultadoAnalise(Long id, Double qtdSolo, Double qtdRaiz, Double qtdOvos, Nematoide nematoide,
			Amostra amostra) {
		this.id = id;
		this.qtdSolo = qtdSolo;
		this.qtdRaiz = qtdRaiz;
		this.qtdOvos = qtdOvos;
		this.nematoide = nematoide;
		this.amostra = amostra;
	}

}