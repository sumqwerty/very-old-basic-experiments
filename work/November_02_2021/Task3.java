import java.util.Scanner;
public class Task3{
    
    public static void main(String args[]){
        
        Scanner inpt = new Scanner(System.in);
        int num = inpt.nextInt();
        boolean res = false;
        for(int i=2; i<=num/2; ++i)
        {
            if(num%i == 0)
            {
                res = true;
                break;
            }
        }
        if(res)System.out.println("Not Prime");
        else System.out.println("Prime");
    }
}
