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
			omistaja.setOmistaja_login(rs.getString("omistaja_login"));
			omistaja.setOmistaja_password(rs.getString("omistaja_password"));
			return omistaja;
		}
		
		
	}

	public boolean authAccess(String login, String password) {
		
		boolean checkLogin = false;
		
		try{
		String sql = "select omistaja_login, omistaja_password from omistaja where omistaja_login = '" + login + "' AND omistaja_password ='" + password + "';";
		
		Omistaja omistaja = (Omistaja)getJdbcTemplate().queryForObject(sql, new LoginRowMapper());
		
		
		String userKannasta = omistaja.getOmistaja_login();
		String passwordKannasta = omistaja.getOmistaja_password();
		
		if (login.equals(userKannasta) && password.equals(passwordKannasta)){
			
			checkLogin = true;
		}
		}catch (Exception e){
			e.printStackTrace();
			checkLogin = false;
		}
		
		return checkLogin;
	}
	
	
}
