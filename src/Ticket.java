public class Ticket {
	private String price;
	private String type;
	private String ID;
	private String mode;
	private String title;
	private String seatNum;
	private String time;
	private String stuID;


	private String getPrice() {
		return price;
	}

	void setPrice(String price) {
		this.price = price;
	}

	private String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	String getID() {
		return ID;
	}

	void setID(String ID) {
		this.ID = ID;
	}

	private String getMode() {
		return mode;
	}

	void setMode(String mode) {
		this.mode = mode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String getSeatNum() {
		return seatNum;
	}

	void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	private String getTime() {
		return time;
	}

	void setTime(String time) {
		this.time = time;
	}

	private String getStuID() {
		return stuID;
	}

	void setStuID(String stuID) {
		this.stuID = stuID;
	}

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
