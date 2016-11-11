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


	public List<Vastaus> haeVastaus(int kysymys_id) {

		String sql = "";
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		List<Vastaus> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
}
