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
	
	public void lisaaKysely(String kysely_nimi, String kuvaus, int omistaja_id) {

		String sql = "INSERT INTO kysely (kysely_nimi, kysely_kuvaus, omistaja_id) VALUES ('" + kysely_nimi + "', '" + kuvaus + "', '" + omistaja_id + "');";
		jdbcTemplate.execute(sql);
	}
	
	
}