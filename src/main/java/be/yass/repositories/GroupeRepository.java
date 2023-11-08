package be.yass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.yass.entities.Groupe;
import be.yass.entities.Niveau;
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

	List<Groupe> findByNiveau(Niveau niveau);
	
}
