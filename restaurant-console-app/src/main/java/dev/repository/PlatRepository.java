package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.entite.Plat;

public interface PlatRepository extends JpaRepository<Plat, Integer> {

	List<Plat> findByPrixEnCentimesEuros(Integer prixEnCentimesEuros);

	@Query("select avg(p.prixEnCentimesEuros) from Plat p where p.prixEnCentimesEuros > :prixEnCentimesEuros")
	Integer avgPrix(@Param("prixEnCentimesEuros") Integer prix);

}
