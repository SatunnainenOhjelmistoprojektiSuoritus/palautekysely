package fi.sos.bean;

public class Vastaukset {
	
	private int kysymys_id;
	private int vastaus_id;
	private String vastaus;
	private int kysely_id;
	private String kysymys;
	private String kysymys_tyyppi;
	
	public Vastaukset() {
		super();
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

	public int getVastaus_id() {
		return vastaus_id;
	}

	public void setVastaus_id(int vastaus_id) {
		this.vastaus_id = vastaus_id;
	}

	public String getVastaus() {
		return vastaus;
	}

	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}

	public int getKysely_id() {
		return kysely_id;
	}

	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public String getKysymys_tyyppi() {
		return kysymys_tyyppi;
	}

	public void setKysymys_tyyppi(String kysymys_tyyppi) {
		this.kysymys_tyyppi = kysymys_tyyppi;
	}

	@Override
	public String toString() {
		return "Vastaukset [kysymys_id=" + kysymys_id + ", vastaus_id="
				+ vastaus_id + ", vastaus=" + vastaus + ", kysely_id="
				+ kysely_id + ", kysymys=" + kysymys + ", kysymys_tyyppi="
				+ kysymys_tyyppi + "]";
	}
	
	
	
	

}
