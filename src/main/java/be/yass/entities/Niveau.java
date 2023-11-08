package be.yass.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Niveau {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Enumerated(EnumType.STRING)
	private NiveauScolaire niveauScolaire;
	
	 @OneToMany(mappedBy = "niveau") 
	 private List<Eleve> eleves;
	 
	 @OneToMany(mappedBy = "niveau") private List<Groupe> groupes;
	 @ManyToMany
		@JoinTable(
			    name = "niveau_matieres",  // Nom de la table de liaison
			    joinColumns = @JoinColumn(name = "niveau_id"), 
			    inverseJoinColumns = @JoinColumn(name = "matiere_id")  
			)
	 private List<Matiere>matieres;
	 @ManyToMany(mappedBy = "niveaux")  // Indiquez la propriété "niveaux" de l'entité Enseignant
	 private List<Enseignant> enseignants;

	
}
