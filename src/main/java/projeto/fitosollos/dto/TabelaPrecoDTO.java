package projeto.fitosollos.dto;

import java.io.Serializable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TabelaPrecoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer tabId;

	private Double tabValor;
	
	private Integer tabAnalise;
	
	private Integer tabLaboratorio;
}