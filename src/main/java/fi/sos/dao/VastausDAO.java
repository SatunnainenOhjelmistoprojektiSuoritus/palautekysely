package fi.sos.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Vastaukset;

@Repository
public class VastausDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Vastaukset> haeVastaukset(int kysely_id) {

		String sql = "select * from vastaus natural join kysymys where kysely_id = " + kysely_id + ";";
		RowMapper<Vastaukset> mapper = new VastauksetRowMapper();
		List<Vastaukset> vastaukset = jdbcTemplate.query(sql, mapper);

		return vastaukset;
	}
	
	public void lisaaVastaus(int kysymys_id, String vastaus){		
		
		String sql = "INSERT INTO vastaus (kysymys_id, vastaus) values ('" + kysymys_id + "', '" + vastaus + "');";
		System.out.println(sql);
		jdbcTemplate.execute(sql);
	}
	
}
