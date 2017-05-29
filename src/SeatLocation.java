/**
 * Name SeatLocation
 * Usage a class of saving the seat location
 */
public class SeatLocation {
	private String title;
	private String time;
	private String mode;
	private String width;
	private String height;
	private String position;
	private String positionstate;


	/**
	 * Set title
	 * @param title movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Set time
	 * @param time movie time
	 */
	void setTime(String time) {
		this.time = time;
	}

	/**
	 * Set mode
	 * @param mode movie screen
	 */
	void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * Set width
	 * @param width cinema width
	 */
	void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Set height
	 * @param height cinema height
	 */
	void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Set position
	 * @param position seat layout
	 */
	void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Set position state
	 * @param positionstate seat state
	 */
	void setPositionstate(String positionstate) {
		this.positionstate = positionstate;
	}

	/**
	 * Get movie title
	 * @return movie title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get movie time
	 * @return movie time
	 */
	String getTime() {
		return time;
	}

	/**
	 * Get movie screen
	 * @return movie screen
	 */
	String getMode() {
		return mode;
	}

	/**
	 * Get width
	 * @return cinema screen
	 */
	String getWidth() {
		return width;
	}

	/**
	 * Get height
	 * @return cinema height
	 */
	String getHeight() {
		return height;
	}

	/**
	 * Get position
	 * @return seat layout
	 */
	String getPosition() {
		return position;
	}

	/**
	 * Get position state
	 * @return seat state
	 */
	String getPositionstate() {
		return positionstate;
	}
}
