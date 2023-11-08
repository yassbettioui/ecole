package be.yass.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Enseignant {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String photo;
	private LocalDate dateNaissance;
    private String numContact;
	private String emailContact;
	private LocalDate dateDebut;
	private LocalDate datePremExp;
	 @ManyToMany 
		@JoinTable(
			    name = "enseignant_groupes",  // Nom de la table de liaison
			    joinColumns = @JoinColumn(name = "enseignant_id"),  // Colonne de l'enseignant
			    inverseJoinColumns = @JoinColumn(name = "groupe_id")  // Colonne du niveau
			)
	 private List<Groupe>groupes;
	@ManyToOne private Matiere matiere;
	 
	@ManyToMany
	@JoinTable(
	    name = "enseignant_niveaux",  // Nom de la table de liaison
	    joinColumns = @JoinColumn(name = "enseignant_id"),  // Colonne de l'enseignant
	    inverseJoinColumns = @JoinColumn(name = "niveau_id")  // Colonne du niveau
	)
	private List<Niveau> niveaux;

	
	}
