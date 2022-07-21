import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        double grade=0,result=0;
        int count=0;
        System.out.print("Enter the grade:");
        grade=scan.nextInt();
        result+=grade;
        count++;
        while(!(grade==101)){
            System.out.print("Enter the grade:");
            grade=scan.nextInt();
            if(grade==101)
                continue;
            result+=grade;
            count++;

        }
        if ((result/count)==101){
            System.out.println("Result: Null");
        }else
            System.out.println("Result:"+result/count);



    }
}
