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
public class ResponsavelTecnicoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
