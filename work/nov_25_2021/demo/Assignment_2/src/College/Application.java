package College;
import java.sql.*;
import java.util.Scanner;
public class Application {
	
	public static String prompt = "input>> "; // prompt message to show on each new line of the CLI
	public static Connection con;
	public static Statement st;
	public static int studentCount=0;
	Scanner inpt;
	
	public static int inputInt(Scanner sc)
	{
		int x = sc.nextInt();
		sc.nextLine();
		return x;
	}
	
	public Student dataToStudent(int id) throws Exception
	{
		Student stud = new Student();
		ResultSet rs = st.executeQuery("select * from Students where studentID="+id+";");
		while(rs.next())
		{
			stud.studentID = rs.getInt("studentID");
			stud.firstName = rs.getString("firstName");
			stud.lastName = rs.getString("lastName");
			stud.dob = ""+rs.getDate("DOB");
			stud.email=rs.getString("email");
			stud.midterm1score=rs.getInt("mid1score");
			stud.midterm2score=rs.getInt("mid2score");
			stud.assignment1score=rs.getInt("assign1score");
			stud.assignment2score=rs.getInt("assign2score");
			stud.assignment3score=rs.getInt("assign3score");
			stud.assignment4score=rs.getInt("assign4score");
			stud.assignment5score=rs.getInt("assign5score");			
		}
		return stud;
	}
	
	public void calcFinalScore(Student stud)
	{
		double mid1percentage = (stud.midterm1score/100.0) * 25.0;
		double mid2percentage = (stud.midterm2score/100.0) * 25.0;
		double assignment1percentage = (stud.assignment1score/100.0) * 10.0;
		double assignment2percentage = (stud.assignment2score/100.0) * 10.0;
		double assignment3percentage = (stud.assignment3score/100.0) * 10.0;
		double assignment4percentage = (stud.assignment4score/100.0) * 10.0;
		double assignment5percentage = (stud.assignment5score/100.0) * 10.0;
		stud.finalScore = (int) Math.round(mid1percentage + mid2percentage + assignment1percentage + assignment2percentage + assignment3percentage + assignment4percentage + assignment5percentage);
	}
	
	public String getGrade(int Score)
	{
		if(Score>=90 && Score<=100)return "A+";
		if(Score>=85 && Score<=89)return "A";
		if(Score>=80 && Score<=84)return "A-";
		
		if(Score>=77 && Score<=79)return "B+";
		if(Score>=73 && Score<=76)return "B";
		if(Score>=70 && Score<=72)return "B-";
		
		if(Score>=67 && Score<=69)return "C+";
		if(Score>=63 && Score<=66)return "C";
		if(Score>=60 && Score<=62)return "C-";
		
		if(Score>=57 && Score<=59)return "D+";
		if(Score>=53 && Score<=56)return "D";
		if(Score>=50 && Score<=52)return "D-";
		
		return "F";
	}
	
	public String format(String label, int sz) throws Exception
	{
		String space="    ";
		for(int j=0; j<(sz-label.length()); ++j)space=" "+space;
		return (label+space);
	}
	
