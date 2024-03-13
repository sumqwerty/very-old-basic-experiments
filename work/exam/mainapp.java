import java.util.Scanner;

public class mainapp implements Thankyou{

    static Scanner inpt = new Scanner(System.in);
    static int fst = 0;
    
    public void display(){
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
    
    
    public static int charToNum(char ch){
        if(ch == 'A')return 0;
        else if(ch == 'B')return 1;
        else if(ch == 'C')return 2;
        else if(ch == 'D')return 3;
        else if(ch == 'E')return 4;
        else return 0;
    }
    
    public static void main(String args[]){
        boolean ok = false;
        int r=0;
        char c = 'A';
        while(!ok)
        {
            System.out.print("Enter the row number. Input only values from 1 to 5 ");
            r = inpt.nextInt();
            
            if(r>5)continue;
            else ok = true;
        }
        ok = false;
        while(!ok)
        {
            System.out.print("Enter the column number. Input only values from A to F ");
            c = inpt.next().charAt(0);
            if(c>'F')continue;
            else ok=true;
        }
        seats st = new seats(r-1,charToNum(c));
        
        
        boolean resMore = true;
        while(resMore){
            if(fst == 1){
                System.out.print("Enter the row number. Input only values from 1 to 5 ");
                r = inpt.nextInt();
            
                System.out.print("Enter the column number. Input only values from A to F ");
                c = inpt.next().charAt(0);
                
                
                if(st.seat[r][c] == 'X'){
                    System.out.println("Occupied");
                    continue;
                }
                st.resSeats(r-1,charToNum(c));
            }
            st.dispSeats();
            
            matinee mt = new matinee(r-1,charToNum(c),st.seat);
            regular rg = new regular(r-1,charToNum(c),st.seat);
            
            if(r==1)mt = new matinee(r-1,charToNum(c),st.seat);
            else rg = new regular(r-1,charToNum(c),st.seat);
            
            System.out.println("You have purchased "+mt.matineePurch() + " matinee seat/s");
            System.out.println("You have purchased "+rg.regularPurch() + " regular seat/s");
            System.out.println("Your total bill is "+(mt.matineePurch()*mt.getTicketPrice() + rg.regularPurch()*rg.getTicketPrice()));
            
            System.out.print("Do you want to make more reservations? Type Y for yes and N for no ");
            c = inpt.next().charAt(0);
            if(c=='N')resMore = false;
            fst = 1;
            
        }
        mainapp mn = new mainapp();
        mn.display();
    }

}



interface Thankyou{
    void display();
}
