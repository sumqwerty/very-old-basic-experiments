import java.util.*;
class Activity4 {
  
  public static void dispArr(int[] arr){
    for(int i=0; i<arr.length; ++i){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
  public static int addArr(int[] arr){
    int sum=0;
    for(int i=0; i<arr.length; ++i){
      sum += arr[i];
    }
    return sum;
  }

  public static void oddEv(int[] arr){
    String odd = "";
    String ev = "";

    for(int i=0; i<arr.length; ++i){
      if(arr[i] % 2 == 0){
        ev = ev + arr[i] + " ";
      }else{
        odd = odd + arr[i] + " ";
      }
    }
    System.out.println("Even Numbers in the arr: "+ev);
    System.out.println("Odd Numbers in the arr: "+odd);
  }


  public static void main(String args[]) {
    Scanner inpt = new Scanner(System.in);
    int[] arr = new int[5];
    System.out.println("Enter 5 numbers: ");
    for(int i=0; i<5; ++i){
      arr[i] = inpt.nextInt();
    }
    dispArr(arr);

    System.out.println("Enter 5 numbers: ");
    for(int i=4; i>=0; --i){
      arr[i] = inpt.nextInt();
    }
    dispArr(arr);

    System.out.println("Sum of the abover array: "+addArr(arr));

    oddEv(arr);

    System.out.println("Enter a 2d Matrix");
    int[][] mat = new int[5][5];
    for(int i=0; i<5; ++i)
      for(int j=0; j<5; ++j)
        mat[i][j] = inpt.nextInt();

    System.out.println("Enter element to search: ");
    int toFind = inpt.nextInt();
    boolean found=false;
    for(int i=0; i<5; ++i){
      found = false;
      for(int j=0; j<5; ++j){
        if(mat[i][j] == toFind){
          System.out.println(toFind+" is at ("+i+","+j+")");
          found=true;
          break;
        }
      }
      if(found)break;
    }
    if(!found){
      System.out.println("Not Found");
    }
  }
}
