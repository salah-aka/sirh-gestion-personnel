package dev.dao;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.entite.Plat;

class PlatDaoMemoireTest {

	private PlatDaoMemoire platDaoMemoire;

	@BeforeEach
	void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	@Test
	void listerPlatsVideALInitialisation() {

		assertTrue(platDaoMemoire.listerPlats().isEmpty());
	}

	@Test
	void ajouterPlatCasPassants() {
		
		platDaoMemoire.ajouterPlat("Pizza", 100000);
		assertFalse(platDaoMemoire.listerPlats().isEmpty());
	}
}
