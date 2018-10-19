import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Post implements PostInterface{
	public String text;
	public Date postDate;
	private Location location;
	private ArrayList<User> taggedUsers = new ArrayList<User>();
	
	public ArrayList<User> getTaggedUsers() {
		return taggedUsers;
	}
	public void setTaggedUsers(ArrayList<User> taggedUsers) {
		this.taggedUsers = taggedUsers;
	}
	
	
	public Location getLocation() {
		return location;
	}
	/**
	 * 
	 * @param location
	 * Create a new user object with constructor parameter
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * 
	 * @param text
	 * Using parameter while function running
	 */
	public Post(String text) {
		this.postDate= Calendar.getInstance().getTime();
		this.text=text;
	}
	
	public Date getDate() {
		// TODO Auto-generated method stub
		return postDate;
	}

}
