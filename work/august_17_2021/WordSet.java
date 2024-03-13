import java.util.*;

public class WordSet{

    public static void main(String[] args)
    {
        Scanner inpt = new Scanner(System.in);
        String str = inpt.nextLine();
        
        ArrayList<String> arr = new ArrayList<String>();
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        
        StringTokenizer st = new StringTokenizer(str," ");
        while (st.hasMoreTokens())
            hm.put(st.nextToken(),1);
                    for(String s: arr){
            System.out.println(s+" sorted");
        }
        for(Map.Entry m : hm.entrySet()){
            arr.add(m.getKey()+"");
        }
        String temp;
        for (int i = 0; i < arr.size(); i++) 
        {
            for (int j = i + 1; j < arr.size(); j++) { 
                if (arr.get(i).compareTo(arr.get(j))>0)
                {
                    temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
        
        // Print Sorted words
        for(String s: arr){
            System.out.println(s);
        }
        
    }

}
