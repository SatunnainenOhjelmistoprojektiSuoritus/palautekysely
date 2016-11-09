package fi.sos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	/**
	 * Tallettaa parametrina annetun henkil??n tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */

	/*
	 * public void talleta(Henkilo h) { final String sql =
	 * "insert into henkilo2(etunimi, sukunimi, sahkoposti, lahiosoite, postinumero, postitoimipaikka) values(?,?,?,?,?,?)"
	 * ;
	 * 
	 * //anonyymi sis??luokka tarvitsee vakioina v??litett??v??t arvot, //jotta
	 * roskien keruu onnistuu t??m??n metodin suorituksen p????ttyess??. final
	 * String etunimi = h.getEtunimi(); final String sukunimi = h.getSukunimi();
	 * final String sahkoposti = h.getSahkoposti(); final String lahiosoite =
	 * h.getLahiosoite(); final String postinumero = h.getPostinumero(); final
	 * String postitoimipaikka = h.getPostitoimipaikka();
	 * 
	 * //jdbc pist???? generoidun id:n t??nne talteen KeyHolder idHolder = new
	 * GeneratedKeyHolder();
	 * 
	 * //suoritetaan p??ivitys itse m????ritellyll??
	 * PreparedStatementCreatorilla ja KeyHolderilla jdbcTemplate.update( new
	 * PreparedStatementCreator() { public PreparedStatement
	 * createPreparedStatement(Connection connection) throws SQLException {
	 * PreparedStatement ps = connection.prepareStatement(sql, new String[]
	 * {"id"}); ps.setString(1, etunimi); ps.setString(2, sukunimi);
	 * ps.setString(3, sahkoposti); ps.setString(4, lahiosoite); ps.setString(5,
	 * postinumero); ps.setString(6, postitoimipaikka); return ps; } },
	 * idHolder);
	 * 
	 * //tallennetaan id takaisin beaniin, koska //kutsujalla pit??isi olla
	 * viittaus samaiseen olioon h.setId(idHolder.getKey().intValue());
	 * 
	 * }
	 * 
	 * 
	 * public Henkilo etsi(int id) { String sql =
	 * "select etunimi, sukunimi, id, sahkoposti, lahiosoite, postinumero, postitoimipaikka from henkilo2 where id = ?"
	 * ; Object[] parametrit = new Object[] { id }; RowMapper<Henkilo> mapper =
	 * new HenkiloRowMapper();
	 * 
	 * Henkilo h; try { h = jdbcTemplate.queryForObject(sql , parametrit,
	 * mapper); } catch(IncorrectResultSizeDataAccessException e) { throw new
	 * HenkiloaEiLoydyPoikkeus(e); } return h;
	 * 
	 * 
	 * }
	 */

	public List<Kysely> haeKysymys(int kysymys_id) {

		String sql = "select k.kysely_id, k.id, v.vastaus_id, k.kysely_nimi, k.kysely_kysymys, v.vastaus_tyyppi, v.vastaus from kysely k JOIN vastaus v on k.id=v.vastaus_id where k.kysely_id =" + kysymys_id;
		RowMapper<Kysely> mapper = new KyselyRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(sql, mapper);

		return kyselyt;
	}
}