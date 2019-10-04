import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);


        Calculations calculator = new Calculations();
        System.out.print("put your first number: ");
        double number = user.nextInt();
        calculator.setFirstNumber(number);
        System.out.print("\nenter your second number: ");
        double number2 = user.nextInt();
        calculator.setSecondNumer(number2);

        System.out.println("which one would you like to do. \n 1. Add \n 2.Subtract \n 3.Multiply \n 4. Divide \n 5h.Quit");
        int choose = user.nextInt();

        switch (choose){

            case 1:
                System.out.println("\nThe result is: " + calculator.getAdditionResult());

                break;
            case 2:
                System.out.println("\nThe result is: " + calculator.getSubtractionResult());
                break;
            case 3:
                System.out.println("\nThe result is: " + calculator.getMultiplicationResult());
                break;
            case 4:
                System.out.println("\nThe result is " + calculator.getDivisionResult());
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid input");
                break;

        }
    }
}
