package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Kysely;


public class KyselyRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kysely k = new Kysely();
		k.setId(rs.getInt("id"));
		k.setKysymys(rs.getString("kysymys"));
		k.setMonivastaus(rs.getInt("monivastaus"));
		k.setAvoin(rs.getString("avoin"));
						
		return k;
	}

}
