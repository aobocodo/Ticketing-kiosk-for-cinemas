/**
 * Created by Administrator on 2017/5/10 0010.
 */
public class SaveSeatinfo {
	private int saveNumber;
	private String saveTitle;
	private String saveTime;
	private String saveID;
	private String saveSeatlocation;
	private String saveType;
	private String savePrice;

	public SaveSeatinfo(int saveNumber, String saveTitle, String saveTime) {
		this.saveNumber = saveNumber;
		this.saveTitle = saveTitle;
		this.saveTime = saveTime;
	}

//	public void setSaveNumber(int saveNumber){ this.saveNumber = saveNumber; }
//
//	public void setSaveTitle(String saveTitle) {
//		this.saveTitle = saveTitle;
//	}
//
//	public void setSaveTime(String saveTime) {
//		this.saveTime = saveTime;
//	}

	public void setSaveID(String saveID) {
		this.saveID = saveID;
	}

	public void setSeatlocation(String saveSeatlocation) {
		this.saveSeatlocation = saveSeatlocation;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	public void setSavePrice(String savePrice) {
		this.savePrice = savePrice;
	}

	public int getSaveNumber(){
		return saveNumber;
	}

	public String getSaveTitle(){
		return saveTitle;
	}

	public String getSaveTime(){
		return saveTime;
	}

	public String getSaveSeatlocation(){
		return saveSeatlocation;
	}

	public String getSaveType(){
		return saveType;
	}

	public String getSavePrice(){
		return savePrice;
	}

	public String getSaveID(){
		return saveID;
	}

	public String toString(){
		return "number is "+saveNumber+"title is "+saveTitle+"time is "+saveTime+ "Id is"+saveID +"saveSeatlocation is "+ saveSeatlocation+"saveType is "+saveType
					+"savePrice is "+ savePrice;
	}
}
