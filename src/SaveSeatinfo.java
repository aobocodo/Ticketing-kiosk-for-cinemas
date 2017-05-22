/**
 * Created by Administrator on 2017/5/10 0010.
 */
public class SaveSeatinfo {
	private int saveNumber;
	private String saveTitle;
	private String saveTime;
	private int saveMode;
	private String saveID;
	private String saveSeatlocation;
	private String saveType;
	private String savePrice;

	public SaveSeatinfo(int saveNumber, String saveTitle, String saveTime, int saveMode) {
		this.saveNumber = saveNumber;
		this.saveTitle = saveTitle;
		this.saveTime = saveTime;
		this.saveMode = saveMode;
	}


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

	public int getSaveMode(){return saveMode;}

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
		return "number is "+saveNumber+"title is "+saveTitle+"time is "+saveTime+"Mode is "+ saveMode + "Id is"+saveID +"saveSeatlocation is "+ saveSeatlocation+"saveType is "+saveType
					+"savePrice is "+ savePrice ;
	}
}
