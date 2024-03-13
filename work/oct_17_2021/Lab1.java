import java.util.*;
import java.lang.*;

public class Lab1{
    static Scanner inpt  = new Scanner(System.in);
    public static void main(String args[])
    {
        double investment;
        double annualInterestRate;
        int numberOfYears;
        double futureValue;
        
        System.out.print("Enter investment amount: ");
        investment = inpt.nextDouble();
        
        
        System.out.print("Enter interest rate in percentage: ");
        annualInterestRate = inpt.nextDouble();
        double monthlyInterestRate = annualInterestRate/12;
        
        System.out.print("Enter number of years: ");
        numberOfYears = inpt.nextInt();
        
        
        futureValue = investment * Math.pow((1 + monthlyInterestRate),(numberOfYears*12));
        //futureValue = Math.pow(3,2);
        System.out.println("Future Value is "+String.format("%.2f", futureValue));
        
        
    }

}
