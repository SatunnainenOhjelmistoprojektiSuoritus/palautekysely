package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Kysymys;

public class KysymysRowMapper implements RowMapper<Kysymys> {

	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kysymys k = new Kysymys();
		
		k.setKysely_id(rs.getInt("kysely_id"));
		k.setKysymys_id(rs.getInt("kysymys_id"));
		k.setKysymys(rs.getString("kysymys"));
		k.setKysymys_tyyppi("kysymys_tyyppi");
		k.setKysymys_info(rs.getString("kysymys_info"));
		
		return k;
	}

}