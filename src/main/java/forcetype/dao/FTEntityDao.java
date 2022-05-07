package forcetype.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import forcetype.domain.FTEntity;

/**
 * DDL functions performed in database
 */
public class FTEntityDao {
	
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
	
	public FTEntity findByID(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		FTEntity entity1 = new FTEntity();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
		    String sql = "select * from force_type where force_id =?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println(id);
		    preparestatement.setInt(1,Integer.parseInt(id));
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String resultID = resultSet.getString("force_id");
		    	if(resultID.equals(id)){
		    		entity1.setForceID(resultSet.getString("force_id"));
		    		entity1.setForceUsed(resultSet.getString("force_used"));
		    		entity1.setForceDesc(resultSet.getString("description"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return entity1;
	}
	
	public void add(FTEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "insert into force_type values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(form.getForceID()));
		    preparestatement.setString(2,form.getForceUsed());
		    preparestatement.setString(3,form.getForceDesc());
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
	public void update(FTEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "UPDATE force_type SET force_used = ?, description = ? where force_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getForceUsed());
			preparestatement.setString(2,form.getForceDesc());
		    preparestatement.setInt(3,Integer.parseInt(form.getForceID()));
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
			
			String sql = "delete from force_type where force_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
