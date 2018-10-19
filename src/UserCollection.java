import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UserCollection {
	User onlineUser;
	boolean keyOnlineUser;
	boolean noSuchUser;
	public ArrayList<User> userList = new ArrayList<User>();

	public ArrayList<User> getUserList() {

		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public UserCollection() {

	}

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public void listUsers() {
		int i = 0;
		while (i < userList.size()) {
			

			User user = getUserList().get(i);
			System.out.println("Name: " + user.name);
			System.out.println("Username: " + user.userName);
			System.out.println("Date of Birth: " + dateFormat.format(user.getDateOfBirth()));
			System.out.println("School: " + user.schoolGraduated);
			System.out.println("------------------");
			i++;
		}

	}

	/**
	 * 
	 * @param name
	 *            Using parameter while function running
	 * @param username
	 *            Using parameter while function running
	 * @param password
	 *            Using parameter while function running
	 * @param dateOfBirth
	 *            Using parameter while function running
	 * @param schoolFromWhichTheUserGraduated
	 *            Using parameter while function running
	 * @return true
	 */

	public boolean addNewUser(String name, String username, String password, Date dateOfBirth,
			String schoolFromWhichTheUserGraduated) {
		User u = new User(name, username, password, dateOfBirth, schoolFromWhichTheUserGraduated);
		getUserList().add(u);
		System.out.println(name + " has been successfully added.");
		System.out.println();

		return true;
	}

	/**
	 * 
	 * @param userID
	 *            Using parameter while function running
	 */
	public void removeExistingUser(int userID) {
		boolean keyExistingUser=true;
		for (int j = 0; j < userList.size(); j++) {
			if (userList.get(j).userID == userID) {
				userList.remove(userList.get(j));
				System.out.println("User has been successfully removed.");
				keyExistingUser=false;
			}
		}
		if(keyExistingUser==true){
			System.out.println("No such user!");
		}
	}

	/**
	 * 
	 * @param un
	 *            Using parameter while function running
	 * @param pw
	 *            Using parameter while function running
	 * @return keyOnlineUser
	 */
	public boolean sign_in(String un, String pw) {
		boolean keySign_in = true; // yapýlmadý
		for (int j = 0; j < userList.size(); j++) {
			if (userList.get(j).userName.equals(un)) {
				keySign_in = false;
				if (userList.get(j).getPassword().equals(pw)) {
					keyOnlineUser = true;
					onlineUser = userList.get(j);
					onlineUser.userID = j;
					System.out.println("You have successfully signed in.");
				} else if (userList.get(j).getPassword().equals(pw) == false) {
					System.out.println("Invalid username or password! Please try again.");
					keyOnlineUser = false;
				}

			}

		}

		if (keySign_in) {
			System.out.println("No such user!");
			keyOnlineUser = false;

		}
		return keyOnlineUser;
	}

	/**
	 * 
	 */
	public void sign_out() {
		keyOnlineUser = false;
		onlineUser = null;

		System.out.println("You have successfully signed out.");
	}

	/**
	 * 
	 * @param name
	 *            Using parameter while function running
	 * @param dateOfBirth
	 *            Using parameter while function running
	 * @param schoolGraduated
	 *            Using parameter while function running
	 */
	public void updateProfile(String name, Date dateOfBirth, String schoolGraduated)

	{
		if(keyOnlineUser==true){
				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).name.equals(name)) {
						userList.get(i).setDateOfBirth(dateOfBirth);
						userList.get(i).schoolGraduated = schoolGraduated;
					}
				}

				System.out.println("Your user profile has been successfully updated.");
		
		
		} 
		else 
		{
			System.out.println("Error: Please sign in and try again.");
		}
	}

	/**
	 * 
	 * @param oldPassword
	 *            Using parameter while function running
	 * @param newPassword
	 *            Using parameter while function running
	 */
	public void changePassword(String oldPassword, String newPassword) {
		if (keyOnlineUser == true) {

			if (userList.get(onlineUser.userID).getPassword().equals(oldPassword)) {
				userList.get(onlineUser.userID).setPassword(newPassword);
			} else {
				System.out.println("Password mismatch! Please, try again.");
			}
		} else {
			System.out.println("Error: Please sign in and try again.");
		}

	}

	/**
	 * 
	 * @param userName
	 * Using parameter while function running
	 * 
	 */
	public void addNewFriend(String userName) {
		boolean keyAddNewFriend1 = true;
		if (keyOnlineUser == true) {
			for (int i = 0; i < userList.size(); i++) {
				if ((userList.get(i).userName.equals(userName))) {
					keyAddNewFriend1 = false;
					boolean keyAddNewFriend2 = true;
					User eklenenUser = userList.get(i);
					for (int i1 = 0; i1 < onlineUser.getFriendsList().size(); i1++) {
						if (onlineUser.getFriendsList().get(i1).userName.equals(userName)) {
							keyAddNewFriend2 = false;
							System.out.println("This user is already in your friend list!");
						}
					}
					if (keyAddNewFriend2 == true) {
						onlineUser.getFriendsList().add(eklenenUser);
						System.out.println(userName + " has been successfully added to your friend list.");
					}
				}
			}
			if (keyAddNewFriend1 == true) {
				System.out.println("No such user!");
			}

		} else {
			System.out.println("Error: Please sign in and try again.");
		}
	}

	/**
	 * 
	 */
	public void listFriends() {
		int i = 0;
		if (keyOnlineUser == true) {
			while (i < onlineUser.getFriendsList().size()) {
				User user1 = onlineUser.getFriendsList().get(i);
				System.out.println("Name: " + user1.name);
				System.out.println("Username: " + user1.userName);
				System.out.println("Date of Birth: " + dateFormat.format(user1.getDateOfBirth()));
				System.out.println("School: " + user1.schoolGraduated);
				System.out.println("------------------");
				i++;
			}
		}

	}

	/**
	 * 
	 * @param userName
	 *  Using parameter while function running
	 */
	public void removeFriend(String userName) {
		boolean keyRemoveFriend = true;
		if (keyOnlineUser == true) {
			for (int i = 0; i < onlineUser.getFriendsList().size(); i++) {
				if (onlineUser.getFriendsList().get(i).userName.equals(userName)) {
					keyRemoveFriend = false;
					onlineUser.getFriendsList().remove(i);
					System.out.println(userName + " has been successfully removed from your friend list.");
				}
			}
			if (keyRemoveFriend == true) {
				System.out.println("No such friend!");
			}

		} else
			System.out.println("Error: Please sign in and try again.");
	}

	/**
	 * 
	 * @param userName
	 *  Using parameter while function running
	 */
	public void blockUser(String userName) {
		boolean keyBlockUser = true;
		if (keyOnlineUser == true) {
			for (int i = 0; i < userList.size(); i++) {
				if ((userList.get(i).userName.equals(userName))) {
					keyBlockUser = false;
					onlineUser.getBlockedUserList().add(userList.get(i));
					System.out.println(userName + " has been successfully blocked.");
				}

			}
			if (keyBlockUser == true) {
				System.out.println("No such user!");
			}

		} else
			System.out.println("Error: Please sign in and try again.");
	}

	/**
	 * 
	 * @param userName
	 *  Using parameter while function running
	 */
	public void unblockUser(String userName) {
		boolean keyUnblockUser = true;
		if (keyOnlineUser == true) {
			for (int i = 0; i < onlineUser.getBlockedUserList().size(); i++) {
				if (onlineUser.getBlockedUserList().get(i).userName.equals(userName)) {
					onlineUser.getBlockedUserList().remove(i);
					
					System.out.println(userName + " has been successfully unblocked.");
					keyUnblockUser = false;

				}

			}
			if (keyUnblockUser == true) {
				System.out.println("No such user in your blocked users list!");
			}

		} else {
			System.out.println("Error: Please sign in and try again.");
		}
	}
	/**
	 * 
	 */
	public void showBlockedUsers() 
	{
		if (keyOnlineUser == true) 
		{
			if (onlineUser.getBlockedUserList().size() == 0) 
			{
				System.out.println("You haven’t blocked any users yet!");

			} 
				int i = 0;
				while (i < onlineUser.getBlockedUserList().size()) 
				{
					User user = onlineUser.getBlockedUserList().get(i);
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					System.out.println("Name: " + user.name);
					System.out.println("Username: " + user.userName);
					System.out.println("Date of Birth: " + dateFormat.format(user.getDateOfBirth()));
					System.out.println("School: " + user.schoolGraduated);
					System.out.println("------------------");
					i++;
				}
			

		} else 
		{
			System.out.println("Error: Please sign in and try again.");
		}
	}
	/**
	 * 
	 */
	public void showBlockedFriends()
	{
		if (keyOnlineUser == true)
		{
			if (onlineUser.getBlockedUserList().size() == 0)
			{
				System.out.println("You haven’t blocked any users yet!");
			} 
				int i = 0;
				while (i < onlineUser.getBlockedUserList().size())
				{
					for (int j = 0; j < onlineUser.getFriendsList().size(); j++)
					{
						if (onlineUser.getBlockedUserList().get(i).userName.equals(onlineUser.getFriendsList().get(j).userName)) 
						{					
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							User friendBlock = onlineUser.getFriendsList().get(j);
							System.out.println("Name: " + friendBlock.name);
							System.out.println("Username: " + friendBlock.userName);
							System.out.println("Date of Birth: " + dateFormat.format(friendBlock.getDateOfBirth()));
							System.out.println("School: " + friendBlock.schoolGraduated);
							System.out.println("------------------");
						}
					}
					i++;
				}
		} 
		else
		{
			System.out.println("Error: Please sign in and try again.");
		}
}
	/**
	 * 
	 * @param textContent
	 *  Using parameter while function running
	 * @param longitude
	 *  Using parameter while function running
	 * @param latitude
	 *  Using parameter while function running
	 * @param userNameString
	 *  Using parameter while function running
	 */
	public void addPost_text(String textContent, double longitude, double latitude, String userNameString) {
		
		TextPost tp = new TextPost(textContent);
		Location l1 = new Location(latitude, longitude);
		tp.setLocation(l1);
		String users[] = userNameString.split(":");
		boolean keyFriendFind=false;
		for (int z = 0; z < users.length; z++) 
		{
			for (int i = 0; i < onlineUser.getFriendsList().size(); i++) {
				if (onlineUser.getFriendsList().get(i).userName.equals(users[z])) 
				{
					keyFriendFind = true;
					tp.getTaggedUsers().add(onlineUser.getFriendsList().get(i));
				}
			}
			if (keyFriendFind == false) 
			{
				System.out.println("Username " + users[z] +" is not your friend, and will not be tagged!!");
			}
			
		}
		onlineUser.getPostList().add(tp);
		System.out.println("The post has been successfully added.");
	}
	/**
	 * 
	 * @param textContent
	 *  Using parameter while function running
	 * @param longitude
	 *  Using parameter while function running
	 * @param latitude
	 *  Using parameter while function running
	 * @param userNameString
	 *  Using parameter while function running
	 * @param filePath
	 *  Using parameter while function running
	 * @param videoDuration
	 *  Using parameter while function running
	 */
	public void addPost_video(String textContent, double longitude, double latitude, String userNameString,
			String filePath, int videoDuration) {
		
		VideoPost vp = new VideoPost(textContent, filePath);
		Location l2 = new Location(latitude, longitude);
		vp.setLocation(l2);
		vp.setVideoDuration(videoDuration);
		String users[] = userNameString.split(":");
		boolean keyFriendFind=false;
		for (int z = 0; z < users.length; z++) 
		{
			for (int i = 0; i < onlineUser.getFriendsList().size(); i++) {
				if (onlineUser.getFriendsList().get(i).userName.equals(users[z])) 
				{
					keyFriendFind = true;
					vp.getTaggedUsers().add(onlineUser.getFriendsList().get(i));
				}
			}
			if (keyFriendFind == false) 
			{
				System.out.println("Username " + users[z] +" is not your friend, and will not be tagged!!");
			}
			
		}
		onlineUser.getPostList().add(vp);
		System.out.println("The post has been successfully added.");
	}
	/**
	 * 
	 * @param textContent
	 *  Using parameter while function running
	 * @param longitude
	 *  Using parameter while function running
	 * @param latitude
	 *  Using parameter while function running
	 * @param userNameString
	 *  Using parameter while function running
	 * @param filePath
	 *  Using parameter while function running
	 * @param resolutionString
	 *  Using parameter while function running
	 */
	public void addPost_image(String textContent, double longitude, double latitude, String userNameString,
			
			String filePath, String resolutionString) {
		
			
			String rest[] = resolutionString.split("x");
			int a=Integer.parseInt(rest[0]);
			int b=Integer.parseInt(rest[1]);
			ImagePost ip = new ImagePost(textContent, filePath, a, b);
			Location l2 = new Location(latitude, longitude);
			ip.setLocation(l2);
			String users[] = userNameString.split(":");
			boolean keyFriendFind=false;
			for (int z = 0; z < users.length; z++) 
			{
				for (int i = 0; i < onlineUser.getFriendsList().size(); i++) {
					if (onlineUser.getFriendsList().get(i).userName.equals(users[z])) 
					{
						keyFriendFind = true;
						ip.getTaggedUsers().add(onlineUser.getFriendsList().get(i));
					}
				}
				if (keyFriendFind == false) 
				{
					System.out.println("Username " + users[z] +" is not your friend, and will not be tagged!!");
				}
				
			}
			onlineUser.getPostList().add(ip);
			System.out.println("The post has been successfully added.");
	}
	/**
	 * 
	 */
	public void removeLastPost() {
	if (keyOnlineUser == true) {
		if(onlineUser.getPostList().size()==0){
			System.out.println("Error: You don't have any posts.");
		}
		onlineUser.getPostList().remove(onlineUser.getPostList().size()-1);
		System.out.println("Your last post has been successfully removed.");
	}
	else{
		System.out.println("Error: Please sign in and try again.");
	}
	}
	/**
	 * 
	 * @param userName
	 *  Using parameter while function running
	 */
	public void showPosts(String userName) {
		
        //sdf.format(cal.getTime()) );
		boolean keyShowPosts=false;
		int textPostSize=0;
		int videoPostSize=0;
		int imagePostSize=0;
		for (int j = 0; j < userList.size(); j++) {
			if (userList.get(j).userName.equals(userName)) {
				keyShowPosts=true;
				for (int i = 0; i < userList.get(j).getPostList().size(); i++) {
					Post p = userList.get(j).getPostList().get(i);
					
					if(p instanceof ImagePost){
						DateFormat dateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
						ImagePost pi = (ImagePost) p;
						imagePostSize++;
						System.out.println("This is my " +imagePostSize + "'st image post");
						System.out.println("Date: " + (dateFormat2.format(pi.getDate())));
						System.out.println("Location: " + p.getLocation().latitude + " , " + p.getLocation().longitude);
						System.out.println("Image: " + pi.getImageFileName());
						System.out.println("Image resolution: " + pi.resolution[0] +"x"+ pi.resolution[1]);
						String taggedUserimage="";
						for (int k = 0; k < pi.getTaggedUsers().size(); k++) {
							if (taggedUserimage.equals(""))
							{
								taggedUserimage=p.getTaggedUsers().get(k).userName;
							}
							else
							taggedUserimage=taggedUserimage + "," +pi.getTaggedUsers().get(k).userName;
						}
						if (!taggedUserimage.equals(""))
						System.out.println("Friends tagged in this post: " +  taggedUserimage);
						System.out.println("---------------------------");

					}
					else if(p instanceof VideoPost){
						DateFormat dateFormat3 = new SimpleDateFormat("dd.MM.yyyy");
						VideoPost vi = (VideoPost) p;
						videoPostSize++;
						System.out.println("This is my " +videoPostSize + "'st video post");
						System.out.println("Date: " + (dateFormat3.format(vi.getDate())));
						System.out.println("Location: " + p.getLocation().latitude + " , " +p.getLocation().longitude);
						System.out.println("Video: " + vi.getVideoFileName());
						System.out.println("Video duration: " + vi.getVideoDuration()  + " minutes");
						String taggedUservideo="";
						for (int k = 0; k < vi.getTaggedUsers().size(); k++) {
							if (taggedUservideo.equals(""))
							{
								taggedUservideo=p.getTaggedUsers().get(k).userName;
							}
							else
							taggedUservideo=taggedUservideo + "," +vi.getTaggedUsers().get(k).userName;
						}
						if (!taggedUservideo.equals(""))
						System.out.println("Friends tagged in this post: " + taggedUservideo);
						System.out.println("---------------------------");
					}
					else if(p instanceof TextPost){
						DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
						textPostSize++;
						System.out.println("This is my " +textPostSize + "'st text post");
						System.out.println("Date: " + (dateFormat1.format(p.getDate())));
						System.out.println("Location: " + p.getLocation().latitude + " , "+p.getLocation().longitude);
						String taggedUserText="";
						for (int k = 0; k < p.getTaggedUsers().size(); k++) {
							if (taggedUserText.equals(""))
							{
								taggedUserText=p.getTaggedUsers().get(k).userName;
							}
							else
							taggedUserText=taggedUserText + "," +p.getTaggedUsers().get(k).userName;
						}
						if (!taggedUserText.equals(""))
							System.out.println("Friends tagged in this post: " + taggedUserText);
						System.out.println("---------------------------");
					}
					
				}
			}
		}
		if(keyShowPosts==false){
			System.out.println("No such user!");
		}
		
	}
}