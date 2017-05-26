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
	 * @param title movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param time movie time
	 */
	void setTime(String time) {
		this.time = time;
	}

	/**
	 * @param mode movie screen
	 */
	void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @param width cinema width
	 */
	void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @param height cinema height
	 */
	void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @param position seat layout
	 */
	void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @param positionstate seat state
	 */
	void setPositionstate(String positionstate) {
		this.positionstate = positionstate;
	}

	/**
	 * @return movie title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return movie time
	 */
	String getTime() {
		return time;
	}

	/**
	 * @return movie screen
	 */
	String getMode() {
		return mode;
	}

	/**
	 * @return cinema screen
	 */
	String getWidth() {
		return width;
	}

	/**
	 * @return cinema height
	 */
	String getHeight() {
		return height;
	}

	/**
	 * @return seat layout
	 */
	String getPosition() {
		return position;
	}

	/**
	 * @return seat state
	 */
	String getPositionstate() {
		return positionstate;
	}
}
