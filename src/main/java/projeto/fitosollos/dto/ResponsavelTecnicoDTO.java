package projeto.fitosollos.dto;

import java.io.Serializable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponsavelTecnicoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer tecId;
	
	private String tecNome;

	private String tecDdd;

	private String tecTelefone;

	private String tecCidade;

	private String tecUf;
	
	private String tecEndereco;
	
	private String tecBairro;
	
	private String tecCep;

	private Integer tecCrq;
	
	private Integer tecLaboratorio;
}
