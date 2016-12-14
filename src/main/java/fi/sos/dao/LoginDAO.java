package fi.sos.dao;


import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Kyselyt;
import fi.sos.bean.Omistaja;
import fi.sos.security.Salaaja;


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
	


	public Omistaja authAccess(String login, String password, String salt) {
		
		Salaaja s = new Salaaja();
		
		try{
			
		String salattu = s.salaa(password, salt , Salaaja.SHA512, 10);	
			
		String sql = "select omistaja_id, omistaja_login, omistaja_password, omistaja_salt from omistaja where omistaja_login = '" + login + "' AND omistaja_password ='" + salattu + "';";
			
		Omistaja omistaja = (Omistaja)getJdbcTemplate().queryForObject(sql, new LoginRowMapper());
		
		System.out.println("SALATTU: " + salattu);
		
		
		String userKannasta = omistaja.getLogin();
		String passwordKannasta = omistaja.getPassword();
	
		System.out.println("DAO OMISTAJA: " + omistaja );
		
		
		
		if (login.equals(userKannasta) && password.equals(salattu)){
			
			return omistaja;
		}		
		
		}catch (Exception e) {
			return null;
		}

		return null;
				
		}
	
	public List<Omistaja> fetchAllUsers() {

		String sql = "select * from omistaja";
		RowMapper<Omistaja> mapper = new LoginRowMapper();
		List<Omistaja> kayttajat = jdbcTemplate.query(sql, mapper);

		return kayttajat;
	}
	
	public Omistaja addUser(Omistaja o){
		
		String sql = "INSERT INTO omistaja (omistaja_login, omistaja_password, omistaja_salt) values ('" + o.getLogin() + "', '" + o.getPassword() + "', '" + o.getSalt() + "')";		
		jdbcTemplate.execute(sql);
				
		return null;
	}
	
	public List<Omistaja> getSalty(String username){
		
		String sql = "select * from omistaja where omistaja_login = '" +username + "'";
		RowMapper<Omistaja> mapper = new LoginRowMapper();		
		List<Omistaja> salt = jdbcTemplate.query(sql, mapper);
		
		return salt;
		
	}
	
}
