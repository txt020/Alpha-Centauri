import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCalc {
    public TestCalc() {

    }

    // adds the two numbers and returns the answer
    private int add(int input1, int input2) {
        return input1 + input2;
    }

    // subtracts the two numbers and returns the answer
    private int subtract(int input1, int input2) {
        return input1 - input2;
    }

    // multiplies the two numbers and returns the answer
    private int multiply(int input1, int input2) {
        return input1 * input2;
    }

    // divides the two numbers and returns the answer
    private int divide(int input1, int input2) {
        return input1 / input2;
    }

/*    private void askForInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("please enter first value");
        int input1 = input.nextInt();
        System.out.println("please enter second value");
        int input2 = input.nextInt();
        System.out.println(add(input1, input2));
    }*/

    // used for when an error occurs and then goes back to the menu
    private void errorHandeling() {
        System.out.println("incorrect input");
        System.out.println("please enter a number");
        showMenu();
    }

    private void showMenu() {
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int input1 = 0;
        int input2 = 0;

        while (flag) {

            System.out.println("\n");
            System.out.println("_________________________________________________________________________");
            System.out.println("Please select the option number for operation you would like to perform");
            System.out.println("_________________________________________________________________________");
            System.out.println("1. add");
            System.out.println("2. multiply");
            System.out.println("3. subtract first number from second number");
            System.out.println("4. divide first number from second number");
            System.out.println("5. quit");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                errorHandeling();
            }

            try {
                System.out.println("please enter first value");
                input1 = input.nextInt();
                System.out.println("please enter second value");
                input2 = input.nextInt();
            } catch (InputMismatchException e) {
                errorHandeling();
            }


            switch (choice) {
                case 1: {
                    System.out.println(add(input1, input2));
                    break;
                }
                case 2: {
                    System.out.println(multiply(input1, input2));
                    break;
                }
                case 3: {
                    System.out.println(subtract(input1, input2));
                    break;
                }
                case 4: {
                    System.out.println(divide(input1, input2));
                    break;
                }
                case 5: {
//                    flag = false;
                    System.exit(0);
                    break;
//                    return;
                }
                default: {
                    System.out.println("incorrect input. Please try again!!!!!!!!!");
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {
        TestCalc testCalc = new TestCalc();
        try {
            testCalc.showMenu();
        } catch (Exception e) {
            System.out.println("Exception!!!!!!");
            System.out.println(e);
        }

    }
}
