package EmailApp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private String email;
	private String companySuffix = "ncbgroup.com";
	private int mailboxCapacity = 500;
	private String alternateEmail;
	
// Constructor to receive first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Welcome: " + this.firstName + " " + this.lastName );
		
		
//Call a method to ask for department - return department
		this.department = setDepartment();
		//System.out.println("Your Department is :" + " " + this.department);
		
// call method that returns a random password
		this.password = generatePassword(8);
		System.out.println("Your password is :" + this.password);
		
//combine elements to form email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix ;
		//System.out.println("Your Email is " + email);
	}
// Ask for department
	private String setDepartment() {
		System.out.println("Department Codes:\n1 for Sales\n2 for Accounting\n3 for Development\n0 for none\n Enter Department Code : ");
		try (Scanner in = new Scanner(System.in)) {
			int depChoice = in.nextInt();
			if (depChoice == 1) {
				return "sales";
			}
			else if (depChoice == 2) {
				return "accounting";
			}
			else if (depChoice == 3) {
				return "dev";
			}
			else {
				return "";	}
		}
	}
	
// Generate Random password
	private static String generatePassword(int length) {
		  String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char [] password = new char [length];
	      
	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1]= capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	      
	      for(int i = 4; i< length ; i++) {
	          password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	       }
	       return new String (password);
	}	 

 	
	
// set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

 
// set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail= altEmail;
	}
	
	
// change password
	public void setchangePassword(String password) {
		this.password = password;
	}
 
 
 public int getMailboxCapacity(){
	 return mailboxCapacity;	 
 }
 public String getAlternateEmail() {
	 return alternateEmail;
 }
 public String getPassword() {
	 return password;
 }
 public String showInfo() {
	 return ("NAME: " + firstName + " " + lastName +
			 "\nCOMPANY EMAIL: " + email +
			 "\nMAILBOX CAPACITY:" + mailboxCapacity + "mb");
			 
 }
}
