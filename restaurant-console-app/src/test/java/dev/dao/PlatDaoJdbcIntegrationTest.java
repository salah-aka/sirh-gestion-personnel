package dev.dao;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.entite.Plat;

/**
 * @author Salaheddine El Majdoub
 *
 */
@SpringJUnitConfig({ JdbcTestConfig.class, PlatDaoJdbc.class })
@ActiveProfiles("jdbc")
public class PlatDaoJdbcIntegrationTest {

	@Autowired
	private PlatDaoJdbc platDaoJdbc;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void listePlatNomVide() {
		List<Plat> listePlat = platDaoJdbc.listerPlats();
		assertFalse(listePlat.isEmpty());
	}

	@Test
	void ajouterPlatCasPassantsInd() {

		Plat plat = new Plat("Poulet", 100000);
		List<Plat> listPlat = new ArrayList<>();
		listPlat.add(plat);
		platDaoJdbc.ajouterPlat("Poulet", 100000);
		Assertions.assertThat(platDaoJdbc.listerPlats()).isEqualTo(listPlat);
	}

}
