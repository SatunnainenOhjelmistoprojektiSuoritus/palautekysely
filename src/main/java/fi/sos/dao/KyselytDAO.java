package fi.sos.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Kyselyt;

@Repository
public class KyselytDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public List<Kyselyt> haeKaikkiKyselyt() {

		String sql = "select * from kysely where is_deleted = false"; // where deployed = true; kun ominaisuus toiminnassa
		RowMapper<Kyselyt> mapper = new KyselytRowMapper();
		List<Kyselyt> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
	
	public List<Kyselyt> haeKaikkiDeployedKyselyt() {

		String sql = "select * from kysely where kysely_deployed = true AND is_deleted = false";
		RowMapper<Kyselyt> mapper = new KyselytRowMapper();
		List<Kyselyt> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
	
	public List<Kyselyt> haeKaikkiUnDeployedKyselyt() {

		String sql = "select * from kysely where kysely_deployed = false AND is_deleted = false";
		RowMapper<Kyselyt> mapper = new KyselytRowMapper();
		List<Kyselyt> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
	
	public void UndeployKysely(int id) {
		
		String sql = "UPDATE kysely SET kysely_deployed = false where kysely_id =" + id;
		jdbcTemplate.execute(sql);
		
	}
	
	public void deployKysely(int id) {
		
		String sql = "UPDATE kysely SET kysely_deployed = true where kysely_id =" + id;
		jdbcTemplate.execute(sql);
		
	}
	
	
}
