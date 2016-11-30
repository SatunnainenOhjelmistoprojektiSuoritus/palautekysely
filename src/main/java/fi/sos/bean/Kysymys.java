package fi.sos.bean;

public class Kysymys {
	
	private int kysymys_id, kysely_id;
	private String kysymys, kysymys_tyyppi;
	private boolean pakollinen;
	
	
	public Kysymys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kysymys(int kysymys_id, int kysely_id, String kysymys,
			String kysymys_tyyppi) {
		super();
		this.kysymys_id = kysymys_id;
		this.kysely_id = kysely_id;
		this.kysymys = kysymys;
		this.kysymys_tyyppi = kysymys_tyyppi;
	}
	
	public Kysymys(int kysymys_id, int kysely_id, String kysymys,
			String kysymys_tyyppi, boolean pakollinen) {
		super();
		this.kysymys_id = kysymys_id;
		this.kysely_id = kysely_id;
		this.kysymys = kysymys;
		this.kysymys_tyyppi = kysymys_tyyppi;
		this.pakollinen = pakollinen;
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
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

	public boolean isPakollinen() {
		return pakollinen;
	}

	public void setPakollinen(boolean pakollinen) {
		this.pakollinen = pakollinen;
	}

	@Override
	public String toString() {
		return "Kysymys [kysymys_id=" + kysymys_id + ", kysely_id=" + kysely_id
				+ ", kysymys=" + kysymys + ", kysymys_tyyppi=" + kysymys_tyyppi
				+ ", pakollinen=" + pakollinen + "]";
	}

}
