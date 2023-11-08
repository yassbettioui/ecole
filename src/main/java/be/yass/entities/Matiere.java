package be.yass.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder

public class Matiere {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	
	 @ManyToMany(mappedBy ="matieres")
	 private List<Niveau> Niveaux;
	 
	 @OneToMany(mappedBy = "matiere") private List<Enseignant>enseignants;
	 
}
