import java.util.Scanner;
import java.lang.Math;
class Activity7 {
    public static void driver() {
        Scanner inpt = new Scanner(System.in);
        while(true){
            System.out.println("Chose a calculator");
            System.out.println("1. Basic Calculator");
            System.out.println("2. Advance Calculator");
            System.out.println("0. Exit");
            int ch = inpt.nextInt();
            if(ch == 1){
                Calculator obj = new Calculator();
                obj.mainLoop();
            }else if(ch == 2){
                AdvCalculator obj = new AdvCalculator();
                obj.mainLoop();
            }else break;
        }
    }
}


class Calculator{
    public Scanner inpt;
    public boolean gameOver; // variable to keep the menu system in a loop
    public String[] hist; // array to store history of calculations
    public int histCount; // number of calculations in the history

    public Calculator(){
        inpt = new Scanner(System.in);
        hist = new String[100];
        gameOver = false; // keep the calculator running
        histCount=0;
    }

    public void Add(double a, double b){
        double res = a+b;
        System.out.println(res);
        hist[histCount++] = ""+a+"+"+b+"="+res; // adding this calculation to the history array
    }
    public void Sub(double a, double b){
        double res = a-b;
        System.out.println(res);
        hist[histCount++] = ""+a+"-"+b+"="+res; // adding this calculation to the history array
    }
    public void mult(double a, double b){
        double res = a*b;
        System.out.println(res);
        hist[histCount++] = ""+a+"*"+b+"="+res; // adding this calculation to the history array
    }
    public void divide(double a, double b){
        double res = a/b;
        System.out.println(res);
        hist[histCount++] = ""+a+"/"+b+"="+res;
    }

    public void history(){ // displaying all the strings in the history arr
        System.out.println("\n########### HISTORY ###########");
        for(int i=0; i<histCount; ++i){
            System.out.println(i+1+". "+hist[i]);
        }
        System.out.println("########### ####### ###########");
    }

    public int menu(){ // Menu system for basic calculator
        System.out.println("\nBasic Calculator");
        System.out.println("Choose the operation");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. History");
        System.out.println("0. Exit Calculator");
        System.out.print("> ");
        int choice = inpt.nextInt(); // user enters his choice
        return choice;
    }
    // function to do the calculation depending upon what the user has chosen in the menu
    // ch is the choice passed by menu() function
    public boolean draw(int ch){
        if(ch == 0)return true;
        double a=0,b=0;
        if(ch < 5){
            System.out.println("Enter operands");
            System.out.print("> ");
            a = inpt.nextDouble();
            b = inpt.nextDouble();
        }
        System.out.print("= ");
        if(ch == 1)Add(a,b);
        else if(ch == 2)Sub(a,b);
        else if(ch==3)mult(a,b);
        else if(ch==4)divide(a,b);
        else if(ch==5)history();
        return false;
    }

    public void mainLoop(){ // main loop that keeps the calculator running
        while(!gameOver){
            gameOver = draw(menu()); // menu() returns the choice of the users and passes this to draw
            // draw returns a boolean value of true is the user has exited out or else false.
            if(histCount >= 100)histCount=0; // if the records in the history reaches 100 start overwriting
            //ealiest records. History limits is 100
        }
    }
}

class AdvCalculator extends Calculator{ // this is a sub class of Calculator

    public AdvCalculator(){
        super();
    }
    public void fact(double n){ // driver function of factorial calculations
        double res = _fact(n);
        System.out.println(res);
        hist[histCount++] = ""+n+"! "+"="+res; // adding to the history
    }
    public double _fact(double n){ // recursive factorial calculations
        if(n == 0 || n == 1)return 1;
        return n * _fact(n-1);
    }

    // trig functions
    public void sin(double a){
        double res = Math.sin(a);
        System.out.println(res);
        hist[histCount++] = "sin("+a+")"+"="+res;

    }
    public void cos(double a){
        double res = Math.cos(a);
        System.out.println(res);
        hist[histCount++] = "cos("+a+")"+"="+res;

    }
    public void tan(double a){
        double res = Math.tan(a);
        System.out.println(res);
        hist[histCount++] = "tan("+a+")"+"="+res;

    }
    public void power(double a, double b){
        double res = Math.pow(a,b);
        System.out.println(res);
        hist[histCount++] = ""+a+" power "+b+"="+res;
    }

    public int menu(){ // menu for advanced calculator
        System.out.println("\nAdvance Calculator");
        System.out.println("Choose the operation");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. sin");
        System.out.println("6. cos");
        System.out.println("7. tan");
        System.out.println("8. Factorial");
        System.out.println("9. Power");
        System.out.println("10. History");
        System.out.println("0. Exit Calculator");
        System.out.print("> ");
        int choice = inpt.nextInt();
        return choice;
    }

    public boolean draw(int ch){ // function to do the calculation depending upon what the user has chosen in the menu
        if(ch == 0)return true;
        double a=0,b=0;
        if(ch < 5 || ch == 9){
            System.out.println("Enter operands");
            System.out.print("> ");
            a = inpt.nextDouble();
            b = inpt.nextDouble();
        }
        else if(ch >= 5 && ch <= 8){
            System.out.print("> ");
            a = inpt.nextDouble();
        }
        System.out.print("= ");
        if(ch == 1)Add(a,b);
        else if(ch == 2)Sub(a,b);
        else if(ch==3)mult(a,b);
        else if(ch==4)divide(a,b);
        else if(ch==5)sin(a);
        else if(ch==6)cos(a);
        else if(ch==7)tan(a);
        else if(ch==8)fact(a);
        else if(ch==9)power(a,b);
        else if(ch==10)history();
        return false;
    }
}
