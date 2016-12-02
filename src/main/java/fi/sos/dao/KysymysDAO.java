package fi.sos.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.sos.bean.Kysymys;

@Repository
public class KysymysDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Kysymys> haeKysymys(int kysymys_id) {

		String sql = "";
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
	
	public void lisaaKysymys(int kysely_id, String kysymys, String kysymys_tyyppi) {

		String sql = "INSERT INTO kysymys (kysely_id, Kysymys, Kysymys_tyyppi) VALUES ('" + kysely_id + "', '" + kysymys + "', '" + kysymys_tyyppi + "');";
		jdbcTemplate.execute(sql);
	}
	
	//VAROKAA EPUN KOODIA
	public void pakollinen(int id) {
		
		String sql = "UPDATE kysymys SET pakollinen = true where kysymys_id =" + id;
		jdbcTemplate.execute(sql);
		
	}
	
	public void vapaaehtoinen(int id) {
		
		String sql = "UPDATE kysymys SET pakollinen = false where kysymys_id =" + id;
		jdbcTemplate.execute(sql);
		
	}
	
	public void deleteKysymys(int id){
		
		String sql = "UPDATE kysymys SET is_deleted = true where kysymys_id =" + id;
		jdbcTemplate.execute(sql);
	}
	
	
}