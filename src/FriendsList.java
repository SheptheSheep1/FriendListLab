package src;

import java.util.Scanner;
import java.util.ArrayList;
public class FriendsList {
	static ArrayList<Friend> friends = new ArrayList<Friend>();
	public static int userChoice;
	public static void main(String[] args) {
	}
	// determines what user wants based on input
	public static void fetchChoice(int choice, Scanner scanner) {
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
		if (choice == 4){
			// arranges list by name in a-z using selection sort algorithm
			int n = friends.size();
			for (int i = 0; i < friends.size() - 1; i++){
				if (friends.get(i).getName().compareTo(friends.get(i+1).getName()) < 0) {}
				int minIndex = i;
				for (int j = i + 1; j < n; j++) {
					if (friends.get(j).getName().compareTo(friends.get(i).getName()) < 0) {
						minIndex = j;
					}
				}
				Friend temp = friends.get(minIndex);
				friends.set(minIndex, friends.get(i));
				friends.set(i, temp);
			}
			System.out.println("Sorted by Name (A-Z)");
			userChoice = 4;
		}
		if (choice == 5){
			// arranges list by IQ
			sortNum(friends, "IQ");
			System.out.println("Sorted by IQ (Highest-Lowest)");
			userChoice = 5;
		}
		if (choice == 6){
			// arranges list by age
			sortNum(friends, "Age");
			System.out.println("Sorted by Age (Oldest-Youngest)");
			userChoice = 6;
		}
		if (choice == 7){
			// arranges list by BFRating
			userChoice = 7;
		}
		if (choice == 8){
			userChoice = 8;
		}
		if (choice == 9) {
			userChoice = 9;
		}
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
			System.out.println(
			friends.get(i).getName()
			+ returnSpaces(16 - friends.get(i).getName().length()) 
			+ friends.get(i).getAge() 
			+ returnSpaces(5 - Integer.toString(friends.get(i).getIQ()).length())
			+ friends.get(i).getIQ());
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
		addFriend("Rocks", 4809999999l, 21, 80, 9);
		addFriend("John", 6021234567l, 18, 95, 1);
		addFriend("Ragnar", 5206758754l, 99, 200, 2);
		addFriend("Jackson", 1234567891l, 20, 100, 4);
		addFriend("Yttrium", 4309874382l, 87, 95, 3);
		addFriend("Dwayne", 7654876578l, 47, 120, 6);
		addFriend("Tyler", 6543098756l, 29, 130, 2);
		addFriend("Liam", 5678765678l, 43, 135, 5);
		addFriend("Emily", 4356758976l, 65, 120, 7);
		addFriend("Sophia", 4325678900l, 22, 140, 8);
	}

	// takes first 16 chars of name
	public static String verifyNameString(String name) {
		if (name.length() >= 16) {
			return (name.substring(0, 15));
		}
		else {return name;}
	}

	// method to sort by IQ given an ArrayList
	public static void sortNum(ArrayList<Friend> friends, String IQorAge) {
		if (IQorAge.equals("IQ")==true){
			int n = friends.size();
			for (int i = 0; i < friends.size() - 1; i++) {
				int maxIndex = i;
				for (int j = i + 1; j < n; j++) {
					if (friends.get(i).getIQ() < friends.get(j).getIQ()) {
						maxIndex = j;
					}
				}
				Friend temp = friends.get(maxIndex);
				friends.set(maxIndex, friends.get(i));
				friends.set(i, temp);
		}
		} 
		else if (IQorAge.equals("Age")==true){
			int n = friends.size();
			for (int i = 0; i < friends.size() - 1; i++) {
				int maxIndex = i;
				for (int j = i + 1; j < n; j++) {
					if (friends.get(i).getAge() < friends.get(j).getAge()) {
						maxIndex = j;
					}
				}
				Friend temp = friends.get(maxIndex);
				friends.set(maxIndex, friends.get(i));
				friends.set(i, temp);
			}
		}
	}
	public static void BFsort(ArrayList<Friend> friends) {
		int n = friends.size();
		for (int i = 0; i < friends.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (friends.get(i).getBFrating() > friends.get(j).getBFrating()) {
					minIndex = j;
				}
			}
			Friend temp = friends.get(minIndex);
			friends.set(minIndex, friends.get(i));
			friends.set(i, temp);
		}
	}
}