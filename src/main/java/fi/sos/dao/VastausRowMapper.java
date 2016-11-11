package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Vastaus;

public class VastausRowMapper implements RowMapper<Vastaus> {

	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Vastaus v = new Vastaus();
		
		v.setKysymys_id(rs.getInt("kysymys_id"));
		v.setVastaus_id(rs.getInt("vastaus_id"));
		v.setVastaus(rs.getString("vastaus"));
		
		
		return v;
	}

}
