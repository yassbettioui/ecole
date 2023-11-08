package be.yass.dto;

import lombok.Data;

@Data
public class EnseignantDTO {

	private Long id;
	private String nom;
	private String prenom;
	private String numContact;
	private String emailContact;
	
}
