package fi.sos.bean;

public class Kysely {

	private int id, monivastaus;
	private String kysymys, avoin;
	public Kysely(int id, int monivastaus, String kysymys, String avoin) {
		super();
		this.id = id;
		this.monivastaus = monivastaus;
		this.kysymys = kysymys;
		this.avoin = avoin;
	}
	public Kysely() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMonivastaus() {
		return monivastaus;
	}
	public void setMonivastaus(int monivastaus) {
		this.monivastaus = monivastaus;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public String getAvoin() {
		return avoin;
	}
	public void setAvoin(String avoin) {
		this.avoin = avoin;
	}
	@Override
	public String toString() {
		return "Kysely [id=" + id + ", monivastaus=" + monivastaus
				+ ", kysymys=" + kysymys + ", avoin=" + avoin + "]";
	}

	
	
}
