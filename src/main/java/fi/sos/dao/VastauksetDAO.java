package fi.sos.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Vastaukset;

@Repository
public class VastauksetDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Vastaukset> haeKaikkiVastaukset() {

		String sql = "select * from vastaus natural join kysymys";
		RowMapper<Vastaukset> mapper = new VastauksetRowMapper();
		List<Vastaukset> vastaukset = jdbcTemplate.query(sql, mapper);

		return vastaukset;
	}

}
