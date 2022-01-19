package estm.dsic.jee.business;

import java.util.ArrayList;

import estm.dsic.jee.dal.Contact;
import estm.dsic.jee.dal.contactDao;

public class ContactServices implements IContactServices {

	contactDao contactDao;

	public ContactServices() {
		contactDao = new contactDao();
	}

	@Override
	public boolean add(Contact contact) {
		// TODO Auto-generated method stub
		return contactDao.addCon(contact);
	}

	@Override
	public ArrayList<Contact> getAll() {
		// TODO Auto-generated method stub
		return contactDao.getContacts(null);
	}

	@Override
	public Contact getContactByID(int id) {
		// TODO Auto-generated method stub
		return contactDao.getContactByID(id);
	}

	@Override
	public boolean edit(Contact contact) {
		// TODO Auto-generated method stub
		return contactDao.modCon(contact);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return contactDao.delCon(id);
	}

	@Override
	public ArrayList<Contact> ContactSearch(String parS) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM `gestionusers`.`contacts` WHERE `nameCon` LIKE '%" + parS + "%'"
				+ " OR `adresseCon` LIKE '%" + parS + "%' OR `emailCon`" + " LIKE '%" + parS + "%' OR `telCon` LIKE '%"
				+ parS + "%';";
		return contactDao.getContacts(req);
	}

}
