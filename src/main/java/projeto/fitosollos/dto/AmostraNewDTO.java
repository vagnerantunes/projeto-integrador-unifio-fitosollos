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

