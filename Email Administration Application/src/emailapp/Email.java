package emailapp;
import java.util.Scanner;

public class Email {
	private String lastName;
	private String firstName;
	private String passwd;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswdLength=10;
	private String email;
	private String nameDomain = ".student.ctu.edu.vn";
	
	public Email() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		this.firstName = sc.nextLine();
		System.out.print("Enetr Last Name: ");
		this.lastName = sc.nextLine();
		System.out.println();
		//call asking for department - return department
		this.department = setDepartment();
		System.out.println("Department: "+ department);
		//call asking for random password - return password
		this.passwd = randomPassword(defaultPasswdLength);
		System.out.println("Your password: " + this.passwd);
		//Combine elements to generate email
		email = firstName.toLowerCase().replaceAll("\\s","") + lastName.toLowerCase() + "@" + department.toLowerCase().replaceAll("\\s","") + nameDomain;
		System.out.println(email);
	}
	
	private String setDepartment() {
		System.out.println("Enter your department! \n 1. Information Technology \n 2. Computer Science \n "
				+ "3. Software Engineering \n 4. Information System \n 5. Communications and Computer Networks");
		Scanner sc = new Scanner(System.in);
		int departmentChoice = sc.nextInt();
		if(departmentChoice == 1) {
			return "Information Technology";
		} else if(departmentChoice == 2) {
			return "Computer Science";
		} else if(departmentChoice == 3) {
			return "Software Engineering";
		} else if(departmentChoice == 4) {
			return "Information System";
		} else if(departmentChoice == 5) {
			return "Communications and Computer Networks";
		}else {
			return "";
		}
	}
	//random password
	private String randomPassword(int length) {
		String passwd = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*()";
		char[] arrpasswd = new char[length];
		for(int i=0; i<length; i++) {
			int random = (int) (Math.random()*passwd.length());
			arrpasswd[i] = passwd.charAt(random);
		}
		return new String(arrpasswd);
	}
	//set the mailbox capacity 
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
		
	}
 	//set the alternate email
	public void setAlterEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.passwd = password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public String getAlterEmail() {
		return alternateEmail;
	}
	public String getNewPasswd() {
		return passwd;
	}
	public String showInfo() {
		return "Full Name: " + firstName + " " + lastName + "\nEmail: " + email + "\nMailbox Capacity: " + mailboxCapacity + "MB";
	}
}

