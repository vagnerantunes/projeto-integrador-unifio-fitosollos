package projeto.fitosollos.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResultadoAnaliseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer resId;

	private Double resQtdSolo;

	private Double resQtdRaiz;
	
	private Double resQtdOvos;
	
	private Integer resNematoide;
	
	private Integer resAmostra;

}
