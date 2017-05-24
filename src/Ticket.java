/**
 * Created by Administrator on 2017/5/24 0024.
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


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
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
