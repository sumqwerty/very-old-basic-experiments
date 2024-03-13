import java.util.Scanner;


public class Test{
    
    public static int sumDigits(long n){
        int res = 0;
        
        while(n>0){
            res += n%10;
            n = n / 10;
        }
        
        return res;
    }
    
    public static void main(String args[]){
        Scanner inpt = new Scanner(System.in);
        
        System.out.print("Enter a digit: ");
        long n = inpt.nextLong();
        System.out.println(""+sumDigits(n));
    }

}
