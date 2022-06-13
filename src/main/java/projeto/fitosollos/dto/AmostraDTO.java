package projeto.fitosollos.dto;

import java.io.Serializable;
import java.time.Instant;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AmostraDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer amoId;

	private String amoDescricao;

	private Instant amoChegada;
	
	private Instant amoSaida;

	private Double amoPeso;

	private String amoFinalizada;
	
	private String amoCancelada;
	
	private Integer amoUsuario;
	
	private Integer amoAnalise;
	
	private Integer amoCultura;
	
	private Integer amoProprietario;
	
	private Integer amoTecnico;
	
	private Integer amoLaboratorio;

}
