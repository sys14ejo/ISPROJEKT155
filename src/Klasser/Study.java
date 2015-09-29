package Klasser;
import java.util.*;

public class Study {
	
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
		private String student;
		public String getStudent() {
			return student;
		}
		public void setStudent(String student) {
			this.student = student;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		private String course;
	
		private ArrayList<Course>cList = new ArrayList();
		private ArrayList<Student>sList = new ArrayList();
		
		
		public ArrayList<Student> getsList() {
			return sList;
		}
		public void setsList(ArrayList<Student> sList) {
			this.sList = sList;
		}
		public ArrayList<Course> getcList() {
			return cList;
		}
		public void setcList(ArrayList<Course> cList) {
			this.cList = cList;
		}
	
		
		
	

}
