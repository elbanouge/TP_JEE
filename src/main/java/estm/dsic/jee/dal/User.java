package estm.dsic.jee.dal;

public class User {
	
	private int id;
	private String login;
	private String email;
	private String pass;
	
	public User() {}
	
	public String getLogin() {
		return login;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
