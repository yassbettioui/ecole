package be.yass.web;

import java.util.List;

import be.yass.entities.Eleve;
import org.springframework.web.bind.annotation.*;

import be.yass.dto.EleveDTO;
import be.yass.dto.EnseignantDTO;
import be.yass.service.EcoleService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class EcoleRestController {

	private EcoleService ecoleService;

	@GetMapping("/eleves")
	public List<EleveDTO> getEleves() {
		return ecoleService.listEleve();
	}

	@GetMapping("/eleves/{id}")
	public EleveDTO getEleveById(@PathVariable("id") Long id) {
		return ecoleService.eleveByid(id);
	}

	@GetMapping("/eleves/search")
	public List<EleveDTO> SearchEleveKw(@RequestParam(name = "kw", defaultValue = "") String Keyword) {
		return ecoleService.chercherEleve("%" + Keyword + "%");
	}

	@GetMapping("/teachers")
	public List<EnseignantDTO> getEnseignants() {
		return ecoleService.listEnseignant();
	}

	@GetMapping("/teachers/{id}")
	public EnseignantDTO getEnseignantById(@PathVariable("id") Long id) {
		return ecoleService.enseignatByid(id);
	}

	@PostMapping("/eleve")
	public EleveDTO SaveEleve(@RequestBody EleveDTO eleveDTO) {
		return ecoleService.saveEleve(eleveDTO);
	}

	@PostMapping("/teacher")
	public EnseignantDTO SavaasseTeacher(@RequestBody EnseignantDTO enseignantDTO) {
		return ecoleService.saveEnseignant(enseignantDTO);
	}

	@PutMapping("/eleve/{idE}")
	public EleveDTO updateEleve(@PathVariable("idE") Long idE, @RequestBody EleveDTO eleveDTO) {
		eleveDTO.setId(idE);
		return ecoleService.saveEleve(eleveDTO);

	}

}