package policeofficers.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class POEntity {
	/*
	 * Correspond to the user table
	 */
	
	private String officer_id;
	private String officer_name;
	private String department;
	private String officer_rank;
	
	
	public String getOfficerID() {
		return officer_id;
	}

	public void setOfficerID(String entry) {
		this.officer_id = entry;
	}
	
	public String getOfficerName() {
		return officer_name;
	}

	public void setOfficerName(String entry) {
		this.officer_name = entry;
	}
	
	public String getOfficerDepartment() {
		return department;
	}

	public void setOfficerDepartment(String entry) {
		this.department = entry;
	}
	
	public String getOfficerRank() {
		return officer_rank;
	}

	public void setOfficerRank(String entry) {
		this.officer_rank = entry;
	}
	
	@Override
	public String toString() {
		return "Officer [ "
				+ "ID =" + officer_id 
				+ ", Name =" + officer_name 
				+ ", Department =" + department 
				+", Rank =" + officer_rank
				+"]";
	}
}
