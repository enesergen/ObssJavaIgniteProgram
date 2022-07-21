import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the your age:");
        int value = scan.nextInt();
        if(value<=25)
            System.out.println("You are young.");
        else
            System.out.println("You are old.");
    }
}
