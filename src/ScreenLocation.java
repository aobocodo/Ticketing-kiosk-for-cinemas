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
	 * @param title movie title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param screen movie screen
	 */
	void setScreen(String screen) {
		this.screen = screen;
	}

	/**
	 * @param hour movie time of hour
	 */
	void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @param min movie time of minute
	 */
	void setMin(String min) {
		this.min = min;
	}

	/**
	 * @return movie screen
	 */
	String getScreen() {
		return screen;
	}

	/**
	 * @return movie title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return hour
	 */
	String getHour() {
		return hour;
	}

	/**
	 * @return minute
	 */
	String getMin() {
		return min;
	}
}
