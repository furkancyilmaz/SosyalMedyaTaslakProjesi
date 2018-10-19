import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 * 
 * @author Furkan Cevat Yýlmaz
 * @version 1.8.0
 * @since 2017-04-27 (the version of the package this class was first added to)
 *
 */

public class Main {
	/**
	 * Using variables
	 * functions f
	 * Main object
	 * Using methods(setter/getter)
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param args
	 * show arguments 
	 * @throws FileNotFoundException
	 * FileNotFoundException catch errors
	 * @throws ParseException
	 * ParseException catch errors
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		UserCollection uc = new UserCollection();
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
			

			Scanner scanner = new Scanner(new File(args[0]));
			int id = 1;
			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String params[] = line.split("\t");
				User user = new User();
				user.userID = id;
				for (int i = 0; i < params.length; i++) {
					if (i == 0)
						user.name = params[i];
					else if (i == 1)
						user.userName = params[i];
					else if (i == 2)
						user.setPassword(params[i]);
					else if (i == 3) {
						user.setDateOfBirth(dateFormat.parse(params[i]));
					} else if (i == 4) {
						user.schoolGraduated = params[i];
					}

				}

				uc.getUserList().add(user);
				id++;

			}

			scanner.close();
		} catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
		}
		try {
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			Scanner scanner1 = new Scanner(new File(args[1]));
			while (scanner1.hasNextLine()) {
				String line1 = scanner1.nextLine();
				String params1[] = line1.split("\t");
				if(params1.length>0){		
				switch (params1[0]) {
				case "ADDUSER":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2] + "\t"+ params1[3] + "\t" + params1[4] + "\t" + params1[5]);
					params1[4] = dateFormat.format(date);
					uc.addNewUser(params1[1], params1[2], params1[3], date, params1[5]);
					System.out.println("---------------------------");
					break;
				case "REMOVEUSER":
					System.out.println("Command: " + params1[0] + "\t" + params1[1]);
					int x = Integer.parseInt(params1[1]);
					uc.removeExistingUser(x);
					System.out.println("---------------------------");
					break;
				case "SIGNIN":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2]);
					uc.sign_in(params1[1], params1[2]);
					System.out.println("---------------------------");
					break;
				case "SIGNOUT":
					System.out.println("Command: " + params1[0]);
					uc.sign_out();
					System.out.println("---------------------------");
					break;
				case "UPDATEPROFILE":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2] + "\t" + params1[3]);
					date = dateFormat.parse(params1[2]);
					uc.updateProfile(params1[1], date, params1[3]);
					System.out.println("---------------------------");
					break;
				case "CHPASS":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2]);
					uc.changePassword(params1[1], params1[2]);
					System.out.println("---------------------------");
					break;
				case "ADDFRIEND":
					System.out.println("Command: " + params1[0] + "\t" + params1[1]);
					uc.addNewFriend(params1[1]);
					System.out.println("---------------------------");
					break;
				case "LISTFRIENDS":
					System.out.println("Command: " + params1[0]);
					uc.listFriends();
					System.out.println("---------------------------");
					break;
				case "LISTUSERS": 
					System.out.println("Command: " + params1[0]);
					uc.listUsers();
					System.out.println("---------------------------");
					break;
				case "REMOVEFRIEND":
					System.out.println("Command: " + params1[0] + "\t" + params1[1]);
					uc.removeFriend(params1[1]);
					System.out.println("---------------------------");
					break;
				case "BLOCK":
					System.out.println("Command: " + params1[0] + "\t" + params1[1]);
					uc.blockUser(params1[1]);
					System.out.println("---------------------------");
					break;
				case "UNBLOCK":
					System.out.println("Command: " + params1[0] + "\t" + params1[1]);
					uc.unblockUser(params1[1]);
					System.out.println("---------------------------");
					break;
				case "SHOWBLOCKEDFRIENDS":
					System.out.println("Command: " + params1[0]);
					uc.showBlockedFriends();
					System.out.println("---------------------------");
					break;
				case "SHOWBLOCKEDUSERS":
					System.out.println("Command: " + params1[0]);
					uc.showBlockedUsers();
					System.out.println("---------------------------");
					break;

				case "ADDPOST-TEXT":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2] + "\t"+ params1[3] + "\t" + params1[4]);
					TextPost tp = new TextPost(params1[1]);
					double x1 = Double.parseDouble(params1[2]);
					double x2 = Double.parseDouble(params1[3]);
					uc.addPost_text(tp.text,x1 , x2, params1[4]);
					System.out.println("---------------------------");
					break;
				case "ADDPOST-IMAGE":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2] + "\t"+ params1[3] + "\t" + params1[4] + "\t" + params1[5] + "\t" + params1[6]);
					String params2[]=params1[6].split("x");
					int a = Integer.parseInt(params2[0]);
					int b = Integer.parseInt(params2[0]);
					ImagePost ip = new ImagePost(params1[1], params1[5],a, b);
					double x11=Double.parseDouble(params1[2]);
					double x21=Double.parseDouble(params1[3]);
					uc.addPost_image(params1[1], x11, x21, params1[4], params1[5], params1[6]);
					System.out.println("---------------------------");
					break;
				case "ADDPOST-VIDEO":
					System.out.println("Command: " + params1[0] + "\t" + params1[1] + "\t" + params1[2] + "\t"+ params1[3] + "\t" + params1[4] + "\t" + params1[5] + "\t" + params1[6]);
					double x111=Double.parseDouble(params1[2]);
					double x211=Double.parseDouble(params1[3]);
					int c=Integer.parseInt(params1[6]);
					VideoPost vp = new VideoPost(params1[1], params1[5]);
					uc.addPost_video(params1[1], x111, x211, params1[4], params1[5], c);
					System.out.println("---------------------------");
					break;
				case "REMOVELASTPOST":
					System.out.println("Command: " + params1[0]);
					uc.removeLastPost();
					System.out.println("---------------------------");
					break;
				case "SHOWPOSTS":
					System.out.println("Command: " + params1[0] + "\t" + params1[1]);
					uc.showPosts(params1[1]);
					System.out.println("---------------------------");
					break;
					default:
					break;
					}

				}
				}
			scanner1.close();
		}
		 catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
		 }

}

	

}
