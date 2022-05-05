package infractions.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class IEntity {
	/*
	 * Correspond to the user table
	 */
	
	private String infractions_id;
	private String date;
	private String officer_involved;
	private String force_type;
	private String victim;
	private String reported_by;
	private String location;
	private String description;
	private String count;
	
	public String getInfractionID() {
		return infractions_id;
	}

	public void setInfractionID(String entry) {
		this.infractions_id = entry;
	}
	
	public String getInfractionDate() {
		return date;
	}

	public void setInfractionDate(String entry) {
		this.date = entry;
	}
	
	public String getInfractionOfficer() {
		return officer_involved;
	}

	public void setInfractionOfficer(String entry) {
		this.officer_involved = entry;
	}
	
	public String getInfractionForce() {
		return force_type;
	}

	public void setInfractionForce(String entry) {
		this.force_type = entry;
	}
	
	public String getInfractionVictim() {
		return victim;
	}

	public void setInfractionVictim(String entry) {
		this.victim = entry;
	}
	public String getInfractionReporter() {
		return reported_by;
	}

	public void setInfractionReporter(String entry) {
		this.reported_by = entry;
	}
	
	public String getInfractionLocation() {
		return location;
	}

	public void setInfractionLocation(String entry) {
		this.location = entry;
	}
	
	public String getInfractionDesc() {
		return description;
	}

	public void setInfractionDesc(String entry) {
		this.description = entry;
	}
	
	public String getInfractionCount() {
		return count;
	}

	public void setInfractionCount(String entry) {
		this.count = entry;
	}
	
	@Override
	public String toString() {
		return "Infraction [ "
				+ "ID =" + infractions_id 
				+ ", Date =" + date 
				+ ", Officer ID =" + officer_involved 
				+", Force ID =" + force_type
				+", Victim ID =" + victim
				+ ", Reporter ID =" + reported_by 
				+", Location =" + location
				+", Description =" + description
				+"]";
	}
}
