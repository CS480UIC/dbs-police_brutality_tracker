package victims.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class VEntity {
	/*
	 * Correspond to the user table
	 */
	
	private String victim_id;
	private String victim_name;
	private String ethnicity;
	private String gender;
	private String address;
	
	public String getVictimID() {
		return victim_id;
	}

	public void setVictimID(String entry) {
		this.victim_id = entry;
	}
	
	public String getVictimName() {
		return victim_name;
	}

	public void setVictimName(String entry) {
		this.victim_name = entry;
	}
	
	public String getVictimEthnicity() {
		return ethnicity;
	}

	public void setVictimEthnicity(String entry) {
		this.ethnicity = entry;
	}
	
	public String getVictimGender() {
		return gender;
	}

	public void setVictimGender(String entry) {
		this.gender = entry;
	}
	
	public String getVictimAddress() {
		return address;
	}

	public void setVictimAddress(String entry) {
		this.address = entry;
	}
	
	@Override
	public String toString() {
		return "Victim [ "
				+ "ID =" + victim_id 
				+ ", Name =" + victim_name 
				+ ", Ethnicity =" + ethnicity 
				+", Gender =" + gender
				+", Address =" + address
				+"]";
	}
}
