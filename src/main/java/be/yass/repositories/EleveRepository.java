package be.yass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.yass.entities.Eleve;

public interface EleveRepository extends JpaRepository<Eleve, Long> {

	@Query("SELECT e FROM Eleve e WHERE e.nom LIKE %:kw% OR e.prenom LIKE %:kw%")
	List<Eleve> searchEleve(@Param("kw") String keyword);
	
}
