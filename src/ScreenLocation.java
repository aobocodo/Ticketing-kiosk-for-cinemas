public class ScreenLocation {
	private String title;
	private String screen;
	private String hour;
	private String min;


	public void setTitle(String title) {
		this.title = title;
	}

	void setScreen(String screen) {
		this.screen = screen;
	}

	void setHour(String hour) {
		this.hour = hour;
	}

	void setMin(String min) {
		this.min = min;
	}

	String getScreen() {
		return screen;
	}

	public String getTitle() {
		return title;
	}

	String getHour() {
		return hour;
	}

	String getMin() {
		return min;
	}
}
