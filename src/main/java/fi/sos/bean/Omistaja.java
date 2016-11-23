package fi.sos.bean;

public class Omistaja {
	
	private int omistaja_id;
	private String login;
	private String password;
	
	public Omistaja() {
		super();
	}

	public Omistaja(int omistaja_id, String login, String password) {
		super();
		this.omistaja_id = omistaja_id;
		this.login = login;
		this.password = password;
	}

	public int getOmistaja_id() {
		return omistaja_id;
	}

	public void setOmistaja_id(int omistaja_id) {
		this.omistaja_id = omistaja_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Omistaja [omistaja_id=" + omistaja_id + ", login=" + login
				+ ", password=" + password + "]";
	}


	
	

}
