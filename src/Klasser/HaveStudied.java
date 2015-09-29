package Klasser;

import java.util.ArrayList;

public class HaveStudied {
	private String grade;
	private int hhp;
	private String student;
	private String course;
	private String ssNr;
	private String cCode;
	
	

	public String getSsNr() {
		return ssNr;
	}
	public void setSsNr(String ssNr) {
		this.ssNr = ssNr;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public ArrayList<Course> getcList() {
		return cList;
	}
	public void setcList(ArrayList<Course> cList) {
		this.cList = cList;
	}
	public ArrayList<Student> getsList() {
		return sList;
	}
	public void setsList(ArrayList<Student> sList) {
		this.sList = sList;
	}
	private ArrayList<Course>cList = new ArrayList();
	private ArrayList<Student>sList = new ArrayList();
	
	
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getHhp() {
		return hhp;
	}
	public void setHhp(int hhp) {
		this.hhp = hhp;
	}
	
}