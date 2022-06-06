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
	
	private Integer id;

	private String descricao;

	private Instant chegada;

	private Instant saida;

	private Double peso;

	private String finalizada;
	
	private String cancelada;
	
	private Integer usuario;
	
	private Integer analise;
	
	private Integer cultura;
	
	private Integer proprietario;
	
	private Integer tecnico;
	
	private Integer laboratorio;

}
