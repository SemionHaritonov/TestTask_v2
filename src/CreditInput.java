import java.util.Scanner;

public class CreditInput {
    static String[] inputData() {
        Scanner in = new Scanner(System.in);
        String inputData = in.nextLine();
        in.close();
        inputData = inputData.trim();
        return inputData.split(" ", 4);
    }
}