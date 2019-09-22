public class Actor {
	private int id;
	private String firstName;
	private String lastName;
	private String last_udate_time;
	
	public Actor(int id, String firstNmae, String lastName, String last_update_time) {
		this.id = id;
		this.firstName = firstNmae;
		this.lastName = lastName;
		this.last_udate_time = last_update_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLast_udate_time() {
		return last_udate_time;
	}

	public void setLast_udate(String last_udate_time) {
		this.last_udate_time = last_udate_time;
	}
	
	public String toString() {
		return "ID:" + this.id + " FIRST_NAME:" + this.firstName + " LAST_NAME:" + this.lastName + " LAST_UPDATE_TIME:" + this.last_udate_time;
	}
}
