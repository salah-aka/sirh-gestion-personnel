package dev.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Test d'integration par spring de la classe PlatDaoFichier
 * 
 * @author Salaheddine El Majdoub
 *
 */
@SpringJUnitConfig(PlatDaoFichier.class)
@TestPropertySource("classpath:test.properties")

class PlatDaoFichierTest {

	@Autowired
	PlatDaoFichier platDaoFichier;

	@Test
	void ajouterPlatCasPassants() {

		platDaoFichier.ajouterPlat("Pizzaaa", 100000);
		assertFalse(platDaoFichier.listerPlats().isEmpty());
	}

	@Test
	@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
	void ajouterPlatCasPassants1() {

		platDaoFichier.ajouterPlat("Pizzaaaz", 100000);
		assertFalse(platDaoFichier.listerPlats().isEmpty());
	}

}
