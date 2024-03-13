import java.util.Scanner;

public class SeatRes{

    static Scanner inpt = new Scanner(System.in);
    
    
    public static int chatToNum(char ch){
        if(ch == 'A')return 1;
        else if(ch == 'B')return 2;
        else if(ch == 'C')return 3;
        else if(ch == 'D')return 4;
        else if(ch == 'E')return 5;
        else return 0;
    }
    
    public static void main(String[] args){
        char[][] seats = new char[5][5];
        
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                seats[i][j] = 'E';
            }
        }
        
        while()
        System.out.print("Enter the row number. Input only values from 1 to 5 ");
        int n = inpt.nextInt();
        
        
        
        
    }
    
    
    public static void thanks(){
        
        int j = 1;
        for(int i=0; i<7;++i){
            for(int k=0; k<j; ++k){
                System.out.print("Thank you");
            }
            if(i>2)--j;
            else ++j;
            System.out.println();
        }
    }
}
