package estm.dsic.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class userDao {
	PreparedStatement statement;
	private Connection con;
	
	public userDao() {

		Context context;
		try {
			context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:comp/env/jdbc/gestionusers");
			con = source.getConnection();
			//System.out.println("Connection succes");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public User auth(User u) {

		User usr = null;
        
		try{
		
			String req = "SELECT * FROM user WHERE login=? AND pass=?;";
			statement = con.prepareStatement(req);
			statement.setString(1, u.getLogin());            
			statement.setString(2, u.getPass());   
            
            ResultSet rs = statement.executeQuery();


            if(rs.next()){

            	usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setLogin(rs.getString("login"));
                usr.setEmail(rs.getString("email"));
                usr.setPass(rs.getString("pass"));
            }
            
            //System.out.println(usr.getId()+"-"+usr.getLogin()+"-"+usr.getEmail()+"-"+usr.getPass());
            
        }catch(Exception e){
            e.printStackTrace();
        }

		return usr;
	}
	
    public boolean save(User user){
        boolean bool = false;
        
        try{
        	
            String req = "INSERT INTO `gestionusers`.`user` (`login`, `email`, `pass`) VALUES ( ?, ?, ?);";
           
           PreparedStatement pt = con.prepareStatement(req);
           pt.setString(1, user.getLogin());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getPass());
           
           pt.executeUpdate();
           bool = true;
           
           System.out.println(user.getLogin()+"-"+user.getEmail()+"-"+user.getPass());
        }catch(Exception e){
            e.printStackTrace();
        }
        return bool;
    }
}
