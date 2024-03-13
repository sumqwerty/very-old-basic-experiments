import java.util.Scanner;
public class Gradebook{
    public Scanner inpt = new Scanner(System.in);
    public double math;
    public double science;
    public double language;
    
    public Gradebook()
    {
        for(int i=0; i<3; ++i)
        {
            String sub = "";
            if(i==0)sub="math";
            else if(i==1)sub="science";
            else sub="language";
            
            double mark;
            boolean valid = false;
            while(!valid)
            {
                System.out.print(sub+": ");
                mark = inpt.nextDouble();
                if(mark >= 0 && mark <= 100)
                {
                    valid=true;
                    if(i==0)math=mark;
                    else if(i==1)science=mark;
                    else language=mark;
                }
                else System.out.println("Enter valid grade(between 0 & 100)");
            }
            
        }
    }
    
    public double calculateTotal()
    {
        return (math+science+language);
    }
    
    public double calculatePercentage()
    {
        return calculateTotal()/3;
    }
    
    public String finalGrade()
    {
        if(calculatePercentage() < 60)return "FAIL";
        else return "PASS";
    }
    
    public void displayGrades()
    {
        System.out.println("total would be: "+calculateTotal());
        System.out.println("percentage would be: "+calculatePercentage()+"%");
        System.out.println("final grade would be: "+finalGrade());
    }
    
    
    public static void main(String args[])
    {
        Gradebook S01 = new Gradebook();
        S01.displayGrades();
        Gradebook S02 = new Gradebook();
        S02.displayGrades();
        Gradebook S03 = new Gradebook();
        S03.displayGrades();
        
    }
}
