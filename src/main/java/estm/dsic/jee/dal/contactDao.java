package estm.dsic.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class contactDao {
	private Connection con;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

	public contactDao() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/gestionusers");
			con = dataSource.getConnection();
			System.out.println("Connection succes");

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean addCon(Contact contact) {
		boolean bool = false;

		String req = "INSERT INTO `gestionusers`.`contacts` (`nameCon`, `adresseCon`, `emailCon`, `telCon`) VALUES (?, ?, ?, ?);";
		try {

			ps = con.prepareStatement(req);
			ps.setString(1, contact.getNom());
			ps.setString(2, contact.getAdresse());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getTel());

			if (ps.executeUpdate() >= 1) {
				bool = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bool;
	}

	public boolean modCon(Contact contact) {
		boolean bool = false;

		String req = "UPDATE `gestionusers`.`contacts` SET `nameCon`=?, `adresseCon`=?, `emailCon`=?, `telCon`=? WHERE  `id_contact`=?;";
		try {

			ps = con.prepareStatement(req);
			ps.setString(1, contact.getNom());
			ps.setString(2, contact.getAdresse());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getTel());
			ps.setInt(5, contact.getIdC());

			if (ps.executeUpdate() >= 1) {
				bool = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bool;
	}

	public boolean delCon(int idCon) {
		boolean bool = false;

		String req = "DELETE FROM `gestionusers`.`contacts` WHERE  `id_contact`=?;";
		try {

			ps = con.prepareStatement(req);
			ps.setInt(1, idCon);

			if (ps.executeUpdate() >= 1) {
				bool = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bool;
	}

	public ArrayList<Contact> getContacts(String reqS) {
		ArrayList<Contact> arrayList = new ArrayList<Contact>();
		String req = "SELECT * FROM `gestionusers`.`contacts`";

		if(reqS != null) {
			req = reqS;
		}
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(req);

			while (rs.next()) {
				Contact contact = new Contact(rs.getInt("id_contact"), rs.getString("nameCon"),
						rs.getString("adresseCon"), rs.getString("emailCon"), rs.getString("telCon"));
				arrayList.add(contact);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	public Contact getContactByID(int idCon) {
		Contact contact = null;
		String req = "SELECT * FROM `gestionusers`.`contacts` WHERE `id_contact` =" + idCon + ";";
		try {
			st = con.createStatement();
			rs = st.executeQuery(req);

			while (rs.next()) {
				contact = new Contact(rs.getInt("id_contact"), rs.getString("nameCon"), rs.getString("adresseCon"),
						rs.getString("emailCon"), rs.getString("telCon"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}
}