	public void addNewStudent() throws Exception{
		Student stud = new Student();
		System.out.println("\nENTER FOLLOWING DETAILS OF THE STUDENT:");
		
		
		// input student data
		
		System.out.print("First name: "); // first name
		stud.firstName = inpt.nextLine();
		while(!stud.checkName(stud.firstName)){
			System.out.println("ERROR: First name cannot be empty!!! ENTER A VALID NAME.");
			System.out.print("First name: ");
			stud.firstName = inpt.nextLine();
		}
		
		System.out.print("Last name: "); // last name
		stud.lastName = inpt.nextLine();
		while(!stud.checkName(stud.lastName)){
			System.out.println("ERROR: Last name cannot be empty!!! ENTER A VALID NAME.");
			System.out.print("Last name: ");
			stud.lastName = inpt.nextLine();
		}
		
		
		System.out.print("Date of birth(YYYY-MM-DD): "); // date of birth
		stud.dob = inpt.nextLine();
		while(!stud.checkDate(stud.dob))
		{
			System.out.println("ERROR: Please check the format and values of the date!!! ENTER A VALID DATE.");
			System.out.print("Date of birth(YYYY-MM-DD): ");
			stud.dob = inpt.nextLine();
		}
		
		System.out.print("Midterm 1 score: ");  // midterm 1
		stud.midterm1score = inputInt(inpt);
		while(!stud.checkScore(stud.midterm1score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Midterm 1 score: ");
			stud.midterm1score = inputInt(inpt);
		}
		
		System.out.print("Midterm 2 score: ");  // midterm 2
		stud.midterm2score = inputInt(inpt);
		while(!stud.checkScore(stud.midterm1score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Midterm 2 score: ");
			stud.midterm2score = inputInt(inpt);
		}
		
		System.out.print("Assignment 1 score: "); // assignment 1
		stud.assignment1score = inputInt(inpt);
		while(!stud.checkScore(stud.assignment1score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Assignment 1 score: ");
			stud.assignment1score = inputInt(inpt);
		}
		
		System.out.print("Assignment 2 score: "); // assignment 2
		stud.assignment2score = inputInt(inpt);
		while(!stud.checkScore(stud.assignment2score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Assignment 2 score: ");
			stud.assignment2score = inputInt(inpt);
		}
		
		System.out.print("Assignment 3 score: "); // assignment 3
		stud.assignment3score = inputInt(inpt);
		while(!stud.checkScore(stud.assignment3score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Assignment 3 score: ");
			stud.assignment3score = inputInt(inpt);
		}
		
		System.out.print("Assignment 4 score: "); // assignment 4
		stud.assignment4score = inputInt(inpt);
		while(!stud.checkScore(stud.assignment4score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Assignment 4 score: ");
			stud.assignment4score = inputInt(inpt);
		}
		
		System.out.print("Assignment 5 score: "); // assignment 5
		stud.assignment5score = inputInt(inpt);
		while(!stud.checkScore(stud.assignment5score))
		{
			System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
			System.out.print("Assignment 5 score: ");
			stud.assignment5score = inputInt(inpt);
		}
		
		// generating student's email address
		int mon = Integer.parseInt(stud.dob.split("-")[1]);
		if(mon < 10) stud.email= stud.firstName+"0"+(stud.dob.split("-")[1])+stud.lastName+"@algomail.com";
		else stud.email= stud.firstName+(stud.dob.split("-")[1])+stud.lastName+"@algomail.com";
		
		// calculating final score
		calcFinalScore(stud);
		
		
		// calculate final grade
		stud.finalGrade = getGrade(stud.finalScore);
		
		
		// generating student's id
		ResultSet rs=st.executeQuery("select count(*) as numberOfStudents from Students"); // gets the count of students
		rs.next(); // read the output
		stud.studentID = rs.getInt("numberOfStudents")+1; // generating student id on the basis of student count
		
		String query = "insert into Students values("+stud.studentID+",'"+stud.firstName+"','"+stud.lastName+"',STR_TO_DATE('"+stud.dob+"','%Y-%m-%d'),'"+stud.email+"',"+stud.midterm1score+","+stud.midterm2score+","
				+stud.assignment1score+","+stud.assignment2score+","+stud.assignment3score+","+stud.assignment4score+","+stud.assignment5score+","+stud.finalScore+",'"+stud.finalGrade+"');";
		
		
		// execute update query to insert new student in the database
		st.executeUpdate(query);
		++studentCount;
		System.out.print("\n\n");
		
	}
	
	public void findStudent() throws Exception
	{
		System.out.print("\nEnter Student's ID: ");
		int id = inputInt(inpt);
		ResultSet rs = st.executeQuery("select * from Students where studentID="+id+";");
		boolean displayed = false;
		while(rs.next())
		{
			displayed = true;
			System.out.println("\nStudent ID:\t\t\t"+rs.getInt("studentID"));
			System.out.println("First Name:\t\t\t"+rs.getString("firstName"));
			System.out.println("Last Name:\t\t\t"+rs.getString("lastName"));
			System.out.println("Date of birth:\t\t\t"+rs.getDate("DOB"));
			System.out.println("Email Address:\t\t\t"+rs.getString("email"));
			System.out.println("Midterm 1 score:\t\t\t"+rs.getInt("mid1score"));
			System.out.println("Midterm 2 score:\t\t\t"+rs.getInt("mid2score"));
			System.out.println("Assignment 1 score:\t\t\t"+rs.getInt("assign1score")+"\nAssignment 2 score:\t\t\t"+rs.getInt("assign2score")+"\nAssignment 3 score:\t\t\t"+rs.getInt("assign3score")+"\nAssignment 4 score:\t\t\t"+rs.getInt("assign4score")+"\nAssignment 5 score:\t\t\t"+rs.getInt("assign5score"));			
			System.out.println("Final Score:\t\t\t"+rs.getInt("finalScore"));
			System.out.println("Final Grade:\t\t\t"+rs.getString("finalGrade"));
		}
		if(!displayed) {
			System.out.println("No student with ID "+id+" found in the database.");
		}
		System.out.print("\n\n");
	}
	
	public void editStudentData() throws Exception
	{
		boolean updateEmail = false;
		boolean updateScore = false;
		Student stud ;
		System.out.print("\nEnter Student's ID: ");
		int id = inputInt(inpt);
		ResultSet rs=st.executeQuery("select count(*) as numberOfStudents from Students where studentID="+id+";"); // gets the count of students
		rs.next(); // read the output
		if(rs.getInt("numberOfStudents")==0)System.out.println("ERROR: Wrong student ID!!! No student with id "+id+" exists in the database"); 
		else
		{
			
			stud = dataToStudent(id);
			System.out.println("\nUpdate Menu -->\tProfessor, please choose the field you want to update:\n");
			System.out.println("\t\t1) First name");
			System.out.println("\t\t2) Last name");
			System.out.println("\t\t3) Date of Birth");
			System.out.println("\t\t4) Midterm 1 score");
			System.out.println("\t\t5) Midterm 2 score");
			System.out.println("\t\t6) Assignment 1 score");
			System.out.println("\t\t7) Assignment 2 score");
			System.out.println("\t\t8) Assignment 3 score");
			System.out.println("\t\t9) Assignment 4 score");
			System.out.println("\t\t10) Assignment 5 score");

			System.out.print("field> ");
			int dataChoosen = inputInt(inpt);
			if (dataChoosen == 1) {
				System.out.print("Student's first name: "); // first name
				stud.firstName = inpt.nextLine();
				updateEmail = true;
				while(!stud.checkName(stud.firstName)){
					System.out.println("ERROR: First name cannot be empty!!! ENTER A VALID NAME.");
					System.out.print("Student's first name: ");
					stud.firstName = inpt.nextLine();
				}
				st.executeUpdate("update Students set firstName='" + stud.firstName + "' where studentID=" + id + ";");


			} else if (dataChoosen == 2) {
				System.out.print("Student's last name: "); // last name
				stud.lastName = inpt.nextLine();
				updateEmail = true;
				while(!stud.checkName(stud.lastName)){
					System.out.println("ERROR: Last name cannot be empty!!! ENTER A VALID NAME.");
					System.out.print("Student's Last name: ");
					stud.lastName = inpt.nextLine();
				}
				st.executeUpdate("update Students set lastName='" + stud.lastName + "' where studentID=" + id + ";");


			} else if (dataChoosen == 3) {
				System.out.print("Student's date of birth(YYYY-MM-DD): "); // date of birth
				stud.dob = inpt.nextLine();
				updateEmail = true;
				while(!stud.checkDate(stud.dob))
				{
					System.out.println("ERROR: Please check the format and values of the date!!! ENTER A VALID DATE.");
					System.out.print("Student's date of birth(YYYY-MM-DD): ");
					stud.dob = inpt.nextLine();
				}
				st.executeUpdate("update Students set DOB=STR_TO_DATE('" + stud.dob + "','%Y-%m-%d') where studentID="+ id + ";");


			}

			else if (dataChoosen == 4) {
				System.out.print("Student's Midterm 1 score: ");  // midterm 1
				stud.midterm1score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.midterm1score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Midterm 1 score: ");
					stud.midterm1score = inputInt(inpt);
				}
				st.executeUpdate("update Students set mid1score=" + stud.midterm1score + " where studentID=" + id + ";");


			} else if (dataChoosen == 5) {
				System.out.print("Student's Midterm 2 score: ");  // midterm 2
				stud.midterm2score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.midterm1score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Midterm 2 score: ");
					stud.midterm2score = inputInt(inpt);
				}
				st.executeUpdate("update Students set mid2score=" + stud.midterm2score + " where studentID=" + id + ";");


			} else if (dataChoosen == 6) {

				System.out.print("Student's Assignment 1 score: "); // assignment 1
				stud.assignment1score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.assignment1score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Assignment 1 score: ");
					stud.assignment1score = inputInt(inpt);
				}	
				st.executeUpdate("update Students set assign1score=" + stud.assignment1score + " where studentID=" + id + ";");


			} else if (dataChoosen == 7) {

				System.out.print("Student's Assignment 2 score: "); // assignment 2
				stud.assignment2score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.assignment2score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Assignment 2 score: ");
					stud.assignment2score = inputInt(inpt);
				}	
				st.executeUpdate("update Students set assign2score=" + stud.assignment2score + " where studentID=" + id + ";");


			} else if (dataChoosen == 8) {

				System.out.print("Student's Assignment 3 score: "); // assignment 3
				stud.assignment3score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.assignment3score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Assignment 3 score: ");
					stud.assignment3score = inputInt(inpt);
				}
				st.executeUpdate("update Students set assign3score=" + stud.assignment3score + " where studentID=" + id + ";");


			} else if (dataChoosen == 9) {

				System.out.print("Student's Assignment 4 score: "); // assignment 4
				stud.assignment4score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.assignment4score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Assignment 4 score: ");
					stud.assignment4score = inputInt(inpt);
				}	
				st.executeUpdate("update Students set assign4score=" + stud.assignment4score + " where studentID=" + id + ";");


			} else if (dataChoosen == 10) {

				System.out.print("Student's Assignment 5 score: "); // assignment 5
				stud.assignment5score = inputInt(inpt);
				updateScore = true;
				while(!stud.checkScore(stud.assignment5score))
				{
					System.out.println("ERROR: Score cannot be a negative value or higher than 100!!! ENTER A VALID SCORE.");
					System.out.print("Student's Assignment 5 score: ");
					stud.assignment5score = inputInt(inpt);
				}
				st.executeUpdate("update Students set assign5score=" + stud.assignment5score + " where studentID=" + id + ";");


			}
			
			
			if(updateEmail) {
				// generating student's email address
				int mon = Integer.parseInt(stud.dob.split("-")[1]);
				if(mon < 10) stud.email= stud.firstName+"0"+(stud.dob.split("-")[1])+stud.lastName+"@algomail.com";
				else stud.email= stud.firstName+(stud.dob.split("-")[1])+stud.lastName+"@algomail.com";
				
				
				st.executeUpdate("update Students set email='" + stud.email + "' where studentID=" + id + ";");
				
			}
			if(updateScore)
			{
				// calculating final score
				calcFinalScore(stud);
				
				
				// calculate final grade
				stud.finalGrade = getGrade(stud.finalScore);
				
				st.executeUpdate("update Students set finalScore=" + stud.finalScore + " where studentID=" + id + ";");
				st.executeUpdate("update Students set finalGrade='" + stud.finalGrade + "' where studentID=" + id + ";");
			}
			
			
		}
		System.out.print("\n\n");
	}
	
	
	public void viewAllStudents() throws Exception
	{
		ResultSet rs = st.executeQuery("select * from Students;");
		String heading[] = {"ID","FIRST NAME","LAST NAME","DATE OF BIRTH","EMAIL","MIDTERM 1","MIDTERM 2",
				"ASSIGNMENT 1","ASSIGNMENT 2","ASSIGNMENT 3","ASSIGNMENT 4","ASSIGNMENT 5","FINAL SCORE","FINAL GRADE"};
		String ids[] = new String[studentCount];
		String fname[] = new String[studentCount];
		String lname[] = new String[studentCount];
		String dob[] = new String[studentCount];
		String email[] = new String[studentCount];
		String mid1score[] = new String[studentCount];
		String mid2score[] = new String[studentCount];
		String assign1score[] = new String[studentCount];
		String assign2score[] = new String[studentCount];
		String assign3score[] = new String[studentCount];
		String assign4score[] = new String[studentCount];
		String assign5score[] = new String[studentCount];
		String finalScore[] = new String[studentCount];
		String finalGrade[] = new String[studentCount];
		
		
		int sz[] = new int[14];
		for(int i=0; i<14; ++i)sz[i] = heading[i].length();
		
		boolean displayed = false;
		int iter = 0;
		while(rs.next())
		{
			displayed = true;
			ids[iter] = rs.getInt("studentID")+"";
			if(sz[0] < ids[iter].length())sz[0]=ids[iter].length();
			
			fname[iter] = rs.getString("firstName");
			if(sz[1] < fname[iter].length())sz[1]=fname[iter].length();
			
			lname[iter] = rs.getString("lastName");
			if(sz[2] < lname[iter].length())sz[2]=lname[iter].length();
			
			dob[iter] = rs.getDate("DOB")+"";
			if(sz[3] < dob[iter].length())sz[3]=dob[iter].length();
			
			email[iter] = rs.getString("email");
			if(sz[4] < email[iter].length())sz[4]=email[iter].length();
			
			mid1score[iter] = rs.getInt("mid1score")+"";
			if(sz[5] < mid1score[iter].length())sz[5]=mid1score[iter].length();
			
			mid2score[iter] = rs.getInt("mid2score")+"";
			if(sz[6] < mid2score[iter].length())sz[6]=mid2score[iter].length();
			
			assign1score[iter] = rs.getInt("assign1score")+"";
			if(sz[7] < assign1score[iter].length())sz[7]=assign1score[iter].length();
			
			assign2score[iter] = rs.getInt("assign2score")+"";
			if(sz[8] < assign2score[iter].length())sz[8]=assign2score[iter].length();
			
			assign3score[iter] = rs.getInt("assign3score")+"";
			if(sz[9] < assign3score[iter].length())sz[9]=assign3score[iter].length();
			
			assign4score[iter] = rs.getInt("assign4score")+"";
			if(sz[10] < assign4score[iter].length())sz[10]=assign4score[iter].length();
			
			assign5score[iter] = rs.getInt("assign5score")+"";
			if(sz[11] < assign5score[iter].length())sz[11]=assign5score[iter].length();
			
			finalScore[iter] = rs.getInt("finalScore")+"";
			if(sz[12] < finalScore[iter].length())sz[12]=finalScore[iter].length();
			
			finalGrade[iter] = rs.getString("finalGrade");
			if(sz[13] < finalGrade[iter].length())sz[13]=finalGrade[iter].length();
			
			++iter;
		}
		
		
		
		if(!displayed) {
			System.out.println("\nNO STUDENTS IN THE DATABASE!");
		}
		else{
			System.out.println();
			for(int i=0; i<14; ++i)
			{
				System.out.print(format(heading[i],sz[i]));
			}
			System.out.println();
			for(int i=0; i<studentCount; ++i)
			{
				System.out.println(format(ids[i],sz[0])+format(fname[i],sz[1])+format(lname[i],sz[2])+
						format(dob[i],sz[3])+format(email[i],sz[4])+format(mid1score[i],sz[5])+format(mid2score[i],sz[6])+
						format(assign1score[i],sz[7])+format(assign2score[i],sz[8])+format(assign3score[i],sz[9])+
						format(assign4score[i],sz[10])+format(assign5score[i],sz[11])+format(finalScore[i],sz[12])+
						format(finalGrade[i],sz[13]));
			}
		}
		System.out.print("\n\n");
	}
	
