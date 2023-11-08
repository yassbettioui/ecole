package be.yass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.yass.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

	
	@Query("SELECT e FROM Enseignant e WHERE e.nom LIKE %:kw% OR e.prenom LIKE %:kw%")
	List<Enseignant> searchEnseignant(@Param("kw") String keyword);

}


