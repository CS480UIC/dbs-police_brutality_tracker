package victims.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import policeofficers.domain.POEntity;

//import java.util.ArrayList;
//import java.util.List;

import victims.domain.VEntity;

/**
 * DDL functions performed in database
 */
public class VEntityDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "bookstore"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "Lokus4"; //TODO change password
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public VEntity findByID(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		VEntity entity1 = new VEntity();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
		    String sql = "select * from victims where victim_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println(id);
		    preparestatement.setInt(1,Integer.parseInt(id));
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String resultID = resultSet.getString("victim_id");
		    	if(resultID.equals(id)){
		    		entity1.setVictimID(resultSet.getString("victim_id"));
		    		entity1.setVictimName(resultSet.getString("victim_name"));
		    		entity1.setVictimEthnicity(resultSet.getString("ethnicity"));
		    		entity1.setVictimAddress(resultSet.getString("address"));
		    		entity1.setVictimGender(resultSet.getString("gender"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return entity1;
	}
	
	public void add(VEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "insert into victims values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setInt(2,Integer.parseInt(form.getVictimID()));
		    preparestatement.setString(1,form.getVictimName());
		    preparestatement.setString(3,form.getVictimEthnicity());
		    preparestatement.setString(4,form.getVictimAddress());
		    preparestatement.setString(5,form.getVictimGender());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(VEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "UPDATE victims SET victim_name = ?, ethnicity = ?,"
					+ " address = ?, gender = ? where victim_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getVictimName());
			preparestatement.setString(2,form.getVictimEthnicity());
		    preparestatement.setString(3,form.getVictimAddress());
		    preparestatement.setString(4,form.getVictimGender());
		    preparestatement.setInt(5,Integer.parseInt(form.getVictimID()));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "delete from victims where victim_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> q2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT * "
					+ "FROM victims "
					+ "WHERE (gender = 'male') "
					+ "ORDER BY victim_name";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				VEntity user = new VEntity();
				user.setVictimID(resultSet.getString("victim_id"));
	    		user.setVictimName(resultSet.getString("victim_name"));
	    		user.setVictimEthnicity(resultSet.getString("ethnicity"));
	    		user.setVictimGender(resultSet.getString("gender"));
	    		user.setVictimAddress(resultSet.getString("address"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> q3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT LOWER(address) "
					+ "FROM victims";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				VEntity user = new VEntity();
	    		user.setVictimAddress(resultSet.getString("LOWER(address)"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
