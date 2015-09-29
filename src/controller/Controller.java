package controller;

import java.util.ArrayList;

import DAL.DAL;
import Klasser.Course;
import Klasser.HaveStudied;
import Klasser.Student;
import Klasser.Study;

import java.sql.*;

public class Controller {

	public static Student addStudent(String ssNr, String sName, String adress, String phoneNr) {
		return DAL.addStudent(ssNr, sName, adress, phoneNr);
	}

	public static Student getStudent(String ssNr) {
		return DAL.getStudent(ssNr);

	}

	public static Course getCourse(String cCode) {
		return DAL.getCourse(cCode);

	}
//	public static void addCourse(String cCode, String cName, int duration, int cHp) {
//		
//		
//	}
	public static void deleteStudent(String ssNr) {
		DAL.deleteStudent(ssNr);
	}
	public static void deleteStudentFromCourse(String ssNr){
		DAL.deleteStudentFromCourse(ssNr);
		
	}
	
	public static void deleteCourse(String cCode) {
		DAL.deleteCourse(cCode);
		
	}
	{

	}
	public static int addCourse(String cCode , String cName, int cHp, int duration) {
		return DAL.addCourse(cCode, cName, cHp, duration);
		
}

	public static HaveStudied getGrade(String ssNr, String cCode) {
		return DAL.getGrade(ssNr, cCode);
	}
	
	public static HaveStudied addFinishedCourse(String ssNr, String cCode, String grade, int hhp) {
		return DAL.addFinishedCourse(ssNr, cCode, grade, hhp);
	}
	
	public static ArrayList<Student> getAllStudents() {
		return DAL.getAllStudents();
	}
	
	public static ArrayList<Course> getAllCourses() {
		return DAL.getAllCourses();
	}
	
	public static Study addStudentToStudy(String ssNr, String cCode){
		return DAL.addStudentToStudy(ssNr, cCode);
	}
}
