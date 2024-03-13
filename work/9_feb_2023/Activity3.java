import java.util.*;
class Activity3 {
  static Scanner inpt = new Scanner(System.in);
  public static void printAlpha(){
    for(char ch='A'; ch<='Z'; ++ch){
      System.out.print(ch);
    }
    System.out.println();

    for (char ch='a'; ch<='z'; ++ch) {
      System.out.print(ch);
    }
    System.out.println();
  }
  public static void printAlphaR(){
    for(char ch='Z'; ch>='A'; --ch){
      System.out.print(ch);
    }
    System.out.println();

    for (char ch='z'; ch>='a'; --ch) {
      System.out.print(ch);
    }
    System.out.println();
  }
  public static void printAlpha2(){
    for(char ch='B'; ch<='Z'; ch+=2){
      System.out.print(ch);
    }
    System.out.println();

    for (char ch='b'; ch<='z'; ch+=2) {
      System.out.print(ch);
    }
    System.out.println();
  }

  public static int halfTimes(int num){
    int res = 0;
    while(num > 1){
      ++res;
      num = num/2;
    }
    return res;
  }

  public static void guessGame(){
    int rnum = ((int) (Math.random() * (100 - 1))) + 1;
    boolean gameOver = false;
    System.out.print("Guess the number: ");
    while(!gameOver){
      int guess = inpt.nextInt();
      if(guess == rnum){
        System.out.println("Yay you guessed it right!");
        gameOver = true;
        break;
      }
      else if(guess > rnum)System.out.println("Too High");
      else System.out.println("Too Low");
    }
  }


  public static void main(String args[]) {
    printAlpha();
    System.out.println();
    printAlphaR();
    System.out.println();
    printAlpha2();
    System.out.println();
    System.out.print("Enter a number: ");
    int num = inpt.nextInt();
    System.out.println(num+" can be halved "+halfTimes(num)+" times");
    System.out.println();
    guessGame();
  }
}
