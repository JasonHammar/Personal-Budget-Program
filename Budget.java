import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;

import java.io.*;

public class Budget {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome back Jason, what would you like to do today?");

		File file1 = new File("C:\\Users\\jason\\Personal Projects\\budget.txt");
		Scanner checkOrChange = new Scanner(System.in);

		System.out.println("Press 1 to view your balance, press 2 to update your balance, press 3 to quit.");
		int check = checkOrChange.nextInt();
		Scanner checkBudget = new Scanner(file1);
		String test = checkBudget.next();
		while (true) {// While loop that will check whether the user wants to change the balance,
						// check the balance, or quit the program
			if (check == 1) {// If the user types 1, it will print the current balance of the account that is
								// stored in the text file budget.txt.
				System.out.println("Your balance is: " + test);
			} else if (check == 2) {// If the user types 2, the user will be prompted if they want to add or
									// subtract money from the total.
				System.out.println("Are you adding or subtracting funds, 1 for add, 2 for subtract.");
				check = checkOrChange.nextInt();
				if (check == 1) {// If the user types 1, the user will be prompted about how much they want to
									// add. The calculation will be made and stored in a text file.
					System.out.println("How many funds are you adding?");
					float addFunds = checkOrChange.nextFloat();
					float f = Float.parseFloat(test);
					float total = f + addFunds;
					String s = Float.toString(total);
					try {
						FileWriter myWriter = new FileWriter("C:\\Users\\jason\\Personal Projects\\budget.txt");
						myWriter.write(s);
						myWriter.close();
						System.out.println("Successfully wrote to the file.");
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				} else if (check == 2) {// If the user types 1, the user will be prompted about how much they want to
					// subtract. The calculation will be made and stored in a text file.
					System.out.println("How many funds are you subtracting?");
					float addFunds = checkOrChange.nextFloat();
					float f = Float.parseFloat(test);
					float total = f - addFunds;
					String s = Float.toString(total);
					if (total < 0) {// If the user runs out of money, they will need to get more.
						System.out.println("You are running out of money, please get more!");
					} else {
						try {
							FileWriter myWriter = new FileWriter("C:\\Users\\jason\\Personal Projects\\budget.txt");
							myWriter.write(s);
							myWriter.close();
							System.out.println("Successfully wrote to the file.");
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}

				}

			} else if (check == 3) {// If the user chooses three, the program will day goodbye and end.
				System.out.println("Goodbye!");
				break;
			} else {// If any other number is inputed, there will be an error message displayed.
				System.out.println("Invalid input, please try again.");
			}
			System.out.println("Press 1 to view your balance, press 2 to update your balance, press 3 to quit.");
			check = checkOrChange.nextInt();
			Scanner newBudget = new Scanner(file1);
			test = newBudget.next();
		}

	}

}
