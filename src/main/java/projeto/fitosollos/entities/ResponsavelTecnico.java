package projeto.fitosollos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class ResponsavelTecnico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "TEC_ID")
	private Integer tecId;
	
	@NotNull
	@Column(length = 45, name = "TEC_NOME")
	private String tecNome;

	@NotNull
	@Column(length = 2, name = "TEC_DDD")
	private String tecDdd;

	@NotNull
	@Column(length = 9, name = "TEC_TELEFONE")
	private String tecTelefone;

	@Column(length = 45, name = "TEC_CIDADE")
	private String tecCidade;

	@Column(length = 2, name = "TEC_UF")
	private String tecUf;
	
	@Column(length = 45, name = "TEC_ENDERECO")
	private String tecEndereco;
	
	@Column(length = 45, name = "TEC_BAIRRO")
	private String tecBairro;
	
	@Column(length = 8, name = "TEC_CEP")
	private String tecCep;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "crq")
	private Crq tecCrq;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "laboratorio")
	private Laboratorio tecLaboratorio;
	
}