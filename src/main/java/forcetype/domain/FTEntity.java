package forcetype.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class FTEntity {
	/*
	 * Correspond to the user table
	 */
	
	private String force_id;
	private String force_used;
	private String description;
	
	public String getForceID() {
		return force_id;
	}

	public void setForceID(String entry) {
		this.force_id = entry;
	}
	
	public String getForceUsed() {
		return force_used;
	}

	public void setForceUsed(String entry) {
		this.force_used = entry;
	}
	
	public String getForceDesc() {
		return description;
	}

	public void setForceDesc(String entry) {
		this.description = entry;
	}
	
	@Override
	public String toString() {
		return "Force [ "
				+ "ID =" + force_id 
				+ ", Force Used =" + force_used 
				+ ", Description =" + description 
				+"]";
	}
}
