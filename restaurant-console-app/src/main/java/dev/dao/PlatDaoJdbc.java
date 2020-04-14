package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.dao.jdbc.PlatRowMapper;
import dev.entite.Plat;

/**
 * @author Salaheddine EL Majdoub
 *
 */
@Repository
@Profile("jdbc")
public class PlatDaoJdbc implements IPlatDao {

	private JdbcTemplate jdbcTemplate;

	public PlatDaoJdbc(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public List<Plat> listerPlats() {
		return this.jdbcTemplate.query("select * from `plat`", new PlatRowMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		this.jdbcTemplate.update("insert into `plat` (`nom`, `prix`) values (?, ?)", nomPlat, prixPlat);
	}

}
