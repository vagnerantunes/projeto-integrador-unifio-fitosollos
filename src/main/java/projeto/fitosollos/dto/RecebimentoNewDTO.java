package projeto.fitosollos.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecebimentoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double valor;

	private Instant horario;

	private Integer formaPagamento;
	
	private Integer amostra;
	
}
