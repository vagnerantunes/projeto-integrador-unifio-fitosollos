package projeto.fitosollos.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TabelaPrecoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double valor;
	
	private Integer analise;
	
	private Integer laboratorio;

}
