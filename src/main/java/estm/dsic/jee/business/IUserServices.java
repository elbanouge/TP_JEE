package estm.dsic.jee.business;

import estm.dsic.jee.dal.User;

public interface IUserServices {
	public User auth(User u);
	
	public boolean save(User u);
}
