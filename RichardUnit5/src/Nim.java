import java.util.Scanner;
import java.util.Random;
public class Nim {
    public static Scanner in  = new Scanner(System.in);
    public static int stones = new Random().nextInt(16) + 15;
    public static void main(String[] args) {
        while (true) {
            int stonesTakenByUser = prompt();
            stones -= stonesTakenByUser;
            if (stones == 0) {
                System.out.println("The computer beats the player!");
                break;
            }
            System.out.print("There are " + stones + " stones. ");
            int stonesTakenByComputer = computerChoice();
            System.out.println("The computer takes " + stonesTakenByComputer + " stones.");
            stones -= stonesTakenByComputer;
            if (stones == 0) {
                System.out.println("The player beats the computer!");
                break; 
            }
        }
        in.close();
    }

    public static int prompt() {
        int userInput = 0;
        while (true) {
            try {
                System.out.print("There are " + stones + " stones. ");
                System.out.print("How many would you like? ");
                userInput = in.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Please enter the appropriate amount of stones!");
                in.next();
                continue;
            }
            if (userInput > stones || 0 >= userInput || userInput >= 4) {
                System.out.println("Please enter the appropriate amount of stones!");
                continue;
            }
            break;
        }
        return userInput;
    }

    public static int computerChoice() {
        if (stones % 4 == 1 && stones > 4) {
            return new Random().nextInt(3) + 1;
        }
        if (stones == 1) return 1;
        if (stones == 2) return 1;
        if (stones == 3) return 2;
        if (stones % 4 == 0) return 3;
        if (stones % 4 == 2) return 1;
        return 2;
    }
}
