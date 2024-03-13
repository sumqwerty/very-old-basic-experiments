import java.util.*;

public class EmployeeMap
{
    static ArrayList<Employee> employees = new ArrayList<Employee>(); // to store employee objects
    
    public static void add(int id, String name)
    {
        Employee temp = new Employee(id,name);
        employees.add(temp);
    }
    
    public static void remove(int id)
    {   
        int pos = 0;
        for(Employee e : employees){
            if(e.id == id)break;
            pos += 1;
        }
        employees.remove(pos);
        System.out.println("Removed employee "+id);
    }
    
    public static Employee copy(int id)
    {
        Employee temp = null;
        for(Employee e : employees){
            if(e.id == id)
            {
                temp = new Employee(e);
            }
        }
        return temp;
    }
    
    public static boolean found(int id)
    {
        boolean found  = false;
        
        for(Employee e : employees)
        {
            if(e.id == id)
            {
                found=true;
                break;
            }
        }
        
        return found;
    }
    
    public static void EmployeeDetails(int id)
    {
        
        if(found(id) == false)System.out.println("No Employee fodund with employee number "+id);
        
        else
        {
            
            for(Employee e : employees)
            {
                if(e.id == id)
                {
                    System.out.println("Employee ID:   "+e.id);
                    System.out.println("Employee Name: "+e.name);
                    break;
                }
                
            }
        }
    }
    
    public static void AllEmployees()
    {
        for(Employee e : employees)
        {
            System.out.println("Employee ID:   "+e.id);
            System.out.println("Employee Name: "+e.name);
            System.out.println();
            
        }
    }
    
    public static void main(String args[])
    {
        // add employees to the list
        add(101,"Qwerty");
        add(102,"Luffy");
        add(103,"Kid");
        add(104,"Amanda");
        add(105,"Queen");
        
        // display all employees
        System.out.println("All Employees");
        AllEmployees();
        
        //get a specific employee
        System.out.println();
        int id = 102;
        System.out.println("Employee : "+id);
        EmployeeDetails(id);
        
        //remove employee
        System.out.println();
        id = 101;
        remove(id);
        System.out.println("After removing employee "+id);
        AllEmployees();
        
        // copy of an employee
        System.out.println();
        id = 104;
        Employee cp_emp = copy(id);
        System.out.println("Details of copied employee");
        System.out.println("Copied Employee ID: "+cp_emp.id);
        System.out.println("Copied Employee Name: "+cp_emp.name);
        
        
        //Look for an employee
        System.out.println();
        if(found(104)) System.out.println("True. Employee " + 104 +  " Found");
        else System.out.println("False. Employee Not Found");
        
        if(found(110)) System.out.println("True. Employee " + 110 + " Found");
        else System.out.println("False. Employee Not Found");
    }
}

class Employee{
    
    int id;
    String name;
    
    Employee(int _id, String _name)
    {
        id = _id;
        name = _name;
    }
    
    Employee(Employee other){
        this.id = other.id;
        this.name = other.name;
    }
    
}
