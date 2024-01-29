 
 

import java.util.Scanner;
import java.util.ArrayList;

public class FriendsList {
    static ArrayList<Friend> friends = new ArrayList<>(10);
    public static int userChoice;
    public static void main(String[] args) {
    }
    // determines what user wants based on input
    public static void fetchChoice(int choice, Scanner scanner) {
        if (choice == 1){
            // adds friend
            System.out.print("\nEnter friend name: ");
            String name = scanner.nextLine();
            name = verifyNameString(name);
            System.out.print("\nEnter phone number: ");
            long digits = scanner.nextLong();
            System.out.print("\nEnter age: ");
            int age = scanner.nextInt();
            System.out.print("\nEnter IQ: ");
            int IQ = scanner.nextInt();
            System.out.print("\nEnter Best Friend Rating: ");
            int BFRating = scanner.nextInt();
            if (BFRating <= 9 && BFRating >= 1) {addFriend(name, digits, age, IQ, BFRating);}
            else if (IQ <= 999 && IQ >= 0) {addFriend(name, digits, age, IQ, BFRating);}
            else if (age <= 99 && age >= 0) {addFriend(name, digits, age, IQ, BFRating);}
            else if (digits <= 9999999999l && digits >= 0l) {addFriend(name, digits, age, IQ, BFRating);}
            else{System.out.println("A number exceeded its respective reasonable range; friend was not stored");}
            userChoice = 1;
        }
        else if (choice == 2){
            // removes a friend
            System.out.println("Enter friends name: ");
            String name = scanner.nextLine();
            if (removeFriend(name)==false) {System.out.println("Friend not found!");} else {System.out.println(name + " Removed");}
            userChoice = 2;
        }
        else if (choice == 3){
            // shows list of friends
            printFriendList();
            userChoice = 3;
        }
        else if (choice == 4){
            // arranges list by name in a-z using selection sort algorithm
            int n = friends.size();
            for (int i = 0; i < friends.size() - 1; i++){
                if (friends.get(i).getName().compareTo(friends.get(i+1).getName()) < 0) {}
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (friends.get(j).getName().compareTo(friends.get(minIndex).getName()) < 0) {
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
        else if (choice == 5){
            // arranges list by IQ
            sortNum(friends, "IQ");
            System.out.println("Sorted by IQ (Highest-Lowest)");
            userChoice = 5;
        }
        else if (choice == 6){
            // arranges list by age
            sortNum(friends, "Age");
            System.out.println("Sorted by Age (Oldest-Youngest)");
            userChoice = 6;
        }
        else if (choice == 7){
            // arranges list by BFRating
            BFsort(friends);
            System.out.println("Sorted by BFRating (1-9)");
            userChoice = 7;
        }
        else if (choice == 8){
            System.out.println(causeDrama(friends));
            userChoice = 8;
        }
        else if (choice == 9) {
            userChoice = 9;
        }
        else {
            System.out.println("Invalid Input!");
        }
    }

    // methods to add friend
    public static void addFriend(String name, long digits, int age, int IQ, int BFRating, int type) {
        friends.add(new Friend(name, digits, age, IQ, BFRating));
    }
    public static void addFriend(String name, long digits, int age, int IQ, int BFRating) {
        if (BFRating > 9) {
            friends.add(friends.size(), new Friend(name, digits, age, IQ, friends.size()-1));
        } else {friends.add(BFRating, new Friend(name, digits, age, IQ, BFRating));}
    }
    // show current friends
    public static void printFriendList() {
        System.out.println("Current friends list:");
        System.out.println("Name            Age  IQ  Phone Number  BFRating");
        // iterates through arrayList and prints evenly spaced list
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(
            friends.get(i).getName()
            + returnSpaces(16 - friends.get(i).getName().length()) 
            + friends.get(i).getAge() 
            + returnSpaces(5 - Integer.toString(friends.get(i).getIQ()).length())
            + friends.get(i).getIQ()
            + returnSpaces(12 - Long.toString(friends.get(i).getDigits()).length())
            + friends.get(i).getDigits()
            + returnSpaces(5 - Integer.toString(friends.get(i).getBFrating()).length())
            + friends.get(i).getBFrating()
            );
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
        addFriend("Rocks", 4809999999l, 21, 80, 1, 1);
        addFriend("John", 6021234567l, 18, 95, 2, 1);
        addFriend("Ragnar", 5206758754l, 99, 200, 3, 1);
        addFriend("Jackson", 1234567891l, 20, 100, 4, 1);
        addFriend("Yttrium", 4309874382l, 87, 95, 5, 1);
        addFriend("Dwayne", 7654876578l, 47, 120, 6, 1);
        addFriend("Tyler", 6543098756l, 29, 130, 7, 1);
        addFriend("Liam", 5678765678l, 43, 135, 8, 1);
        addFriend("Emily", 4356758976l, 65, 120, 9, 1);
        addFriend("Sophia", 4325678900l, 22, 140, 9, 1);
    }

    // takes first 16 chars of name
    public static String verifyNameString(String name) {
        if (name.length() >= 10) {
            return (name.substring(0, 9));
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
                    if (friends.get(j).getIQ() > friends.get(maxIndex).getIQ()) {
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
                    if (friends.get(j).getAge() > friends.get(maxIndex).getAge()) {
                        maxIndex = j;
                    }
                }
                Friend temp = friends.get(maxIndex);
                friends.set(maxIndex, friends.get(i));
                friends.set(i, temp);
            }
        }
    }
    // method to sort by BFRating
    public static void BFsort(ArrayList<Friend> friends) {
        int n = friends.size();
        for (int i = 0; i < friends.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (friends.get(minIndex).getBFrating() > friends.get(j).getBFrating()) {
                    minIndex = j;
                }
            }
            Friend temp = friends.get(minIndex);
            friends.set(minIndex, friends.get(i));
            friends.set(i, temp);
        }
    }

    // method to cause drama :o
    public static String causeDrama(ArrayList<Friend> friends) {
        int max = friends.size();
        int min = 0;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        int rand2 = (int)(Math.random() * range) + min;
        if (rand == rand2) {rand = (int)(Math.random() * range) + min;}
        if (rand2 == rand) {rand = (int)(Math.random() * range) + min;}
        return ("\n" + friends.get(rand).getName() + " and "+ friends.get(rand2).getName() + " were playing with waterguns around your precious tesla coil.\nOne of them shot at the other, but, fortunately for him, he ducked.\nUnfortunately for you, your driver mosfets are now fried.\nYou removed both these donuts from your list.");
    }
}
