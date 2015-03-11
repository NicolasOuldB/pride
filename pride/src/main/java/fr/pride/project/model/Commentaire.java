package fr.pride.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "commentaire")
@Entity
@NamedQueries({
		@NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM Commentaire c"),
})
@XmlRootElement(name = "commentaire")
@XmlAccessorType(XmlAccessType.FIELD)
public class Commentaire {

	@EmbeddedId
	private CommentaireId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utilisateur", nullable = false)
	@MapsId("idUtilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_projet", nullable = false)
	@MapsId("idProjet")
	private Projet projet;
	
	@Column(columnDefinition = "TEXT")
	private String texte;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	/*
	 * Getters and Setters
	 */
	
	public CommentaireId getId() {
		return id;
	}

	public void setId(CommentaireId id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
}