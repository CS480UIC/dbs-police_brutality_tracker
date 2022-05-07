package infractions.dao;

import java.sql.Connection;
import java.sql.Date;
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
	
	public IEntity findByID(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		IEntity entity1 = new IEntity();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
		    String sql = "select * from infractions where infractions_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println(id);
		    preparestatement.setInt(1,Integer.parseInt(id));
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String resultID = resultSet.getString("infractions_id");
		    	if(resultID.equals(id)){
		    		entity1.setInfractionID(resultSet.getString("infractions_id"));
		    		entity1.setInfractionDate(resultSet.getString("date"));
		    		entity1.setInfractionOfficer(resultSet.getString("officer_involved"));
		    		entity1.setInfractionForce(resultSet.getString("force_type"));
		    		entity1.setInfractionVictim(resultSet.getString("victim"));
		    		entity1.setInfractionReporter(resultSet.getString("reported_by"));
		    		entity1.setInfractionLocation(resultSet.getString("location"));
		    		entity1.setInfractionDesc(resultSet.getString("description"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return entity1;
	}
	
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
			
			String sql = "insert into infractions values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(form.getInfractionID()));
		    preparestatement.setDate(2,Date.valueOf(form.getInfractionDate()));
		    preparestatement.setInt(3,Integer.parseInt(form.getInfractionOfficer()));
		    preparestatement.setInt(4,Integer.parseInt(form.getInfractionForce()));
		    preparestatement.setInt(5,Integer.parseInt(form.getInfractionVictim()));
		    preparestatement.setInt(6,Integer.parseInt(form.getInfractionReporter()));
		    preparestatement.setString(7,form.getInfractionLocation());
		    preparestatement.setString(8,form.getInfractionDesc());
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
			
			String sql = "UPDATE infractions SET date = ?, officer_involved = ?, force_type = ?, victim = ?,"
					+ " reported_by = ?, location = ?, description = ? where infractions_id = ?";
			System.out.println(form.getInfractionDate());
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(8,Integer.parseInt(form.getInfractionID()));
		    preparestatement.setDate(1,Date.valueOf(form.getInfractionDate()));
		    preparestatement.setInt(2,Integer.parseInt(form.getInfractionOfficer()));
		    preparestatement.setInt(3,Integer.parseInt(form.getInfractionForce()));
		    preparestatement.setInt(4,Integer.parseInt(form.getInfractionVictim()));
		    preparestatement.setInt(5,Integer.parseInt(form.getInfractionReporter()));
		    preparestatement.setString(6,form.getInfractionLocation());
		    preparestatement.setString(7,form.getInfractionDesc());
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
			
			String sql = "delete from infractions where infractions_id = ?";
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
			String sql = "SELECT COUNT(*) "
					+ "FROM infractions "
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
			String sql = "SELECT force_type "
					+ "FROM infractions "
					+ "GROUP BY force_type "
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
			String sql = "SELECT * "
					+ "FROM infractions "
					+ "WHERE EXISTS "
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
			String sql = "SELECT COUNT(*) "
					+ "FROM ( "
					+ "    SELECT COUNT(*) AS NUM  "
					+ "    FROM infractions "
					+ "    GROUP BY force_type "
					+ ") "
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
