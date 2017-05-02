public class Movie {
	private String title;
	private String photo;
	private String timelength;

	public String toString() {
		return "Movie [ title=" + title + ", photo=" + photo + ", timelength=" + timelength + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setTimelength(String timelength) {
		this.timelength = timelength;
	}

}
