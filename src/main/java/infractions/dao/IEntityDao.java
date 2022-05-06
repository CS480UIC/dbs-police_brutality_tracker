package infractions.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import infractions.domain.IEntity;
import victims.domain.VEntity;

/**
 * DDL functions performed in database
 */
public class IEntityDao {
	
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
	
	public void add(IEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "insert into entity1 values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUsername());
		    preparestatement.setString(2,form.getPassword());
		    preparestatement.setString(3,form.getEmail());
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
	public void update(IEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getPassword());
			preparestatement.setString(2,form.getEmail());
		    preparestatement.setString(3,form.getUsername());
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
			
			String sql = "delete from infractions where infraction_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> q4() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT COUNT(*)\n"
					+ "FROM infractions\n"
					+ "WHERE (date = CURDATE())";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				IEntity user = new IEntity();
				user.setInfractionCount(resultSet.getString("COUNT(*)"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> q5() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT force_type\n"
					+ "FROM infractions\n"
					+ "GROUP BY force_type\n"
					+ "HAVING COUNT(*) > 3";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				IEntity user = new IEntity();
				user.setInfractionForce(resultSet.getString("force_type"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> q6() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT *\n"
					+ "FROM infractions\n"
					+ "WHERE EXISTS\n"
					+ "(SELECT victim_id FROM victims WHERE address IS NOT NULL)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				IEntity user = new IEntity();
				user.setInfractionID(resultSet.getString("infractions_id"));
	    		user.setInfractionDate(resultSet.getString("date"));
	    		user.setInfractionOfficer(resultSet.getString("officer_involved"));
	    		user.setInfractionForce(resultSet.getString("force_type"));
	    		user.setInfractionVictim(resultSet.getString("victim"));
	    		user.setInfractionReporter(resultSet.getString("reported_by"));
	    		user.setInfractionLocation(resultSet.getString("location"));
	    		user.setInfractionDesc(resultSet.getString("description"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> q8() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT COUNT(*)\n"
					+ "FROM (\n"
					+ "    SELECT COUNT(*) AS NUM \n"
					+ "    FROM infractions\n"
					+ "    GROUP BY force_type\n"
					+ ")\n"
					+ "WHERE NUM >= 2";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				IEntity user = new IEntity();
				user.setInfractionCount(resultSet.getString("COUNT(*)"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
