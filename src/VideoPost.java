
public class VideoPost extends TextPost{
	/**
	 * Using variables
	 * String videoFileName
	 * int videoDuration
	 * Using methods(setter/getter) 
	 */
	private String videoFileName;
	private int videoDuration;
	public int getVideoDuration() {
		return videoDuration;
	}
	public void setVideoDuration(int videoDuration) {
		this.videoDuration = videoDuration;
	}
	public String getVideoFileName() {
		return videoFileName;
	}
	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}
	public static final int MAXVÝDEOLENGHT=10;
	/**
	 * 
	 * @param text
	 * Create a new user object with constructor parameter
	 * @param videoFileName
	 * Create a new user object with constructor parameter
	 */
	public VideoPost(String text,String videoFileName) {
		super(text);
		setVideoFileName(videoFileName);
	}

	
	
}
