
public class ImagePost extends TextPost{
	/**
	 * Using variables
	 * int[] resolution
	 * String imageFileName
	 * Using methods(setter/getter) 
	 */
	public int[]resolution=new int[2];
	public String imageFileName;
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	/**
	 * 
	 * @param text
	 * Create a new user object with constructor parameter
	 * @param imageFileName
	 * Create a new user object with constructor parameter
	 * @param a
	 * Create a new user object with constructor parameter
	 * @param b
	 * Create a new user object with constructor parameter
	 */
	public ImagePost(String text,String imageFileName,int a,int b) {
		super(text);
		resolution[0]=a;
		resolution[1]=b;
		this.imageFileName=imageFileName;
	}

	
	
}
