package dev.service;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

import dev.dao.IPlatDao;

class PlatServiceVersion1Test {
	
	IPlatDao platDao;
    IPlatService platServiceVersion1;
	
	@BeforeEach
	public void setUp() {
		platDao = Mockito.mock(IPlatDao.class); 
	    platServiceVersion1 = new PlatServiceVersion1(platDao);
	}

	@Test
    void testAjouterPlatNomInvalide() {
        assertThatThrownBy(() -> { platServiceVersion1.ajouterPlat("P", 10000);
        }).hasMessage("Le plat doit avoir un nom avec plus de 3 caractères");
    }
	
	@Test
    void testAjouterPlatPrixInvalide() {
        assertThatThrownBy(() -> { platServiceVersion1.ajouterPlat("Pizza", 2);
        }).hasMessage("le prix d'un plat doit être supérieur à 5 €");
    }

    @Test
    void testAjouterPlat() {
        platServiceVersion1.ajouterPlat("Pizza", 10000);
        verify(platDao).ajouterPlat("Pizza", 10000);
    }
}
