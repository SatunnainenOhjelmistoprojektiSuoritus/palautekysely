package fi.sos.bean;

public class Kysely {

	private int kysely_id, id, vastaus_id;
	private String kysely_nimi, kysely_kysymys, vastaus_tyyppi, vastaus;
	public Kysely(int kysely_id, int id, int vastaus_id, String kysely_nimi,
			String kysely_kysymys, String vastaus_tyyppi, String vastaus) {
		super();
		this.kysely_id = kysely_id;
		this.id = id;
		this.vastaus_id = vastaus_id;
		this.kysely_nimi = kysely_nimi;
		this.kysely_kysymys = kysely_kysymys;
		this.vastaus_tyyppi = vastaus_tyyppi;
		this.vastaus = vastaus;
	}
	public Kysely() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getKysely_id() {
		return kysely_id;
	}
	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVastaus_id() {
		return vastaus_id;
	}
	public void setVastaus_id(int vastaus_id) {
		this.vastaus_id = vastaus_id;
	}
	public String getKysely_nimi() {
		return kysely_nimi;
	}
	public void setKysely_nimi(String kysely_nimi) {
		this.kysely_nimi = kysely_nimi;
	}
	public String getKysely_kysymys() {
		return kysely_kysymys;
	}
	public void setKysely_kysymys(String kysely_kysymys) {
		this.kysely_kysymys = kysely_kysymys;
	}
	public String getVastaus_tyyppi() {
		return vastaus_tyyppi;
	}
	public void setVastaus_tyyppi(String vastaus_tyyppi) {
		this.vastaus_tyyppi = vastaus_tyyppi;
	}
	public String getVastaus() {
		return vastaus;
	}
	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}
	@Override
	public String toString() {
		return "Kysely [kysely_id=" + kysely_id + ", id=" + id
				+ ", vastaus_id=" + vastaus_id + ", kysely_nimi=" + kysely_nimi
				+ ", kysely_kysymys=" + kysely_kysymys + ", vastaus_tyyppi="
				+ vastaus_tyyppi + ", vastaus=" + vastaus + "]";
	}
	
	

}
