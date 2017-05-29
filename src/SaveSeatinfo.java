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
	 * Set save id
	 * @param saveID student id
	 */
	void setSaveID(String saveID) {
		this.saveID = saveID;
	}

	/**
	 * Set save seat location
	 * @param saveSeatlocation seat location
	 */
	void setSeatlocation(String saveSeatlocation) {
		this.saveSeatlocation = saveSeatlocation;
	}

	/**
	 * Set save type
	 * @param saveType ticket type
	 */
	void setSaveType(String saveType) {
		this.saveType = saveType;
	}

	/**
	 * Set save price
	 * @param savePrice ticket price
	 */
	void setSavePrice(String savePrice) {
		this.savePrice = savePrice;
	}

	/**
	 * Get save number
	 * @return customer choose seat location number
	 */
	int getSaveNumber(){
		return saveNumber;
	}

	/**
	 * Get save title
	 * @return movie title
	 */
	String getSaveTitle(){
		return saveTitle;
	}

	/**
	 * Get save mode
	 * @return movie screen
	 */
	int getSaveMode(){return saveMode;}

	/**
	 * Get save time
	 * @return movie time
	 */
	String getSaveTime(){
		return saveTime;
	}

	/**
	 * Get save seat location
	 * @return seat location
	 */
	String getSaveSeatlocation(){
		return saveSeatlocation;
	}

	/**
	 * Get save type
	 * @return ticket type
	 */
	String getSaveType(){
		return saveType;
	}

	/**
	 * Get save price
	 * @return ticket type
	 */
	String getSavePrice(){
		return savePrice;
	}

	/**
	 * Get save id
	 * @return student id
	 */
	String getSaveID(){
		return saveID;
	}

}
