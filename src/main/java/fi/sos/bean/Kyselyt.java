package fi.sos.bean;

public class Kyselyt {

	private int kysely_id;
	private String kysely_nimi;
	private boolean deployed;
	private String kysely_kuvaus;
	private int omistaja_id;

	public Kyselyt() {
		super();
	}

	public Kyselyt(int kysely_id, String kysely_nimi, boolean deployed,
			String kysely_kuvaus, int omistaja_id) {
		super();
		this.kysely_id = kysely_id;
		this.kysely_nimi = kysely_nimi;
		this.deployed = deployed;
		this.kysely_kuvaus = kysely_kuvaus;
		this.omistaja_id = omistaja_id;
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

	public String getKysely_kuvaus() {
		return kysely_kuvaus;
	}

	public void setKysely_kuvaus(String kysely_kuvaus) {
		this.kysely_kuvaus = kysely_kuvaus;
	}

	public int getOmistaja_id() {
		return omistaja_id;
	}

	public void setOmistaja_id(int omistaja_id) {
		this.omistaja_id = omistaja_id;
	}

	@Override
	public String toString() {
		return "Kyselyt [kysely_id=" + kysely_id + ", kysely_nimi="
				+ kysely_nimi + ", deployed=" + deployed + ", kysely_kuvaus="
				+ kysely_kuvaus + ", omistaja_id=" + omistaja_id + "]";
	}

}
