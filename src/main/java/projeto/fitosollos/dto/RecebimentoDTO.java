package projeto.fitosollos.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecebimentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer recId;

	private Double recValor;

	private Instant recHorario;
	
	private Integer recFormaPagamento;
	
	private Integer recAmostra;
	
}