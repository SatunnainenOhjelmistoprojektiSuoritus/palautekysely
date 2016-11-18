package fi.sos.bean;

public class Omistaja {
	
	private int omistaja_id;
	private String omistaja_login;
	private String omistaja_password;
	
	public Omistaja() {
		super();
	}

	public Omistaja(int omistaja_id, String omistaja_login,
			String omistaja_password) {
		super();
		this.omistaja_id = omistaja_id;
		this.omistaja_login = omistaja_login;
		this.omistaja_password = omistaja_password;
	}

	public int getOmistaja_id() {
		return omistaja_id;
	}

	public void setOmistaja_id(int omistaja_id) {
		this.omistaja_id = omistaja_id;
	}

	public String getOmistaja_login() {
		return omistaja_login;
	}

	public void setOmistaja_login(String omistaja_login) {
		this.omistaja_login = omistaja_login;
	}

	public String getOmistaja_password() {
		return omistaja_password;
	}

	public void setOmistaja_password(String omistaja_password) {
		this.omistaja_password = omistaja_password;
	}

	@Override
	public String toString() {
		return "Omistaja [omistaja_id=" + omistaja_id + ", omistaja_login="
				+ omistaja_login + ", omistaja_password=" + omistaja_password
				+ "]";
	}
	
	
	
	

}
