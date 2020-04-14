package dev.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.entite.Plat;

/**
 * @author Salaheddine EL Majdoub
 *
 */
public class PlatRowMapper implements RowMapper<Plat> {

	@Override
	public Plat mapRow(ResultSet rs, int rowNum) throws SQLException {

		Plat plat = new Plat(rs.getString("nom"), rs.getInt("prix"));

		return plat;
	}
}