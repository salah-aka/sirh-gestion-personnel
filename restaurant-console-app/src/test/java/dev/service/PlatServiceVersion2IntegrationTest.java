package dev.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.dao.PlatDaoMemoire;

@SpringJUnitConfig({ PlatDaoMemoire.class, PlatServiceVersion2.class })
@ActiveProfiles({ "memoire", "service2" })
class PlatServiceVersion2IntegrationTest {

	// Injection de la Bean à tester (puisqu'il est dans le context)
	@Autowired
	IPlatService platServiceVersion2;

//	@BeforeEach
//	public void setUp() {
//		platDao = Mockito.mock(IPlatDao.class); 
//	    platServiceVersion2 = new PlatServiceVersion1(platDao);
//	}

	@Test
	void listerPlatsVideALInitialisation() {
		platServiceVersion2.ajouterPlat("Pizzaaa", 100000);
		assertFalse(platServiceVersion2.listerPlats().isEmpty());
	}

	@Test
	void testAjouterPlatPrixInvalide() {
		assertThatThrownBy(() -> {
			platServiceVersion2.ajouterPlat("Pizzaaa", 1);
		}).hasMessage("le prix d'un plat doit être supérieur à 10 €");
	}
}
