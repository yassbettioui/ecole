package be.yass.service;
import java.util.List;

import be.yass.entities.Enseignant;
import org.springframework.stereotype.Service;

import be.yass.dto.EleveDTO;
import be.yass.dto.EnseignantDTO;
import be.yass.dto.GroupeDTO;
import be.yass.dto.MatiereDTO;
import be.yass.dto.NiveauDTO;
import be.yass.entities.Niveau;

public interface EcoleService {

 List<EleveDTO> listEleve();
 List<EnseignantDTO> listEnseignant();
 List<MatiereDTO> listMatiere();
 List<NiveauDTO> listniveau();

 List<EleveDTO> chercherEleve(String keyword);
 List<EnseignantDTO> chercherEnseignant(String Keyword);
 
 
 EleveDTO eleveByid(Long id);
 List<GroupeDTO> groupeByNiveau(Niveau niveau);
EnseignantDTO enseignatByid(Long id);
 
 
EleveDTO saveEleve(EleveDTO eleveDTO);
EnseignantDTO saveEnseignant(EnseignantDTO enseignantDTO);

EleveDTO updateEleve(EleveDTO eleveDTO);
EnseignantDTO updateEnseignant(EnseignantDTO enseignantDTO);
}


