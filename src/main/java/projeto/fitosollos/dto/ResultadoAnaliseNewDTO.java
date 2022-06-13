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
public class ResultadoAnaliseNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double resQtdSolo;

	private Double resQtdRaiz;
	
	private Double resQtdOvos;
	
	private Integer resNematoide;
	
	private Integer resAmostra;

}
