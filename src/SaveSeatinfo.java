class SaveSeatinfo {
	private int saveNumber;
	private String saveTitle;
	private String saveTime;
	private int saveMode;
	private String saveID;
	private String saveSeatlocation;
	private String saveType;
	private String savePrice;

	SaveSeatinfo(int saveNumber, String saveTitle, String saveTime, int saveMode) {
		this.saveNumber = saveNumber;
		this.saveTitle = saveTitle;
		this.saveTime = saveTime;
		this.saveMode = saveMode;
	}


	void setSaveID(String saveID) {
		this.saveID = saveID;
	}

	void setSeatlocation(String saveSeatlocation) {
		this.saveSeatlocation = saveSeatlocation;
	}

	void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	void setSavePrice(String savePrice) {
		this.savePrice = savePrice;
	}

	int getSaveNumber(){
		return saveNumber;
	}

	String getSaveTitle(){
		return saveTitle;
	}

	int getSaveMode(){return saveMode;}

	String getSaveTime(){
		return saveTime;
	}

	String getSaveSeatlocation(){
		return saveSeatlocation;
	}

	String getSaveType(){
		return saveType;
	}

	String getSavePrice(){
		return savePrice;
	}

	String getSaveID(){
		return saveID;
	}

}
