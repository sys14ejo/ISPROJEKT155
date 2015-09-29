package DAL;

import java.util.ArrayList;
import java.security.interfaces.RSAKey;
import java.sql.*;

import Klasser.Course;
import Klasser.HaveStudied;
import Klasser.Student;
import Klasser.Study;
import controller.Controller;

public class DAL {

	private ArrayList<Student> sList = new ArrayList<>();

	public static Connection getConnection() throws SQLException {
		// String ssNr = null;
		String conn = "jdbc:sqlserver://localhost:1433;databaseName=DatabasUppgift1;Username=sa;Password=mats";
		return DriverManager.getConnection(conn);
		// System.out.println("Successfully connected to the Database");
	}

	public static Student getStudent(String ssNr) {

		Student student = new Student();
		String str = "SELECT * FROM STUDENT WHERE ssNr = '" + ssNr + "'";

		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			ResultSet rs = preStmt.executeQuery();

			while (rs.next()) {
				student.setssNr(rs.getString(1));
				student.setsName(rs.getString(2));
				student.setAdress(rs.getString(3));
				student.setPhoneNr(rs.getString(4));
			}
		}

		catch (SQLException e) {
			System.out.println("HATADATA");
		}
		return student;

	}

	public static Student addStudent(String ssNr, String sName, String adress, String phoneNr) {
		Student student = new Student();

		String str = "INSERT INTO STUDENT VALUES('" + ssNr + "','" + sName + "','" + adress + "','" + phoneNr + "')";
		System.out.println(str);
		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			int rs = preStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("HATADATA");
			e.printStackTrace();
		}
		{

			{
			}
			return student;
		}
	}


	public static Course getCourse(String cCode) {
		Course course = new Course();

		try {
			Connection con = getConnection();
			String str = "SELECT * FROM Course WHERE cCode = '" + cCode + "'";

			PreparedStatement preStmt = con.prepareStatement(str);
			ResultSet rs = preStmt.executeQuery();

			while (rs.next()) {
				course.setCcode(rs.getString(1));
				course.setcName(rs.getString(2));
				course.setcHp(rs.getInt(3));
				course.setDuration(rs.getInt(4));

			}

		} catch (SQLException e) {
			System.out.println("HATADATA");

		}
		return course;
	}

	public static int addCourse(String cCode, String cName, int cHp, int duration) {
		Course course = new Course();

		int rs =0;
		try {
			Connection con = getConnection();
			String str = "INSERT INTO COURSE VALUES('" + cCode + "','" + cName + "','" + cHp + "','" + duration + "')";
			PreparedStatement preStmt = con.prepareStatement(str);
			 rs = preStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("HATADATA");
			e.printStackTrace();
		}
		return rs;
	}

	public static void deleteCourse(String cCode) {
		
		try {
			Connection con = getConnection();
			String str = "DELETE FROM HAVESTUDIED WHERE CCODE = ?";

			PreparedStatement preStmt = con.prepareStatement(str);
			preStmt.setString(1, cCode);
			int	rs = preStmt.executeUpdate();
		
			String str1 = "DELETE FROM STUDY WHERE CCODE = ?";
			PreparedStatement preStat = con.prepareStatement(str1);
			preStat.setString(1, cCode);
			rs = preStat.executeUpdate();
			
			String str2 = "DELETE FROM COURSE WHERE CCODE = ?";
			PreparedStatement preState = con.prepareStatement(str2);
			preState.setString(1, cCode);
			rs = preState.executeUpdate();
			

		} catch (SQLException e) {
		}

	}

	public static void deleteStudent(String ssNr) {

		
		try {
			Connection con = getConnection();
			String str = "DELETE FROM HAVESTUDIED WHERE SSNR = ?";

			PreparedStatement preStmt = con.prepareStatement(str);
			preStmt.setString(1, ssNr);
			int	rs = preStmt.executeUpdate();
		
			String str1 = "DELETE FROM STUDY WHERE SSNR = ?";
			PreparedStatement preStat = con.prepareStatement(str1);
			preStat.setString(1, ssNr);
			rs = preStat.executeUpdate();
			
			String str2 = "DELETE FROM STUDENT WHERE SSNR = ?";
			PreparedStatement preState = con.prepareStatement(str2);
			preState.setString(1, ssNr);
			rs = preState.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void deleteStudentFromCourse(String ssNr) {

		try {
			Connection con = getConnection();
			String str = "DELETE FROM STUDY WHERE SSNR = ?";

			PreparedStatement preStmt = con.prepareStatement(str);
			ResultSet rs = preStmt.executeQuery();

			preStmt.setString(1, ssNr);
			preStmt.executeUpdate();

		} catch (SQLException e) {

		}

	}

	public static Study addStudentToStudy(String ssNr, String cCode) {

		Study study = new Study();
		String str = "INSERT INTO STUDY VALUES('" + ssNr + "', '" + cCode + "')";

		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			int rs = preStmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return study;
	}

	public static HaveStudied addFinishedCourse(String ssNr, String cCode, String grade, int hHp) {
		HaveStudied finishedCourse = new HaveStudied();
		Course tmp = getCourse(cCode);
		String str = "INSERT INTO HAVESTUDIED VALUES ('" + grade + "', " + tmp.getcHp() + ", '" + ssNr + "', '"+cCode+"')";


		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			int rs = preStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return finishedCourse;
	}


	public static ArrayList<Student> getAllStudents() {
		ArrayList<Student> student = new ArrayList<Student>();
		String str = "SELECT * FROM Student";
		
		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			ResultSet rs = preStmt.executeQuery();

			while (rs.next()) {
				Student s1 = new Student();
				s1.setssNr(rs.getString(1));
				s1.setsName(rs.getString(2));
				s1.setAdress(rs.getString(3));
				s1.setPhoneNr(rs.getString(4));
				
				student.add(s1);

			}

		} catch (SQLException e) {
		}
		

		return student;
		
	}
	
	public static ArrayList<Course> getAllCourses() {
		ArrayList<Course> course = new ArrayList<Course>();
		String str = "SELECT * FROM Course";
		
		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			ResultSet rs = preStmt.executeQuery();

			while (rs.next()) {
				Course c1 = new Course();
				c1.setCcode(rs.getString(1));
				c1.setcName(rs.getString(2));
				c1.setcHp(rs.getInt(3));
				c1.setDuration(rs.getInt(4));

				course.add(c1);
			}

		} catch (SQLException e) {
		}
		

		return course;
		
	}
	
	public static HaveStudied 

	public static HaveStudied getGrade (String ssNr, String cCode) {
		
		HaveStudied studiedGrade = new HaveStudied();
		String str = " SELECT ssNr, cCode, grade FROM HaveStudied WHERE SSNR = '" + ssNr + "' AND CCODE = '" + cCode + "'";
	
		try {
			Connection con = getConnection();
			PreparedStatement preStmt = con.prepareStatement(str);
			ResultSet rs = preStmt.executeQuery();
			
			while (rs.next()) {
				studiedGrade.setSsNr(rs.getString(1));
				studiedGrade.setcCode(rs.getString(2));
				studiedGrade.setGrade(rs.getString(3));

				
				
				
				
			}
		}
		
			catch (SQLException e) {
				
			}	return studiedGrade;
	}
		
	  String query = "SELECT TOP 5 c.cCode, count(*) as Passed, cast((cast(count(*) as float)/(select count(*) from HaveStudied h where h.cCode = c.cCode))*100 as numeric(5,2)) as 'Percent'"+
	  " FROM Course c"+
	  " inner join HaveStudied hl"+
	  " ON hl.cCode=c.cCode"+
	  " WHERE (grade != 'F')"+
	  " GROUP BY c.cCode"+
	  " ORDER BY COUNT(*) DESC"; 

	
	
}



