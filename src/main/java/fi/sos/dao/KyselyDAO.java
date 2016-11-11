package fi.sos.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Kysely;

@Repository
public class KyselyDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Kysely> haeKysely(int kysely_id) {

		String sql = "select * from kysymys natural join kysely where kysely_id =" + kysely_id;
		RowMapper<Kysely> mapper = new KyselyRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
	
	public List<Kysely> haeKaikkiKyselyt() {

		String sql = "select * from kysely"; // where deployed = true; kun ominaisuus toiminnassa
		RowMapper<Kysely> mapper = new KyselytRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
	
	
}