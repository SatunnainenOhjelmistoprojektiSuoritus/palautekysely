package fi.sos.bean;

public class Vastaus {

	private int vastaus_id, kysely_id;
	private String vastaus, vastaus_tyyppi;

	public Vastaus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vastaus(int vastaus_id, int kysely_id, String vastaus,
			String vastaus_tyyppi) {
		super();
		this.vastaus_id = vastaus_id;
		this.kysely_id = kysely_id;
		this.vastaus = vastaus;
		this.vastaus_tyyppi = vastaus_tyyppi;
	}

	public int getVastaus_id() {
		return vastaus_id;
	}

	public void setVastaus_id(int vastaus_id) {
		this.vastaus_id = vastaus_id;
	}

	public int getKysely_id() {
		return kysely_id;
	}

	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public String getVastaus_tyyppi() {
		return vastaus_tyyppi;
	}

	public void setVastaus_tyyppi(String vastaus_tyyppi) {
		this.vastaus_tyyppi = vastaus_tyyppi;
	}

	@Override
	public String toString() {
		return "Vastaus [vastaus_id=" + vastaus_id + ", kysely_id=" + kysely_id
				+ ", vastaus=" + vastaus + ", vastaus_tyyppi=" + vastaus_tyyppi
				+ "]";
	}

}
