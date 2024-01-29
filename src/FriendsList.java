package src;

import java.util.Scanner;
import java.util.ArrayList;
public class FriendsList {
	static ArrayList<Friend> friends = new ArrayList<Friend>();
	public static int userChoice;
	public static void main(String[] args) {
	}
	// determines what user wants based on input
	public static void fetchChoice(int choice) {
		Scanner scanner = new Scanner(System.in);
		if (choice == 1){
			// adds friend
			System.out.println("Enter friend name: ");
			String name = scanner.nextLine();
			name = verifyNameString(name);
			System.out.println("Enter phone number: ");
			long digits = scanner.nextLong();
			System.out.println("Enter age: ");
			int age = scanner.nextInt();
			System.out.println("Enter IQ: ");
			int IQ = scanner.nextInt();
			System.out.println("Enter Best Friend Rating: ");
			int BFRating = scanner.nextInt();
			addFriend(name, digits, age, IQ, BFRating);
			userChoice = 1;
		}
		if (choice == 2){
			// removes a friend
			System.out.println("Enter friends name: ");
			String name = scanner.nextLine();
			if (removeFriend(name)==false) {System.out.println("Friend not found!");} else {System.out.println(name + " Removed");}
			userChoice = 2;
		}
		if (choice == 3){
			// shows list of friends
			printFriends();
			userChoice = 3;
		}
		scanner.close();
	}

	// method to add friend
	public static void addFriend(String name, long digits, int age, int IQ, int BFRating) {
		friends.add(new Friend(name, digits, age, IQ, BFRating));
	}

	// show current friends
	public static void printFriends() {
		System.out.println("Current friends list:");
		System.out.println("Name            Age  IQ  Phone Number  BFRating");
		// iterates through arrayList and prints evenly spaced list
		for (int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i).getName()+returnSpaces(16 - friends.get(i).getName().length()) + friends.get(i).getAge());
		}

	}

	// remove friend using name; returns false if not found, returns true if removed
	public static boolean removeFriend(String name) {
		for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).getName().equals(name)){
				friends.remove(i);
				i--;
				return true;
			}
		}
		return false;
	}

	// returns spaces given length
	public static String returnSpaces(int length) {
		String spaces = "";
		for (int i = 0; i < length; i++) {
			spaces = spaces+(" ");
		}
		return spaces;
	}

	// adds default friends
	public static void defaultFriends() {
		addFriend("John", 6021234567l, 18, 95, 1);
		addFriend("Rockssssssssssssssssssssss", 4809999999l, 21, 80, 9);
	}

	// takes first 16 chars of name
	public static String verifyNameString(String name) {
		if (name.length() >= 16) {
			return (name.substring(0, 15));
		}
		else {return name;}
	}
}