	public void removeStudent() throws Exception
	{
		System.out.print("\nEnter Student's ID to remove: ");
		int id = inputInt(inpt);
		ResultSet rs = st.executeQuery("select count(studentID) as cnt from Students where studentID="+id+";");
		rs.next();
		if(rs.getInt("cnt") == 0)System.out.println("No student with ID "+id+" found in the database.");
		else {
			st.executeUpdate("delete from Students where studentID="+id+";");
			System.out.print("Record deleted");
			--studentCount;
		}
		System.out.print("\n\n");
	}
	
	public void showClassStats() throws Exception
	{
		ResultSet rs = st.executeQuery("select count(*) as cnt from Students;");
		rs.next();
		if(rs.getInt("cnt") == 0) {
			System.out.println("No students found in the database.");
			return;
		}
		System.out.println("\nCLASS STATISTICKS\n");
		ResultSet AvgScores = st.executeQuery("select AVG(mid1score) as mt1, AVG(mid2score) as mt2, "
				+ "AVG(assign1score) as as1, AVG(assign2score) as as2, AVG(assign3score) as as3, "
				+ "AVG(assign4score) as as4, AVG(assign5score) as as5, AVG(Finalscore) as fnScr from Students;");
		AvgScores.next();
		
		double avgMt1 = AvgScores.getDouble("mt1");
		double avgMt2 = AvgScores.getDouble("mt2");
		double avgAs1 = AvgScores.getDouble("as1");
		double avgAs2 = AvgScores.getDouble("as2");
		double avgAs3 = AvgScores.getDouble("as3");
		double avgAs4 = AvgScores.getDouble("as4");
		double avgAs5 = AvgScores.getDouble("as5");
		double avgFinal = AvgScores.getDouble("FnScr");
		
		
		ResultSet CntAboveAvgMt1 = st.executeQuery("select Count(studentID) as cnt from Students where mid1score > (select AVG(mid1score) from Students);");
		CntAboveAvgMt1.next();
		System.out.println("Average marks for Midterm 1: "+avgMt1);
		System.out.println("Number of students who scored above average in Midterm 1: "+CntAboveAvgMt1.getInt("cnt"));
		ResultSet CntBelowAvgMt1 = st.executeQuery("select Count(studentID) as cnt from Students where mid1score < (select AVG(mid1score) from Students);");
		CntBelowAvgMt1.next();
		System.out.println("Number of students who scored below average in Midterm 1: "+CntBelowAvgMt1.getInt("cnt")+"\n");
		
		
		ResultSet CntAboveAvgMt2 = st.executeQuery("select Count(studentID) as cnt from Students where mid2score > (select AVG(mid2score) from Students);");
		CntAboveAvgMt2.next();
		System.out.println("Average marks for Midterm 2: "+avgMt2);
		System.out.println("Number of students who scored above average in Midterm 2: "+CntAboveAvgMt2.getInt("cnt"));
		ResultSet CntBelowAvgMt2 = st.executeQuery("select Count(studentID) as cnt from Students where mid2score < (select AVG(mid2score) from Students);");
		CntBelowAvgMt2.next();
		System.out.println("Number of students who scored below average in Midterm 2: "+CntBelowAvgMt2.getInt("cnt")+"\n");
		
		
		ResultSet CntAboveAvgAs1 = st.executeQuery("select Count(studentID) as cnt from Students where assign1score > (select AVG(assign1score) from Students);");
		CntAboveAvgAs1.next();
		System.out.println("Average marks for Assignment 1: "+avgAs1);
		System.out.println("Number of students who scored above average in Assignment 1: "+CntAboveAvgAs1.getInt("cnt"));
		ResultSet CntBelowAvgAs1 = st.executeQuery("select Count(studentID) as cnt from Students where assign1score < (select AVG(assign1score) from Students);");
		CntBelowAvgAs1.next();
		System.out.println("Number of students who scored below average in Assignment 1: "+CntBelowAvgAs1.getInt("cnt")+"\n");
		
		
		ResultSet CntAboveAvgAs2 = st.executeQuery("select Count(studentID) as cnt from Students where assign2score > (select AVG(assign2score) from Students);");
		CntAboveAvgAs2.next();
		System.out.println("Average marks for Assignment 2: "+avgAs2);
		System.out.println("Number of students who scored above average in Assignment 2: "+CntAboveAvgAs2.getInt("cnt"));
		ResultSet CntBelowAvgAs2 = st.executeQuery("select Count(studentID) as cnt from Students where assign2score < (select AVG(assign2score) from Students);");
		CntBelowAvgAs2.next();
		System.out.println("Number of students who scored below average in Assignment 2: "+CntBelowAvgAs2.getInt("cnt")+"\n");		
		
		
		ResultSet CntAboveAvgAs3 = st.executeQuery("select Count(studentID) as cnt from Students where assign3score > (select AVG(assign3score) from Students);");
		CntAboveAvgAs3.next();
		System.out.println("Average marks for Assignment 3: "+avgAs3);
		System.out.println("Number of students who scored above average in Assignment 3: "+CntAboveAvgAs3.getInt("cnt"));
		ResultSet CntBelowAvgAs3 = st.executeQuery("select Count(studentID) as cnt from Students where assign3score < (select AVG(assign3score) from Students);");
		CntBelowAvgAs3.next();
		System.out.println("Number of students who scored below average in Assignment 3: "+CntBelowAvgAs3.getInt("cnt")+"\n");		
		
		
		ResultSet CntAboveAvgAs4 = st.executeQuery("select Count(studentID) as cnt from Students where assign4score > (select AVG(assign4score) from Students);");
		CntAboveAvgAs4.next();
		System.out.println("Average marks for Assignment 4: "+avgAs4);
		System.out.println("Number of students who scored above average in Assignment 4: "+CntAboveAvgAs4.getInt("cnt"));
		ResultSet CntBelowAvgAs4 = st.executeQuery("select Count(studentID) as cnt from Students where assign4score < (select AVG(assign4score) from Students);");
		CntBelowAvgAs4.next();
		System.out.println("Number of students who scored below average in Assignment 4: "+CntBelowAvgAs4.getInt("cnt")+"\n");		
		
		
		ResultSet CntAboveAvgAs5 = st.executeQuery("select Count(studentID) as cnt from Students where assign5score > (select AVG(assign5score) from Students);");
		CntAboveAvgAs5.next();		
		System.out.println("Average marks for Assignment 5: "+avgAs5);
		System.out.println("Number of students who scored above average in Assignment 5: "+CntAboveAvgAs5.getInt("cnt"));
		ResultSet CntBelowAvgAs5 = st.executeQuery("select Count(studentID) as cnt from Students where assign5score < (select AVG(assign5score) from Students);");
		CntBelowAvgAs5.next();
		System.out.println("Number of students who scored below average in Assignment 5: "+CntBelowAvgAs5.getInt("cnt")+"\n");		
		
		
		
		ResultSet MaxMinFinal = st.executeQuery("select MAX(finalScore) as mx, MIN(finalScore) as mn from Students");
		MaxMinFinal.next();
		System.out.println("Average final overall score of the class: "+avgFinal);
		System.out.println("Heighest final overall score: "+MaxMinFinal.getInt("mx"));
		System.out.println("Lowest final overall score: "+MaxMinFinal.getInt("mn")+"\n");

		
		ResultSet PassCnt = st.executeQuery("select Count(studentID) as cnt from Students where finalScore > 50;");
		PassCnt.next();
		System.out.println("Number of students passed: "+PassCnt.getInt("cnt"));

		ResultSet FailCnt = st.executeQuery("select Count(studentID) as cnt from Students where finalScore < 50;");
		FailCnt.next();
		System.out.println("Number of students failed: "+FailCnt.getInt("cnt")+"\n\n");		
		
	}
	
