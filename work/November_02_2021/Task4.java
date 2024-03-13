import java.util.Scanner;
public class Task4{
    public static void main(String args[]){
        
        Scanner inpt = new Scanner(System.in);
        double n1 = inpt.nextDouble();
        double n2 = inpt.nextDouble();
        double sum = 0;
        for(double i=n1; i<n2; i=i+2)
        {
            double res = i/(i+2);
            sum += res;
            System.out.println((int)i+"/"+(int)(i+2));
        }
        System.out.println("Sum: "+sum);
    }
}
