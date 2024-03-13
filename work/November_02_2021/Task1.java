import java.util.Scanner;
public class Task1{
    public static int greatest(int n1, int n2, int n3)
    {
        if(n1 > n2){
            if(n1 > n3)
            {
                return n1;
            }
            else return n3;
        }
        else{
            if(n2 > n3) return n2;
            else return n3;
        }
    }
    public static void main(String args[]){
        
        Scanner inpt = new Scanner(System.in);
        int n1 = inpt.nextInt();
        int n2 = inpt.nextInt();
        int n3 = inpt.nextInt();
        System.out.println(""+greatest(n1,n2,n3));
    }
}
