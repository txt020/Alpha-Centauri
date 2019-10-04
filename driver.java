
import java.util.*;

//import static java.lang.System.exit;
//import static java.lang.System.setOut;

public class driver {
    //int choice = 90;
    //int number = 0

    public static int ad(int x, int y){
        int number = x + y;
        boolean flag = true;
        return number;

    }

    public static int times(int x, int y){
        int number =  y*x;
        boolean flag = true;
        return number;

    }


    public static void main(String args []){
        int out = 0;
        int choice = 90;
        int thing = 0;
        boolean flag = true;
        while(flag){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int user_input = in.nextInt();
        System.out.println("You entered : " + user_input);
        System.out.println("Enter another number");
        int use_in = in.nextInt();
        System.out.println("You entered : " + use_in);


            System.out.println("What would you like to do?");
            System.out.println(" 1.) add \n 2.) Multiply \n 3.) Quit");
            choice = in.nextInt();
            switch(choice){
            case(1): thing = ad(user_input, use_in);
                break;
            case(2):
                thing = times(user_input, use_in);
                break;
            case(3): System.exit(0);
                break;
            }
            System.out.println(thing);


        }









    }
}
