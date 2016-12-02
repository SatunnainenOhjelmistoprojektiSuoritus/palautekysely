package fi.sos.bean;

public class Vastaus {
	
	private int vastaus_id, kysymys_id;
		
	private String vastaus;
	
	public Vastaus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vastaus(int vastaus_id, int kysymys_id, String vastaus) {
		super();
		this.vastaus_id = vastaus_id;
		this.kysymys_id = kysymys_id;
		this.vastaus = vastaus;
	}
	public int getVastaus_id() {
		return vastaus_id;
	}
	public void setVastaus_id(int vastaus_id) {
		this.vastaus_id = vastaus_id;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public String getVastaus() {
		return vastaus;
	}
	public void setVastaus(String vastaus) {
		this.vastaus = vastaus;
	}
	@Override
	public String toString() {
		return "Vastaus [vastaus_id=" + vastaus_id + ", kysymys_id="
				+ kysymys_id + ", vastaus=" + vastaus + "]";
	}
	
	

}
