package estm.dsic.jee.business;

import java.util.ArrayList;

import estm.dsic.jee.dal.Contact;

public interface IContactServices {
	public boolean add(Contact contact);

	public boolean edit(Contact contact);

	public boolean delete(int id);

	public ArrayList<Contact> getAll();

	public ArrayList<Contact> ContactSearch(String parS);

	public Contact getContactByID(int id);
}
