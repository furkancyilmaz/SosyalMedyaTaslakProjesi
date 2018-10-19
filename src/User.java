import java.util.ArrayList;
import java.util.Date;


public class User {
	/**
	 * Using variables
	 * int userID
	 * String password
	 * Date dateOfBirth
	 * Date lastLogin
	 * String name
	 * String userName
	 * String schoolGraduated
	 * boolean signedin
	 * Using methods(setter/getter)
	 */
	UserCollection userc = new UserCollection();

	public int userID;
	private String password;
	private Date dateOfBirth;
	private Date lastLogin;
	public String name;
	public String userName;
	public String schoolGraduated;
	public boolean signedin;
	private ArrayList<Post> postList = new ArrayList<Post>();
	
	public ArrayList<Post> getPostList() {
		return postList;
	}

	public void setPostList(ArrayList<Post> postList) {
		this.postList = postList;
	}

	/**
	 * 
	 * @param name
	 * Create a new user object with constructor parameter
	 * @param dateOfBirth
	 * Create a new user object with constructor parameter
	 * @param schoolGraduated
	 * Create a new user object with constructor parameter
	 */
	public User(String name, Date dateOfBirth, String schoolGraduated) {

		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.schoolGraduated = schoolGraduated;
	}

	/**
	 * 
	 * @param name
	 * Create a new user object with constructor parameter
	 * @param username
	 * Create a new user object with constructor parameter
	 * @param password
	 * Create a new user object with constructor parameter
	 * @param dateOfBirth
	 * Create a new user object with constructor parameter
	 * @param schoolGraduated
	 * Create a new user object with constructor parameter
	 */
	public User(String name, String username, String password, Date dateOfBirth, String schoolGraduated) {

		this.name = name;
		this.userName = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.schoolGraduated = schoolGraduated;
	}

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	private ArrayList<User> blockedUserList = new ArrayList<User>();
	private ArrayList<User> friendsList = new ArrayList<User>();
	public ArrayList<User> getBlockedUserList() {
		return blockedUserList;
	}
	
	public void setBlockedUserList(ArrayList<User> blockedUserList) {
		this.blockedUserList = blockedUserList;
	}
	

	public ArrayList<User> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(ArrayList<User> friendsList) {
		this.friendsList = friendsList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date params) {
		this.dateOfBirth = params;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
