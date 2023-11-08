package be.yass.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import be.yass.mapper.EcoleMapper;
import be.yass.repositories.EleveRepository;
import be.yass.repositories.EnseignantRepository;
import be.yass.repositories.GroupeRepository;
import be.yass.repositories.MatiereRepository;
import be.yass.repositories.NiveauRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EcoleServiceImpl implements EcoleService{

	private EleveRepository eleveRepository;
	private EnseignantRepository enseignantRepository;
	private NiveauRepository niveauRepository;
	private MatiereRepository matiereRepository;
	private GroupeRepository groupeRepository;
	private EcoleMapper mapper;
	
	@Override
	public List<EleveDTO> listEleve() {
		List<Eleve>eleves= eleveRepository.findAll();
		List<EleveDTO>EleveDTOS= eleves.stream()
                .map(eleve -> mapper.fromEleve(eleve))
                .collect(Collectors.toList());
		return EleveDTOS;
	}

	@Override
	public List<EnseignantDTO> listEnseignant() {
List<Enseignant> enseignants= enseignantRepository.findAll();
List<EnseignantDTO> enseignantDTOs= enseignants.stream()
.map(enseignant->mapper.fromEnseignant(enseignant))
.collect(Collectors.toList());
return enseignantDTOs;
	}

	@Override
	public List<MatiereDTO> listMatiere() {
	List<Matiere>matieres= matiereRepository.findAll();
	List<MatiereDTO> matiereDtos= matieres.stream()
	.map(matiere->mapper.fromMatiere(matiere))
	.collect(Collectors.toList());
	return matiereDtos;
	}

	@Override
	public List<NiveauDTO> listniveau() {
List<Niveau> niveaux = niveauRepository.findAll();
List <NiveauDTO> niveauDTOs=  niveaux.stream()
.map(niveau->mapper.fromNiveau(niveau))
.collect(Collectors.toList());
return niveauDTOs;

}
//
@Override
	public List<EleveDTO> chercherEleve(String Keyword) {
  List<Eleve>eleves=eleveRepository.searchEleve(Keyword);
   List<EleveDTO> eleveDTOs = eleves.stream()
		   .map(eleve->mapper.fromEleve(eleve))
		   .collect(Collectors.toList());

		return eleveDTOs;

//return null;	
}

	@Override
	public List<EnseignantDTO> chercherEnseignant(String Keyword) {
		 List<Enseignant>enseignants=enseignantRepository.searchEnseignant(Keyword);
		   List<EnseignantDTO> enseignantDTOs = enseignants.stream()
				   .map(e->mapper.fromEnseignant(e))
				   .collect(Collectors.toList());

				return enseignantDTOs;
	}

	@Override
	public EleveDTO eleveByid(Long id) {
Eleve e= eleveRepository.findById(id).get();
EleveDTO eleveDTO= mapper.fromEleve(e);
		return eleveDTO;
	}

	@Override
	public List<GroupeDTO> groupeByNiveau(Niveau niveau) {
Niveau n= niveauRepository.findById(niveau.getId()).get();
List<Groupe> groupesNiv= groupeRepository.findByNiveau(n);
List<GroupeDTO> groupeDTOs= groupesNiv.stream()
.map(groupe->mapper.fromGroupe(groupe))
.collect(Collectors.toList());
return groupeDTOs;
	}

	@Override
	public EnseignantDTO enseignatByid(Long id) {
Enseignant enseignant = enseignantRepository.findById(id).get();
EnseignantDTO enseignantDTO = mapper.fromEnseignant(enseignant);
		return enseignantDTO;
	}
@Override	
public	EleveDTO saveEleve(EleveDTO eleveDTO) {
	Eleve e= mapper.fromEleveDTO(eleveDTO);
	Eleve savedEleve =eleveRepository.save(e);
	return mapper.fromEleve(savedEleve);
}

@Override
	public EleveDTO updateEleve(EleveDTO eleveDTO) {
		Eleve e = mapper.fromEleveDTO(eleveDTO);
	    Eleve eleveSaved= eleveRepository.save(e);
		return mapper.fromEleve(eleveSaved);
	}

	@Override
	public EnseignantDTO updateEnseignant(EnseignantDTO enseignantDTO) {
		Enseignant e = mapper.fromEnseignantDTO(enseignantDTO);
		Enseignant es= enseignantRepository.save(e);
		return mapper.fromEnseignant(es);
	}

	@Override
public EnseignantDTO saveEnseignant(EnseignantDTO enseignantDTO) {
Enseignant enseignant =mapper.fromEnseignantDTO(enseignantDTO);
Enseignant savedEns = enseignantRepository.save(enseignant);
return mapper.fromEnseignant(savedEns);
}



}
