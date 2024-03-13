import java.time.*;
import java.util.Scanner;
public class Activity2{
  public static boolean isLeap(int year){
    boolean leap = false;
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        // if year is divided by 400 then it is a leap year
        if (year % 400 == 0)
          leap = true;
        else
          leap = false;
      }
      else
        leap = true;
    }
    else
      leap = false;
    return leap;
  }
  public static int dateCheck(String date){
    LocalDate nw = LocalDate.now();
    LocalDate inpt = LocalDate.parse(date);
    if(nw.isBefore(inpt)){
      return 1;
    }else{
      return -1;
    }
  }
  public static boolean canVote(int age){
    if(age >= 18)return true;
    return false;
  }
  public static int largest(int a, int b, int c){
    if(a > b){
      if(a>c){
        return a;
      }
    }
    else if(b>c){
        return b;
    }
    return c;
  }

  public static String getMonth(int num){
    if(num == 1)return "January";    
    else if(num == 1)return "January";
    else if(num == 2)return "Febuary";
    else if(num == 3)return "March";
    else if(num == 4)return "April";
    else if(num == 5)return "May";
    else if(num == 6)return "June";
    else if(num == 7)return "July";
    else if(num == 8)return "August";
    else if(num == 9)return "September";
    else if(num == 10)return "October";
    else if(num == 11)return "November";
    else if(num == 12)return "December";
    else return "Enter a valid month number";
  }

  public static void main(String[] args){
    Scanner inpt = new Scanner(System.in);

    System.out.print("Enter year to check if its leap: ");
    int year = inpt.nextInt();
    System.out.println("Is "+ year + " a leap year: "+(isLeap(year)?"Yes":"No"));
    

    System.out.print("Enter date in YYYY-MM-DD format: ");
    String date = inpt.next();
    if(dateCheck(date) == 1){
      System.out.println(date+" comes after today");
    }else{
      System.out.println(date+" comes before today");
    }
    
    System.out.print("Enter age to check if eligible to vote: ");
    int age = inpt.nextInt();
    if(canVote(age))System.out.println("Can vote!");
    else System.out.println("Cannot vote!");

    
    System.out.println("Enter 3 numbers");
    int a = inpt.nextInt();
    int b = inpt.nextInt();
    int c = inpt.nextInt();
    System.out.println("Largest number is "+largest(a,b,c));

    System.out.print("Enter Month number: ");
    int num = inpt.nextInt();
    System.out.println(getMonth(num));

  }
}
