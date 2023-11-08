package be.yass.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import be.yass.dto.EleveDTO;
import be.yass.dto.EnseignantDTO;
import be.yass.dto.GroupeDTO;
import be.yass.dto.MatiereDTO;
import be.yass.dto.NiveauDTO;
import be.yass.entities.Eleve;
import be.yass.entities.Enseignant;
import be.yass.entities.Groupe;
import be.yass.entities.Matiere;
import be.yass.entities.Niveau;
import lombok.Data;
@Service
@Data
public class EcoleMapper {

	
	public Eleve fromEleveDTO(EleveDTO eleveDTO) {
		Eleve e = new Eleve();
		BeanUtils.copyProperties(eleveDTO, e);
     return e;		
	}
	
	public EleveDTO fromEleve(Eleve eleve) {
		EleveDTO eleveDTO = new EleveDTO();
		BeanUtils.copyProperties(eleve, eleveDTO);
     return eleveDTO;		
	}
	
	public Enseignant fromEnseignantDTO(EnseignantDTO enseignantDTO) {
		Enseignant e = new Enseignant();
		BeanUtils.copyProperties(enseignantDTO, e);
     return e;		
	}
	
	public EnseignantDTO fromEnseignant(Enseignant enseignant) {
		EnseignantDTO enseignantDTO = new EnseignantDTO();
		BeanUtils.copyProperties(enseignant, enseignantDTO);
     return enseignantDTO;		
	}
	
	public MatiereDTO fromMatiere(Matiere matiere) {
		MatiereDTO matiereDTO= new MatiereDTO();
		BeanUtils.copyProperties(matiere, matiereDTO);
		return matiereDTO;
		}
	
	public GroupeDTO fromGroupe(Groupe groupe) {
		GroupeDTO groupeDTO= new GroupeDTO();
		BeanUtils.copyProperties(groupe, groupeDTO);
		return groupeDTO;
		}
	
	public NiveauDTO fromNiveau(Niveau niveau) {
		NiveauDTO niveauDTO= new NiveauDTO();
		BeanUtils.copyProperties(niveau, niveauDTO);
		return niveauDTO;
		}
	
}
