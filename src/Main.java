import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		boolean check = false;
			
		//Ask for choice check for non int
		while(choice == 0 || !check) {
			try {
				System.out.println("\nWhat would you like to do:\n1: Add\n2: Subtract\n3: Multiply\n4: Divide\n5: Exit");
				choice = scan.nextInt();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.\n");
				choice = 0;
        		scan.nextLine();
			}
			
			switch(choice) {
			case 1: 
				add();
				choice = 0;
				check = false;
				break;
			case 2:
				sub();
				choice = 0;
				check = false;
				break;
			case 3:
				mult();
				choice = 0;
				check = false;
				break;
			case 4:
				div();
				choice = 0;
				check = false;
				break;
			case 5:
				System.out.print("Exiting......");
				System.exit(0);
			}
			
		}
		
		switch(choice) {
		case 1: 
			add();
			break;
		case 2:
			sub();
			break;
		case 3:
			mult();
			break;
		case 4:
			div();
			break;
		}
	}

	private static void add() {
		Scanner scan = new Scanner(System.in);
		double num1 = 0, num2 = 0, result;
		boolean check = false;
		
		System.out.println("Addition:");
		
		while(!check){
			try {
				System.out.println("Enter in first number");
				num1 = scan.nextDouble();
				check = true;
				scan.nextLine();
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num1 = 0;
        		scan.nextLine();
			}
		}
		
		check = false;
		
		while(!check){
			try {
				System.out.println("Enter in second number");
				num2 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num2 = 0;
        		scan.nextLine();
			}
		}
		
		result = num1 + num2;

		System.out.println("The result is: " + result);
	}
	
	private static void sub() {
		Scanner scan = new Scanner(System.in);
		double num1 = 0, num2 = 0, result;
		boolean check = false;
		
		System.out.println("Subtraction:");
		
		while(!check){
			try {
				System.out.println("Enter in first number");
				num1 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num1 = 0;
        		scan.nextLine();
			}
		}

		check = false;
		
		while(!check){
			try {
				System.out.println("Enter in second number");
				num2 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num2 = 0;
        		scan.nextLine();
			}
		}
		
		result = num1 - num2;

		System.out.println("The result is: " + result);
	}
	
	private static void mult() {
		Scanner scan = new Scanner(System.in);
		double num1 = 0, num2 = 0, result;
		boolean check = false;
		
		System.out.println("Multiplication:");
		
		while(!check){
			try {
				System.out.println("Enter in first number");
				num1 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num1 = 0;
        		scan.nextLine();
			}
		}

		check = false;
		
		
		while(!check){
			try {
				System.out.println("Enter in second number");
				num2 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num2 = 0;
        		scan.nextLine();
			}
		}
		
		result = num1 * num2;

		System.out.println("The result is: " + result);
	}
	
	private static void div() {
		Scanner scan = new Scanner(System.in);
		double num1 = 0, num2 = 0, result;
		boolean check = false;
		
		System.out.println("Division:");
		
		while(!check){
			try {
				System.out.println("Enter in first number");
				num1 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num1 = 0;
        		scan.nextLine();
			}
		}

		check = false;
		
		
		while(!check){
			try {
				System.out.println("Enter in second number");
				num2 = scan.nextDouble();
				check = true;
			}
			catch(Exception e) {
				System.out.println("Please enter a number.");
				num2 = 0;
        		scan.nextLine();
			}
		}
		
		result = num1 / num2;

		System.out.println("The result is: " + result);
	}
}
