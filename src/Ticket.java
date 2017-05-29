/**
 * Name Ticket
 * Usage a class of saving ticket information
 */
public class Ticket {
	private String price;
	private String type;
	private String ID;
	private String mode;
	private String title;
	private String seatNum;
	private String time;
	private String stuID;


	/**
	 * Get price
	 * @return ticket price
	 */
	private String getPrice() {
		return price;
	}

	/**
	 * Set price
	 * @param price ticket price
	 */
	void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Get type
	 * @return ticket type
	 */
	private String getType() {
		return type;
	}

	/**
	 * Set type
	 * @param type ticket type
	 */
	void setType(String type) {
		this.type = type;
	}

	/**
	 * Get id
	 * @return ticket id
	 */
	String getID() {
		return ID;
	}

	/**
	 * Set id
	 * @param ID ticket id
	 */
	void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * Get mode
	 * @return movie screen
	 */
	private String getMode() {
		return mode;
	}

	/**
	 * Set mode
	 * @param mode movie screen
	 */
	void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * Get title
	 * @return movie title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set title
	 * @param title movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get seat number
	 * @return seat number
	 */
	private String getSeatNum() {
		return seatNum;
	}

	/**
	 * Set seat number
	 * @param seatNum seat number
	 */
	void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	/**
	 * Get time
	 * @return movie time
	 */
	private String getTime() {
		return time;
	}

	/**
	 * Set time
	 * @param time movie time
	 */
	void setTime(String time) {
		this.time = time;
	}

	/**
	 * Get student id
	 * @return student id
	 */
	private String getStuID() {
		return stuID;
	}

	/**
	 * Set student id
	 * @param stuID student id
	 */
	void setStuID(String stuID) {
		this.stuID = stuID;
	}

	/**
	 * Rewrite toString()
	 * @return formal string style
	 */
	public String toString() {
		// 8 lines for each ticket
		return "ID: " + this.getID() + "\n"
				+ "Title: " + this.getTitle() + "\n"
				+ "Screen: " + this.getMode() + "\n"
				+ "Time: " + this.getTime() + "\n"
				+ "Seat: " + this.getSeatNum() + "\n"
				+ "Type: " + this.getType() + "\n"
				+ "Price: " + this.getPrice() + "\n"
				+ "Student ID: " + this.getStuID() + "\n"
				;
	}
}
