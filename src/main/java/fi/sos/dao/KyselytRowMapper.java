package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Kyselyt;

public class KyselytRowMapper implements RowMapper<Kyselyt> {

	public Kyselyt mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kyselyt k = new Kyselyt();
		
		k.setKysely_id(rs.getInt("kysely_id"));
		k.setKysely_nimi(rs.getString("kysely_nimi"));		
		k.setDeployed(rs.getBoolean("kysely_deployed"));
		k.setKysely_kuvaus(rs.getString("kysely_kuvaus"));
		k.setOmistaja_id(rs.getInt("omistaja_id"));
		k.setSurveyID(rs.getString("surveyID"));
		
		return k;
	}
	
}