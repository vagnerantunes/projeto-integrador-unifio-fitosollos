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
public class TabelaPreco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11, name = "TAB_ID")
	private Integer tabId;

	@NotNull
	@Column(name = "TAB_VALOR")
	private Double tabValor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "TAB_TIP_ID")
	private TipoAnalise tabAnalise;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "TAB_LAB_ID")
	private Laboratorio tabLaboratorio;

}