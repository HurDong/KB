package Libraray;

public class VideoShare extends Share {
	// 평점
	public int rating;

	public VideoShare() {
		// TODO Auto-generated constructor stub
	}

	public VideoShare(String name, int regNum, String genre, int rating) {
		super(name, regNum, genre);
		this.rating = rating;
	}

}
