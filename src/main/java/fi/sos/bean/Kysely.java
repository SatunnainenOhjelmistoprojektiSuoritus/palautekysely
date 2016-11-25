package fi.sos.bean;

public class Kysely {

	private int kysely_id;
	private String kysely_nimi;
	private boolean deployed;
	private String kuvaus;
	private int omistaja_id;
	private Kysymys kysymys;

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	public Kysely() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kysely(int kysely_id, String kysely_nimi, boolean deployed,
			Kysymys kysymys) {
		super();
		this.kysely_id = kysely_id;
		this.kysely_nimi = kysely_nimi;
		this.deployed = deployed;
		this.kysymys = kysymys;
	}

	public Kysely(int kysely_id, String kysely_nimi, boolean deployed,
			String kuvaus, Kysymys kysymys) {
		super();
		this.kysely_id = kysely_id;
		this.kysely_nimi = kysely_nimi;
		this.deployed = deployed;
		this.kuvaus = kuvaus;
		this.kysymys = kysymys;
	}
	
	public Kysely(int kysely_id, String kysely_nimi, boolean deployed,
			String kuvaus, int omistaja_id, Kysymys kysymys) {
		super();
		this.kysely_id = kysely_id;
		this.kysely_nimi = kysely_nimi;
		this.deployed = deployed;
		this.kuvaus = kuvaus;
		this.omistaja_id = omistaja_id;
		this.kysymys = kysymys;
	}

	public int getKysely_id() {
		return kysely_id;
	}

	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
	}

	public String getKysely_nimi() {
		return kysely_nimi;
	}

	public void setKysely_nimi(String kysely_nimi) {
		this.kysely_nimi = kysely_nimi;
	}

	public boolean isDeployed() {
		return deployed;
	}

	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	
	public int getOmistaja_id() {
		return omistaja_id;
	}

	public void setOmistaja_id(int omistaja_id) {
		this.omistaja_id = omistaja_id;
	}

	@Override
	public String toString() {
		return "Kysely [kysely_id=" + kysely_id + ", kysely_nimi="
				+ kysely_nimi + ", deployed=" + deployed + ", kuvaus=" + kuvaus
				+ ", omistaja_id=" + omistaja_id + ", kysymys=" + kysymys + "]";
	}

	

}
