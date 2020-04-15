package dev.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dev.config.DataSourceH2TestConfig;
import dev.config.JpaConfig;
import dev.entite.Plat;

@SpringJUnitConfig({ JpaConfig.class, DataSourceH2TestConfig.class })
@Transactional
class PlatRepositoryIntegrationTest {

	@Autowired
	PlatRepository platRepository;

	// teste le fonctionnement de la méthode PlatRepository::findAll()
	@Test
	void testFindAll() {
		List<Plat> listePlats = platRepository.findAll();
		assertFalse(listePlats.isEmpty());
	}

	// teste le fonctionnement de la méthode PlatRepository::findAll(Sort)avec un
	// tri ascendant par prix.
	@Test
	void testFindAllSortAsc() {
		Sort tri = Sort.sort(Plat.class).by(Plat::getPrixEnCentimesEuros).ascending();
		List<Plat> listePlats = platRepository.findAll(tri);
		for (Plat pl : listePlats) {
			System.out.println(pl.getNom() + " " + pl.getPrixEnCentimesEuros());
		}
	}

	// teste le fonctionnement de la méthode PlatRepository::findAll(Sort) avec un
	// tri descendant par prix.
	@Test
	void testFindAllSortDesc() {
		Sort tri = Sort.sort(Plat.class).by(Plat::getPrixEnCentimesEuros).descending();
		List<Plat> listePlats = platRepository.findAll(tri);
		for (Plat pl : listePlats) {
			System.out.println(pl.getNom() + " " + pl.getPrixEnCentimesEuros());
		}
	}

	// teste le fonctionnement de la méthode PlatRepository::findAll(Pageable) :
	// récupéreation des deux premiers éléments en triant (ascendant) suivant le nom
	@Test
	void testFindAllPageable() {
		PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("nom").ascending());
		Page<Plat> pagePlat = platRepository.findAll(pageRequest);
		for (Plat pl : pagePlat) {
			System.out.println(pl.getNom() + " " + pl.getPrixEnCentimesEuros());
		}
	}

	// testFindById() teste le fonctionnement de la méthode
	// PlatRepository::findById.
	@Test
	void testFindById() {
		Plat plat = new Plat("Blanquette de veau", 1500);
		assertThat(platRepository.findById(4)).hasValue(plat);
	}

	// testGetOne() test à l'aide de la fonction getOne(int) qui renvoie une
	// référence à l'entité avec l'identifiant 5
	@Test
	void testGetOne() {
		Plat plat = new Plat("Moules-frites", 0);
		assertThat(platRepository.getOne(2).getNom()).isEqualTo(plat.getNom());
	}

	// testCount() teste le fonctionnement de la méthode PlatRepository::count.
	@Test
	void testCount() {
		assertThat(platRepository.count()).isEqualTo(6);
	}

	// teste le fonctionnement d’une méthode (à créer) de l’interface PlatRepository
	// qui permet de rechercher des plats par prix.
	@Test
	void testFindByPrix() {
		Plat plat = new Plat("Gigot d''agneau", 0);
		assertThat(platRepository.findByPrixEnCentimesEuros(2500).contains(plat));
	}

	@Test
	void testAvgPrix() {
		assertThat(platRepository.avgPrix(1300)).isEqualTo(1866);

	}
}
