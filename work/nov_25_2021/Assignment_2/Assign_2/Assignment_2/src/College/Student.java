package College;

public class Student {
	int studentID;
	String firstName;
	String lastName;
	String dob;
	String email;
	int midterm1score;
	int midterm2score;
	int assignment1score;
	int assignment2score;
	int assignment3score;
	int assignment4score;
	int assignment5score;
	int finalScore;
	String finalGrade;
	
	public boolean checkName(String name)
	{
		if(name.length()==0)return false;
		return true;
	}
	
	public boolean checkDate(String date)
	{
		String[] values = date.split("-");
		int year = Integer.parseInt(values[0]);
		int month = Integer.parseInt(values[1]);
		int day = Integer.parseInt(values[2]);
		
		if(month == 2)
		{
			if(day < 1 || day > 29)return false;
			
			//if it is not a leap year
			if(!(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)))
				if(day < 1 || day > 28)return false;
			
		}
		else if(month < 1 || month > 12 || day < 1 || day > 31)return false;
		return true;
	}
	
	public boolean checkScore(int score)
	{
		return (score>-1 && score<101);
	}
}
