
public class ScreenLocation {
	private String title;
	private String screen;
	private String hour;
	private String min;

	public String toString() {
		return "ScreenLocation [ title=" + title + ", screen=" + screen + ", time=" + hour + ":" + min + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getScreen() {
		return screen;
	}

	public String getTitle() {
		return title;
	}

	public String getHour() {
		return hour;
	}

	public String getMin() {
		return min;
	}
}
