package estm.dsic.jee.business;

import estm.dsic.jee.dal.User;
import estm.dsic.jee.dal.userDao;

public class UserServices implements IUserServices {
	
	userDao dao;
	
	public UserServices() {
		dao = new userDao();
	}


	@Override
	public boolean save(User u) {
		// TODO Auto-generated method stub
		return dao.save(u);
	}

	@Override
	public User auth(User u) {
		// TODO Auto-generated method stub		
		return dao.auth(u);
	}
	
}
