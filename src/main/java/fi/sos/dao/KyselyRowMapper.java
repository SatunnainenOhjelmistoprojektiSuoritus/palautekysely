package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Kysely;

public class KyselyRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kysely k = new Kysely();
		
		k.setId(rs.getInt("id"));
		k.setKysely_id(rs.getInt("kysely_id"));
		k.setVastaus_id(rs.getInt("vastaus_id"));
		k.setKysely_nimi(rs.getString("kysely_nimi"));
		k.setKysely_kysymys(rs.getString("kysely_kysymys"));
		k.setVastaus(rs.getString("vastaus"));
		k.setVastaus_tyyppi(rs.getString("vastaus_tyyppi"));		
		
		return k;
	}

}
