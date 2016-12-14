package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Omistaja;

public class LoginRowMapper implements RowMapper<Omistaja>{

	public Omistaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Omistaja omistaja = new Omistaja();
		omistaja.setOmistaja_id(rs.getInt("omistaja_id"));
		omistaja.setLogin(rs.getString("omistaja_login"));
		omistaja.setPassword(rs.getString("omistaja_password"));
		omistaja.setSalt(rs.getString("omistaja_salt"));
		return omistaja;
	}
			
}
