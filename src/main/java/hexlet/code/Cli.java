package hexlet.code;
import java.util.Scanner;

public class Cli {

    public static String greetings() {
        Scanner in = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String name = in.nextLine();
        System.out.printf("Hello, %s! \n", name);

        return name;
    }
}
