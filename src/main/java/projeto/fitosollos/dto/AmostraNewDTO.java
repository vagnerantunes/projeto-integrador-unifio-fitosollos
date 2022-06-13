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
public class AmostraNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
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

