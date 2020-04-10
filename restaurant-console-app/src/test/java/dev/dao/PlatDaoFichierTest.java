package dev.dao;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.entite.Plat;

/**
 * Test d'integration par spring de la classe PlatDaoFichier
 * 
 * @author Salaheddine El Majdoub
 *
 */
@SpringJUnitConfig(PlatDaoFichier.class)
@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class PlatDaoFichierTest {

	@Autowired
	private IPlatDao daoFichier;

	@Test
	void ajouterPlatCasPassants() {

		Plat plat = new Plat("Pizzaaa", 100000);
		List<Plat> listPlat = new ArrayList<>();
		listPlat.add(plat);
		daoFichier.ajouterPlat("Pizzaaa", 100000);
		Assertions.assertThat(daoFichier.listerPlats()).isEqualTo(listPlat);
	}

	@Test
	void ajouterPlatCasPassantsInd() {

		Plat plat = new Plat("Pizzaaa", 100000);
		List<Plat> listPlat = new ArrayList<>();
		listPlat.add(plat);
		daoFichier.ajouterPlat("Pizzaaa", 100000);
		Assertions.assertThat(daoFichier.listerPlats()).isEqualTo(listPlat);
	}

}
