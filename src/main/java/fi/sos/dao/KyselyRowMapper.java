package fi.sos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.sos.bean.Kysely;
import fi.sos.bean.Kysymys;

public class KyselyRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kysely k = new Kysely();
		
		k.setKysely_id(rs.getInt("kysely_id"));
		k.setKysely_nimi(rs.getString("kysely_nimi"));
		
		k.setDeployed(rs.getBoolean("kysely_deployed"));
		
		//Kysymys olio
		Kysymys ky = new Kysymys();
		ky.setKysymys(rs.getString("kysymys"));
		ky.setKysely_id(rs.getInt("kysely_id"));
		ky.setKysymys_tyyppi(rs.getString("kysymys_tyyppi"));
		ky.setKysymys_id(rs.getInt("kysymys_id"));		
		k.setKysymys(ky);
		
		
		return k;
	}
	
}
