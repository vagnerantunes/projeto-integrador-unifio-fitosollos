package projeto.fitosollos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proprietario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "PRO_ID")
	private Integer proId;
	@NotNull
	@Column(length = 45, name = "PRO_NOME")
	private String proNome;
	@NotNull
	@Column(length = 14, name = "PRO_CPF_CNPJ")
	private String proCpfCnpj;
	@NotNull
	@Column(length = 2, name = "PRO_DDD")
	private String proDdd;
	@NotNull
	@Column(length = 9, name = "PRO_TELEFONE")
	private String proTelefone;
	@Column(length = 45, name = "PRO_CIDADE")
	private String proCidade;
	@Column(length = 2, name = "PRO_UF")
	private String proUf;
	@Column(length = 45, name = "PRO_ENDERECO")
	private String proEndereco;
	@Column(length = 45, name = "PRO_BAIRRO")
	private String proBairro;
	@Column(length = 8, name = "PRO_CEP")
	private String proCep;
	
}
