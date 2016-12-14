package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Kysely;

public class SurveyIDRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kysely k = new Kysely();
		
		k.setKysely_id(rs.getInt("kysely_id"));
	
		return k;
	}
	
}
