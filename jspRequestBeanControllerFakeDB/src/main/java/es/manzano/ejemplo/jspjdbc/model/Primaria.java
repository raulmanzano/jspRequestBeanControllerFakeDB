package es.manzano.ejemplo.jspjdbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the primaria database table.
 * 
 */
@Entity
@NamedQuery(name="Primaria.findAll", query="SELECT p FROM Primaria p")
public class Primaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRIMARIA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIMARIA_ID_GENERATOR")
	private Integer id;

	private String campo1;

	private String campo2;

	private String campo3;

	//bi-directional many-to-one association to Secundaria
	@OneToMany(mappedBy="primaria")
	private List<Secundaria> secundarias;

	public Primaria() {
	}

	public Primaria(Integer id, String campo1, String campo2, String campo3) {
		this.id=id;
		this.campo1=campo1;
		this.campo2=campo2;
		this.campo3=campo3;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampo1() {
		return this.campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo2() {
		return this.campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String getCampo3() {
		return this.campo3;
	}

	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}

	public List<Secundaria> getSecundarias() {
		return this.secundarias;
	}

	public void setSecundarias(List<Secundaria> secundarias) {
		this.secundarias = secundarias;
	}

	public Secundaria addSecundaria(Secundaria secundaria) {
		getSecundarias().add(secundaria);
		secundaria.setPrimaria(this);

		return secundaria;
	}

	public Secundaria removeSecundaria(Secundaria secundaria) {
		getSecundarias().remove(secundaria);
		secundaria.setPrimaria(null);

		return secundaria;
	}

}