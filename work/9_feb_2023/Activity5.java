import java.util.*;
class Activity5 {
  static Scanner inpt = new Scanner(System.in);
  public static void greet(String name){
    System.out.println("Hello "+name);
  }
  public static int product(int a, int b){
    return a*b;
  }

  public static double calcVat(){
    System.out.println("Enter price");
    double price = inpt.nextDouble();
    System.out.println("Enter VAT in %");
    double vt = inpt.nextDouble();
    double fin = price + (price*(vt/100));
    return fin;
  }

  public static boolean isPalindrome(String st){
    for(int i=0; i<st.length(); ++i){
      if(st.charAt(i) != st.charAt(st.length()-1-i))return false;
    }
    return true;
  }

  public static void main(String args[]) {
    System.out.print("Enter your name: ");
    String name = inpt.next();
    greet(name);

    System.out.println("Enter two numbers ");
    int a=inpt.nextInt();
    int b=inpt.nextInt();
    System.out.println("Product of the above two numbers is "+product(a,b));
   
    double finalPrice = calcVat();
    System.out.println("Final price is " + finalPrice);

    String st = inpt.next();
    if(isPalindrome(st))System.out.println("Palindrome");
    else System.out.println("Not a Palindrome");
  }
}
