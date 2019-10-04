import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Calc {
    public static void main(String[]args) {
        int arg1 = 0, arg2 = 0, input = 0;
        Scanner Obj = new Scanner(System.in);
            try {
                System.out.println("Please enter Selection");
                System.out.println("1.) Addition");
                System.out.println("2.) Subtraction");
                System.out.println("3.) Mulitplication");
                System.out.println("4.) Division");
                input = Obj.nextInt();
            } catch (Exception e) {
                System.out.println("Please Enter Valid Selection");
            }
            switch (input) {
                case 1:
                    System.out.println("Please Enter Numbers to Add");
                    try {
                        arg1 = Obj.nextInt();
                        arg2 = Obj.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please Enter Valid Selection");
                    }
                    System.out.println("Result: " + Add(arg1, arg2));
                    break;
                case 2:
                    System.out.println("Please Enter Numbers to Subtract");
                    try {
                        arg1 = Obj.nextInt();
                        arg2 = Obj.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please Enter Valid Selection");

                    }
                    System.out.println("Result: " + Subtract(arg1, arg2));
                    break;
                case 3:
                    System.out.println("Please Enter Numbers to Multiply");
                    try {
                        arg1 = Obj.nextInt();
                        arg2 = Obj.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please Enter Valid Selection");
                    }
                    System.out.println("Result: " + Multiply(arg1, arg2));
                    break;
                case 4:
                    System.out.println("Please Enter Numbers to Divide");
                    try {
                        arg1 = Obj.nextInt();
                        arg2 = Obj.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please Enter Valid Selection");
                    }
                    if (arg2 == 0) {
                        System.out.println("Please Enter non Zero Divendend");
                    } else {
                        System.out.println("Result: " + Divide(arg1, arg2));
                    }
                    break;
                case 5:
                    System.out.println("Quitting Program");
                    default:
                    System.out.println("Please Enter Valid Selection");
            }
        }
    public static int Add (int number1, int number2){
        return number1+ number2;
    }
    public static int Subtract(int number1, int number2){
        return number1 - number2;
    }
    public static int Multiply ( int number1, int number2){
        return number1*number2;
    }
    public static int  Divide(int number1, int number2){
        if(number2==0){
            System.out.println("Error Cannot Divide By 0");
            return 0;
        }
        else{
            return number1/number2;
        }
    }
}
