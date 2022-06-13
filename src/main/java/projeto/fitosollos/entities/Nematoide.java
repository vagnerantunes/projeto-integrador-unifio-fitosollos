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
public class Nematoide implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 11, name = "NEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nemId;
	
	@NotNull
	@Column(length = 45, name = "NEM_DESCRICAO")
	private String nemDescricao;


}