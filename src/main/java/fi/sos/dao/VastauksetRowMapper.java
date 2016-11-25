package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Vastaukset;

public class VastauksetRowMapper implements RowMapper<Vastaukset> {

	public Vastaukset mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Vastaukset v = new Vastaukset();
	
		v.setKysymys_id(rs.getInt("kysymys_id"));
		v.setVastaus_id(rs.getInt("vastaus_id"));
		v.setVastaus(rs.getString("vastaus"));
		v.setKysely_id(rs.getInt("kysely_id"));
		v.setKysymys(rs.getString("kysymys"));
		v.setKysymys_tyyppi(rs.getString("kysymys_tyyppi"));
		
		
		return v;
	}

}
