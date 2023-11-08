package be.yass.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Groupe {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomGroup;
	private String branch;
	private String AnneeScolaire;
	@OneToMany(mappedBy = "groupe") 
	private List<Eleve>eleves;
	 
	@ManyToOne private Niveau niveau;
	
	 @ManyToMany(mappedBy = "groupes")  // Indiquez la propriété "niveaux" de l'entité Enseignant
	 private List<Enseignant> enseignants;
	 
	
}