	public void mainLoop() throws Exception // start point of the application user interface(Start CLI)
	{
		inpt = new Scanner(System.in);
		boolean running = true; // flag to check if application is running
		System.out.println("Application started");
		System.out.println("Hello Professor !\n");
		ResultSet rs=st.executeQuery("select count(*) as numberOfStudents from Students"); // gets the count of students
		rs.next();
		studentCount = rs.getInt("numberOfStudents");
		
		while(running){
			System.out.println("Main Menu -->\tProfessor, please choose an operation:\n");
			System.out.println("\t\t1) Add new student");
			System.out.println("\t\t2) View all students");
			System.out.println("\t\t3) Find a student by ID");
			System.out.println("\t\t4) Edit student data by ID");
			System.out.println("\t\t5) Remove student by ID");
			System.out.println("\t\t6) Show class statistics");
			System.out.println("\t\t7) Exit\n");
			
			System.out.print(prompt); // prompt message
			int operation = inputInt(inpt);
			
			switch(operation) {
			case 1:
				addNewStudent();
				break;
			case 2:
				viewAllStudents();
				break;
			case 3:
				findStudent();
				break;
			case 4:
				editStudentData();
				break;
			case 5:
				removeStudent();
				break;
			case 6:
				showClassStats();
				break;
			case 7:
				running = false;
				break;
			}
			
		}
		
		System.out.print("\nThank you");
	}

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","qwerty","qwerty123");
		st = con.createStatement();
		Application app = new Application();
		app.mainLoop();
	}

}
