package policeofficers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import policeofficers.domain.POEntity;

/**
 * DDL functions performed in database
 */
public class POEntityDao {
	
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
	
	public POEntity findByID(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		POEntity entity1 = new POEntity();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
		    String sql = "select * from police_officers where officer_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println(id);
		    preparestatement.setInt(1,Integer.parseInt(id));
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String resultID = resultSet.getString("officer_id");
		    	if(resultID.equals(id)){
		    		entity1.setOfficerID(resultSet.getString("officer_id"));
		    		entity1.setOfficerName(resultSet.getString("officer_name"));
		    		entity1.setOfficerDepartment(resultSet.getString("department"));
		    		entity1.setOfficerRank(resultSet.getString("officer_rank"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return entity1;
	}
	
	public void add(POEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "insert into entity1 values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(form.getOfficerID()));
		    preparestatement.setString(2,form.getOfficerName());
		    preparestatement.setString(3,form.getOfficerDepartment());
		    preparestatement.setString(4,form.getOfficerRank());
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
	public void update(POEntity form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			
			String sql = "UPDATE police_officers SET officer_name = ?, department = ?, officer_rank = ? where officer_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getOfficerName());
		    preparestatement.setString(2,form.getOfficerDepartment());
		    preparestatement.setString(3,form.getOfficerRank());
		    preparestatement.setInt(4,Integer.parseInt(form.getOfficerID()));
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
			
			String sql = "delete from police_officers where officer_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(id));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> q1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/policebrutalitydatabase", MySQL_user, MySQL_password);
			String sql = "SELECT * "
					+ "FROM police_officers "
					+ "WHERE (department = 'Chicago') "
					+ "ORDER BY officer_rank";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				POEntity user = new POEntity();
				user.setOfficerID(resultSet.getString("officer_id"));
	    		user.setOfficerName(resultSet.getString("officer_name"));
	    		user.setOfficerDepartment(resultSet.getString("department"));
	    		user.setOfficerRank(resultSet.getString("officer_rank"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
