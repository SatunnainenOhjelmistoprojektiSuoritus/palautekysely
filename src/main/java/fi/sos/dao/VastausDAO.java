package fi.sos.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Vastaus;

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

	

	public List<Vastaus> haeVastauksetKysymykseen(int kysymys_id) {

		String sql = "select * from vastaus where kysely_id =" + kysymys_id;
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(sql, mapper);
		
		return vastaukset;
	}
}
