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
public class Laboratorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "LAB_ID")
	private Integer labId;
	@NotNull
	@Column(length = 45, name = "LAB_RAZAO_SOCIAL")
	private String labRazaoSocial;
	@NotNull
	@Column(length = 45, name = "LAB_NOME_FANTASIA")
	private String labNomeFantasia;
	@NotNull
	@Column(length = 14, name = "LAB_CNPJ")
	private String labCnpj;
	@NotNull
	@Column(length = 45, name = "LAB_ENDERECO")
	private String labEndereco;
	@NotNull
	@Column(length = 10, name = "LAB_TELEFONE")
	private String labTelefone;
}