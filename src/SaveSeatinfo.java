/**
 * Name SaveSeatinfo
 * Usage a class to save seat information
 */
class SaveSeatinfo {
	private int saveNumber;
	private String saveTitle;
	private String saveTime;
	private int saveMode;
	private String saveID;
	private String saveSeatlocation;
	private String saveType;
	private String savePrice;

	/**
	 * constructor
	 * @param saveNumber customer choose seat location number
	 * @param saveTitle movie title
	 * @param saveTime movie time
	 * @param saveMode movie screen
	 */
	SaveSeatinfo(int saveNumber, String saveTitle, String saveTime, int saveMode) {
		this.saveNumber = saveNumber;
		this.saveTitle = saveTitle;
		this.saveTime = saveTime;
		this.saveMode = saveMode;
	}


	/**
	 * @param saveID student id
	 */
	void setSaveID(String saveID) {
		this.saveID = saveID;
	}

	/**
	 * @param saveSeatlocation seat location
	 */
	void setSeatlocation(String saveSeatlocation) {
		this.saveSeatlocation = saveSeatlocation;
	}

	/**
	 * @param saveType ticket type
	 */
	void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	/**
	 * @param savePrice ticket price
	 */
	void setSavePrice(String savePrice) {
		this.savePrice = savePrice;
	}

	/**
	 * @return customer choose seat location number
	 */
	int getSaveNumber(){
		return saveNumber;
	}

	/**
	 * @return movie title
	 */
	String getSaveTitle(){
		return saveTitle;
	}

	/**
	 * @return movie screen
	 */
	int getSaveMode(){return saveMode;}

	/**
	 * @return movie time
	 */
	String getSaveTime(){
		return saveTime;
	}

	/**
	 * @return seat location
	 */
	String getSaveSeatlocation(){
		return saveSeatlocation;
	}

	/**
	 * @return ticket type
	 */
	String getSaveType(){
		return saveType;
	}

	/**
	 * @return ticket type
	 */
	String getSavePrice(){
		return savePrice;
	}

	/**
	 * @return student id
	 */
	String getSaveID(){
		return saveID;
	}

}
