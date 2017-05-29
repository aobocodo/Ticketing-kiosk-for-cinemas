/**
 * Name ScreenLoaction
 * Usage a class to save screen location
 */
public class ScreenLocation {
	private String title;
	private String screen;
	private String hour;
	private String min;


	/**
	 * Set title
	 * @param title movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Set screen
	 * @param screen movie screen
	 */
	void setScreen(String screen) {
		this.screen = screen;
	}

	/**
	 * Set hour
	 * @param hour movie time of hour
	 */
	void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * Set minute
	 * @param min movie time of minute
	 */
	void setMin(String min) {
		this.min = min;
	}

	/**
	 * Get screen
	 * @return movie screen
	 */
	String getScreen() {
		return screen;
	}

	/**
	 * Get title
	 * @return movie title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get hour
	 * @return hour
	 */
	String getHour() {
		return hour;
	}

	/**
	 * Get minute
	 * @return minute
	 */
	String getMin() {
		return min;
	}
}
