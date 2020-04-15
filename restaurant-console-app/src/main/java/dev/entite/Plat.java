package dev.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entité de Plat
 * 
 * @author Salaheddine El Majdooub
 *
 */
@Entity
@Table(name = "plat")
public class Plat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prixEnCentimesEuros")
	private Integer prixEnCentimesEuros;

	@ManyToMany
	@JoinTable(name = "plat_ingredient", joinColumns = @JoinColumn(name = "plat_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
	private List<Ingredient> ingredients = new ArrayList<>();

	public Plat() {
	}

	public Plat(String nom) {
		this.nom = nom;
	}

	public Plat(String nom, Integer prixEnCentimesEuros) {
		this.nom = nom;
		this.prixEnCentimesEuros = prixEnCentimesEuros;
	}

	/**
	 * Getter
	 * 
	 * @return nom de plat
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom de plat
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return le prix en centimes
	 */
	public Integer getPrixEnCentimesEuros() {
		return prixEnCentimesEuros;
	}

	/**
	 * Setter
	 * 
	 * @param prixEnCentimesEuros
	 */
	public void setPrixEnCentimesEuros(Integer prixEnCentimesEuros) {
		this.prixEnCentimesEuros = prixEnCentimesEuros;
	}

}
