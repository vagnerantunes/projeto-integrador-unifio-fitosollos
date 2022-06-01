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
public class Recebimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double valor;

	private Instant horario;

	@ManyToOne
	@JoinColumn(name = "pagamento")
	private FormaPagamento formaPagamento;
	
	@ManyToOne
	@JoinColumn(name = "amostra")
	private Amostra amostra;
	
	public Recebimento() {		
	}

	public Recebimento(Long id, Double valor, Instant horario, FormaPagamento formaPagamento,
			Amostra amostra) {
		this.id = id;
		this.valor = valor;
		this.horario = horario;
		this.formaPagamento = formaPagamento;
		this.amostra = amostra;
		
	}
	
}