package fi.sos.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Omistaja;


@Repository
public class LoginDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public class LoginRowMapper implements RowMapper<Object>{

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Omistaja omistaja = new Omistaja();
			omistaja.setOmistaja_id(rs.getInt("omistaja_id"));
			omistaja.setLogin(rs.getString("omistaja_login"));
			omistaja.setPassword(rs.getString("omistaja_password"));
			return omistaja;
		}
				
	}

	public Omistaja authAccess(String login, String password) {
		
		try{
		String sql = "select omistaja_id, omistaja_login, omistaja_password from omistaja where omistaja_login = '" + login + "' AND omistaja_password ='" + password + "';";
		
		Omistaja omistaja = (Omistaja)getJdbcTemplate().queryForObject(sql, new LoginRowMapper());
				
		String userKannasta = omistaja.getLogin();
		String passwordKannasta = omistaja.getPassword();
				
		if (login.equals(userKannasta) && password.equals(passwordKannasta)){
			
			return omistaja;
		}		
		
		}catch (Exception e) {
			return null;
		}

		return null;
				
		}
	
	
}
