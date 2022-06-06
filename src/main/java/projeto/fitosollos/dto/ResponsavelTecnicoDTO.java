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
	
	private Integer id;

	private String nome;
	
	private String ddd;

	private String telefone;

	private String cidade;

	private String uf;
	
	private String endereco;
	
	private String bairro;
	
	private String cep;

	private Integer crq;
	
	private Integer laboratorio;

}
