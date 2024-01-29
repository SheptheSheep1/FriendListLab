package src;

import java.util.Scanner;
public class FriendListLab {
	public static void main(String[] args) {
		int choice;
		//FriendsList friendsList = new FriendsList();
		FriendsList.defaultFriends();
		Scanner scanner = new Scanner(System.in);
		do {
		printMenu();
		choice = scanner.nextInt();
		scanner.nextLine();
		FriendsList.fetchChoice(choice, scanner);
		} while (FriendsList.userChoice!=9);
		scanner.close();
	}
	public static void printMenu() {
		System.out.println("\n\n\n");
		System.out.println("Main Menu");
		System.out.println("1. Add a friend");
		System.out.println("2. Delete a friend");
		System.out.println("3. Show List");
		System.out.println("4. Arrange list by Name (A-Z)");
		System.out.println("5. Arrange list by IQ (Highest-Lowest)");
		System.out.println("6. Arrange list by Age (Oldest-Youngest)");
		System.out.println("7. Arrange list by Best Friend Rating (1-9)");
		System.out.println("8. Cause Drama");
		System.out.println("9. Exit");
	}
}
