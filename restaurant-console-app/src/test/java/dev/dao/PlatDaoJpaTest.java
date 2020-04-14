package dev.dao;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.entite.Plat;

/**
 * Classe de test des 2methode d'une objet platDaoJpa avec l'utilisation d'une
 * connection avec une BDD embarquée
 * 
 * @author Salaheddine El Majdoub
 *
 */
@SpringJUnitConfig({ JpaConfig.class, DataSourceH2TestConfig.class, PlatDaoJpa.class })
@ActiveProfiles("jpa")
@Transactional
class PlatDaoJpaTest {

	@Autowired
	IPlatDao platDeoJpa;

	@Test
	void listePlatNomVide() {
		List<Plat> listePlat = platDeoJpa.listerPlats();
		assertFalse(listePlat.isEmpty());
	}

	@Test
	void ajouterPlatCasPassants() {
		Plat plat = new Plat("Pastilla", 70000);
		platDeoJpa.ajouterPlat(plat.getNom(), plat.getPrixEnCentimesEuros());
		Assertions.assertThat(platDeoJpa.listerPlats()).contains(plat);
	}

}
