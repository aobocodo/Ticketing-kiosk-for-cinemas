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
	 * @return ticket price
	 */
	private String getPrice() {
		return price;
	}

	/**
	 * @param price ticket price
	 */
	void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return ticket type
	 */
	private String getType() {
		return type;
	}

	/**
	 * @param type ticket type
	 */
	void setType(String type) {
		this.type = type;
	}

	/**
	 * @return ticket id
	 */
	String getID() {
		return ID;
	}

	/**
	 * @param ID ticket id
	 */
	void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * @return movie screen
	 */
	private String getMode() {
		return mode;
	}

	/**
	 * @param mode movie screen
	 */
	void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return movie title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return seat number
	 */
	private String getSeatNum() {
		return seatNum;
	}

	/**
	 * @param seatNum seat number
	 */
	void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	/**
	 * @return movie time
	 */
	private String getTime() {
		return time;
	}

	/**
	 * @param time movie time
	 */
	void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return student id
	 */
	private String getStuID() {
		return stuID;
	}

	/**
	 * @param stuID student id
	 */
	void setStuID(String stuID) {
		this.stuID = stuID;
	}

	/**
	 * @return formal string style
	 */
	public String toString() {
		// 8 lines for each ticket
		return "ID: " + this.getID() + "\n"                        //j
				+ "Title: " + this.getTitle() + "\n"                    //j+1
				+ "Screen: " + this.getMode() + "\n"                //j+2
				+ "Time: " + this.getTime() + "\n"                    //j+3
				+ "Seat: " + this.getSeatNum() + "\n"            //j+4
				+ "Type: " + this.getType() + "\n"                        //j+5
				+ "Price: " + this.getPrice() + "\n"                    //j+6
				+ "Student ID: " + this.getStuID() + "\n"                //j+7
				;
	}
}
