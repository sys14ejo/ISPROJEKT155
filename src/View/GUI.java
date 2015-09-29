package View;

import java.awt.EventQueue;
import controller.Controller;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAL.DAL;
import Klasser.Course;
import Klasser.HaveStudied;
import Klasser.Student;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GUI {

	private JFrame frame;
	private JTextField txtSocialSecurityNumber;
	private JTextField txtSSNR;
	private JTextField txtSName;
	private JTextField txtAdress;
	private JTextField txtPhoneNr;
	private JTextField txtCourseCode;
	private JTextField txtCCode;
	private JTextField txtCName;
	private JTextField txtCHP;
	private JTextField txtDuration;
	private JTextField txtSocialSecurityNumber_1;
	private JTextField txtCourseCode_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField txtSocialSecurityNumber_2;
	private JTextField txtCourseCode_2;
	private JTable table;
	private JTable table_Student;
	private JTable table_Course;
	private JTable table_Registry;
	private DefaultTableModel tableModelStudent;
	private DefaultTableModel tableModelCourse;
	private DefaultTableModel tableModelRegistry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1113, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 1083, 559);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Student", null, panel, null);
		panel.setLayout(null);

		txtSocialSecurityNumber = new JTextField();
		txtSocialSecurityNumber.setText("Social Security Number...");
		txtSocialSecurityNumber.setBounds(12, 40, 200, 30);
		panel.add(txtSocialSecurityNumber);
		txtSocialSecurityNumber.setColumns(10);

		JButton btnSearchStudent = new JButton("Search");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModelStudent.setRowCount(0);
				Student student = controller.Controller.getStudent(txtSocialSecurityNumber.getText().trim());

				String[] col = new String[4];
				col[0] = student.getssNr();
				col[1] = student.getsName();
				col[2] = student.getAdress();
				col[3] = student.getPhoneNr();
				tableModelStudent.addRow(col);

			}
		});
		btnSearchStudent.setBounds(12, 80, 95, 25);
		panel.add(btnSearchStudent);

		JButton btnDeleteStudent = new JButton("Delete");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Controller.deleteStudent(txtSocialSecurityNumber.getText().trim());
			}
		});
		btnDeleteStudent.setBounds(117, 80, 95, 25);
		panel.add(btnDeleteStudent);

		JLabel lblNewLabel = new JLabel("Social Security Number");
		lblNewLabel.setBounds(431, 165, 145, 30);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(530, 208, 200, 30);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Adress");
		lblNewLabel_2.setBounds(519, 251, 200, 30);
		panel.add(lblNewLabel_2);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(483, 294, 200, 30);
		panel.add(lblPhoneNumber);

		txtSSNR = new JTextField();
		txtSSNR.setBounds(567, 165, 200, 30);
		panel.add(txtSSNR);
		txtSSNR.setColumns(10);

		txtSName = new JTextField();
		txtSName.setBounds(567, 208, 200, 30);
		panel.add(txtSName);
		txtSName.setColumns(10);

		txtAdress = new JTextField();
		txtAdress.setBounds(567, 251, 200, 30);
		panel.add(txtAdress);
		txtAdress.setColumns(10);

		txtPhoneNr = new JTextField();
		txtPhoneNr.setBounds(567, 294, 200, 30);
		panel.add(txtPhoneNr);
		txtPhoneNr.setColumns(10);

		JButton btnAddStudent = new JButton("Register student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Controller.addStudent(txtSSNR.getText(), txtSName.getText(), txtAdress.getText(),
						txtPhoneNr.getText());
				Student student = controller.Controller.getStudent(txtSSNR.getText().trim());

				String[] col = new String[4];
				col[0] = student.getssNr();
				col[1] = student.getsName();
				col[2] = student.getAdress();
				col[3] = student.getPhoneNr();
				tableModelStudent.addRow(col);

			}

		});
		btnAddStudent.setBounds(567, 337, 200, 25);
		panel.add(btnAddStudent);

		JLabel lblSearchForStudent = new JLabel("Search for student");
		lblSearchForStudent.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSearchForStudent.setBounds(12, 0, 200, 50);
		panel.add(lblSearchForStudent);

		// Detta är en TABLE

		tableModelStudent = new DefaultTableModel();
		String[] headerStudent = { "Social Security Number", "Name", "Address", "Phone Number" };
		tableModelStudent.setColumnIdentifiers(headerStudent);
		JScrollPane scrollPaneStudent = new JScrollPane();
		scrollPaneStudent.setBounds(12, 124, 355, 345);
		panel.add(scrollPaneStudent);
		table_Student = new JTable(tableModelStudent);
		scrollPaneStudent.setViewportView(table_Student);

		JButton btnNewButton = new JButton("Get all students");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> student = Controller.getAllStudents();
				tableModelStudent.setRowCount(0);
				for (Student tmp : student) {
					String[] tmpStudent = new String[4];

					tmpStudent[0] = tmp.getssNr();
					tmpStudent[1] = tmp.getsName();
					tmpStudent[2] = tmp.getAdress();
					tmpStudent[3] = tmp.getPhoneNr();
					tableModelStudent.addRow(tmpStudent);
				}

			}
		});
		btnNewButton.setBounds(234, 80, 133, 25);
		panel.add(btnNewButton);
		
		JLabel lblRegisterStudent = new JLabel("Register Student");
		lblRegisterStudent.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblRegisterStudent.setBounds(567, 124, 205, 28);
		panel.add(lblRegisterStudent);

		// Slut på TABLE

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Course", null, panel_1, null);
		panel_1.setLayout(null);

		txtCourseCode = new JTextField();
		txtCourseCode.setText("Course code...");
		txtCourseCode.setBounds(12, 40, 200, 30);
		panel_1.add(txtCourseCode);
		txtCourseCode.setColumns(10);

		JButton btnSearchCourse = new JButton("Search");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModelCourse.setRowCount(0);
				Course course = controller.Controller.getCourse(txtCourseCode.getText().trim());

				String[] col1 = new String[4];
				col1[0] = course.getCcode();
				col1[1] = course.getcName();
				col1[2] = Integer.toString(course.getcHp());
				col1[3] = Integer.toString(course.getDuration());
				tableModelCourse.addRow(col1);

			}

		});
		btnSearchCourse.setBounds(12, 80, 95, 25);
		panel_1.add(btnSearchCourse);

		JLabel lblDeleteCourse = new JLabel("");
		lblDeleteCourse.setBounds(22, 204, 337, 16);
		panel_1.add(lblDeleteCourse);

		JButton btnDeleteCourse = new JButton("Delete");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.deleteCourse(txtCourseCode.getText().trim());

			
			}
		}

		);
		btnDeleteCourse.setBounds(117, 80, 95, 25);
		panel_1.add(btnDeleteCourse);

		JLabel lblCourseCode = new JLabel("Course code");
		lblCourseCode.setBounds(489, 161, 200, 30);
		panel_1.add(lblCourseCode);

		JLabel lblCourseName = new JLabel("Course name");
		lblCourseName.setBounds(489, 204, 200, 30);
		panel_1.add(lblCourseName);

		JLabel lblHp = new JLabel("HP");
		lblHp.setBounds(538, 252, 200, 30);
		panel_1.add(lblHp);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(510, 295, 200, 30);
		panel_1.add(lblDuration);

		txtCCode = new JTextField();
		txtCCode.setBounds(566, 161, 200, 30);
		panel_1.add(txtCCode);
		txtCCode.setColumns(10);

		txtCName = new JTextField();
		txtCName.setBounds(566, 204, 200, 30);
		panel_1.add(txtCName);
		txtCName.setColumns(10);

		txtCHP = new JTextField();
		txtCHP.setBounds(566, 247, 200, 30);
		panel_1.add(txtCHP);
		txtCHP.setColumns(10);

		txtDuration = new JTextField();
		txtDuration.setBounds(566, 295, 200, 30);
		panel_1.add(txtDuration);
		txtDuration.setColumns(10);

		JButton btnAddCourse = new JButton("Register course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txtCHP.getText().trim());
				int b = Integer.parseInt(txtDuration.getText().trim());
				Controller.addCourse(txtCCode.getText().trim(), txtCName.getText().trim(), a, b);
				Course course = Controller.getCourse(txtCCode.getText().trim());

				String[] col = new String[4];
				col[0] = course.getCcode();
				col[1] = course.getcName();
				col[2] = Integer.toString(course.getcHp());
				col[3] = Integer.toString(course.getDuration());
				tableModelCourse.addRow(col);
			}

		});
		btnAddCourse.setBounds(566, 338, 200, 25);
		panel_1.add(btnAddCourse);

		JLabel lblSearchForCourse = new JLabel("Search for course");
		lblSearchForCourse.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSearchForCourse.setBounds(12, 0, 200, 50);
		panel_1.add(lblSearchForCourse);

		JScrollPane scrollPaneCourse = new JScrollPane();
		scrollPaneCourse.setBounds(12, 124, 355, 343);
		panel_1.add(scrollPaneCourse);
		tableModelCourse = new DefaultTableModel();
		String[] headerCourse = { "Code", "Name", "HP", "Weeks" };
		tableModelCourse.setColumnIdentifiers(headerCourse);

		table_Course = new JTable(tableModelCourse);
		scrollPaneCourse.setViewportView(table_Course);
		
		JButton btnGetAllCourses = new JButton("Get all Courses");
		btnGetAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ArrayList<Course> course = Controller.getAllCourses();
				tableModelCourse.setRowCount(0);
				for (Course tmp : course) {
					String[] tmpCourse = new String[4];
					
					tmpCourse[0] = tmp.getCcode();
					tmpCourse[1] = tmp.getcName();
					tmpCourse[2] = Integer.toString(tmp.getcHp());
					tmpCourse[3] = Integer.toString(tmp.getDuration());
					tableModelCourse.addRow(tmpCourse);
				}
			
			}
		});
		btnGetAllCourses.setBounds(235, 80, 132, 25);
		panel_1.add(btnGetAllCourses);
		
		JLabel lblRegisterCourse = new JLabel("Register Course");
		lblRegisterCourse.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblRegisterCourse.setBounds(566, 124, 200, 30);
		panel_1.add(lblRegisterCourse);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Registry", null, panel_3, null);
		panel_3.setLayout(null);

		tableModelRegistry = new DefaultTableModel();
		String[] headerRegistry = { "Social Security Number", "Course Code", "Grade", "HP"};
		tableModelRegistry.setColumnIdentifiers(headerRegistry);
		JScrollPane scrollPaneRegistry = new JScrollPane();
		scrollPaneRegistry.setBounds(12, 160, 436, 271);
		panel_3.add(scrollPaneRegistry);
		table_Registry = new JTable(tableModelRegistry);
		scrollPaneRegistry.setViewportView(table_Registry);

		txtSocialSecurityNumber_2 = new JTextField();
		txtSocialSecurityNumber_2.setText("Social Security Number...");
		txtSocialSecurityNumber_2.setBounds(12, 40, 200, 30);
		panel_3.add(txtSocialSecurityNumber_2);
		txtSocialSecurityNumber_2.setColumns(10);

		txtCourseCode_2 = new JTextField();
		txtCourseCode_2.setText("Course code...");
		txtCourseCode_2.setBounds(10, 105, 200, 30);
		panel_3.add(txtCourseCode_2);
		txtCourseCode_2.setColumns(10);

		JButton btnRegistrySearch = new JButton("Search...");
		btnRegistrySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtSocialSecurityNumber_2 != null && txtCourseCode != null) {
				HaveStudied studiedGrade = Controller.getGrade(txtSocialSecurityNumber_2.getText().trim(),
						txtCourseCode_2.getText().trim());
				tableModelRegistry.setRowCount(0);
				String[] col3 = new String[3];
				col3[0] = studiedGrade.getSsNr();
				col3[1] = studiedGrade.getcCode();
				col3[2] = studiedGrade.getGrade();
				tableModelRegistry.addRow(col3);
				}

			}
		});
		btnRegistrySearch.setBounds(771, 40, 200, 30);
		panel_3.add(btnRegistrySearch);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Not Specified", "Study", "Have Studied" }));
		comboBox.setBounds(224, 105, 200, 30);
		panel_3.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Not Specified", "A", "B", "C", "D", "E", "F", "none" }));
		comboBox_1.setBounds(224, 40, 200, 30);
		panel_3.add(comboBox_1);

		JLabel lblStudyhaveStudied = new JLabel("Study/Have Studied:");
		lblStudyhaveStudied.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblStudyhaveStudied.setBounds(224, 63, 200, 50);
		panel_3.add(lblStudyhaveStudied);

		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblGrade.setBounds(224, 0, 200, 50);
		panel_3.add(lblGrade);

		JLabel lblNewLabel_3 = new JLabel("Course(s) with highest passrate");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_3.setBounds(786, 105, 253, 50);
		panel_3.add(lblNewLabel_3);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course Code", "Passed", "Percent"
			}
		));
		table.setBounds(796, 161, 253, 271);
		panel_3.add(table);
		
		

		JLabel lblRegisterSpecify = new JLabel();
		lblRegisterSpecify.setBounds(224, 139, 200, 16);
		panel_3.add(lblRegisterSpecify);

		JButton btnRegisterFinishedCourse = new JButton("Register student to course");
		btnRegisterFinishedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().toString() == "Have Studied") {
					lblRegisterSpecify.setText(null);
					String grade = comboBox_1.getSelectedItem().toString();
				Controller.addFinishedCourse(txtSocialSecurityNumber_2.getText().trim(),
						txtCourseCode_2.getText().trim(), grade, Controller.getCourse(txtCourseCode_2.getText().trim()).getcHp());
				System.out.println(comboBox_1.getSelectedItem().toString() + grade);
				}
				else if (comboBox.getSelectedItem().toString() == "Study") {
					lblRegisterSpecify.setText(null);
					Controller.addStudentToStudy(txtSocialSecurityNumber_2.getText().trim(), 
							txtCourseCode_2.getText().trim());
				}
				else if (comboBox.getSelectedItem().toString() == "Not Specified") {
					lblRegisterSpecify.setText(null);
					lblRegisterSpecify.setText("*Please choose one of the options");
				}
			}
		});
		
			btnRegisterFinishedCourse.setBounds(480, 269, 200, 30);
		panel_3.add(btnRegisterFinishedCourse);
		
		JButton btnRegistryDelete = new JButton("Delete");
		btnRegistryDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRegistryDelete.setBounds(309, 444, 139, 25);
		panel_3.add(btnRegistryDelete);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number");
		lblSocialSecurityNumber.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSocialSecurityNumber.setBounds(12, 19, 200, 16);
		panel_3.add(lblSocialSecurityNumber);
		
		JLabel lblCourseCode_1 = new JLabel("Course Code");
		lblCourseCode_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCourseCode_1.setBounds(12, 83, 200, 16);
		panel_3.add(lblCourseCode_1);
		
		JButton btnNewButton_1 = new JButton("Search student...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(480, 40, 200, 30);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search course...");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					ArrayList<Course> course = Controller.getAllCourses();
					tableModelRegistry.setRowCount(0);
					for (Course tmp : course) {
						String[] tmpCourse = new String[4];
						
						tmpCourse[0] = tmp.getCcode();
						tmpCourse[1] = tmp.getcName();
						tmpCourse[2] = Integer.toString(tmp.getcHp());
						tmpCourse[3] = Integer.toString(tmp.getDuration());
						tableModelRegistry.addRow(tmpCourse);
					}
			}
		});
		btnNewButton_2.setBounds(480, 105, 200, 30);
		panel_3.add(btnNewButton_2);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Cronus (Assignment 2)", null, panel_5, null);
		panel_5.setLayout(null);

		JLabel lblShowAll = new JLabel("Show all:");
		lblShowAll.setBounds(12, 25, 56, 16);
		panel_5.add(lblShowAll);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(75, 24, 133, 22);
		panel_5.add(comboBox_4);

		JLabel lblIn = new JLabel("in");
		lblIn.setBounds(217, 25, 56, 16);
		panel_5.add(lblIn);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(235, 24, 133, 22);
		panel_5.add(comboBox_5);

		JButton btnGetQuery = new JButton("Get query");
		btnGetQuery.setBounds(388, 24, 97, 22);
		panel_5.add(btnGetQuery);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(12, 54, 56, 16);
		panel_5.add(lblResult);

		JLabel lblSqlQuerys = new JLabel("SQL querys");
		lblSqlQuerys.setBounds(12, 251, 71, 16);
		panel_5.add(lblSqlQuerys);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(12, 269, 689, 46);
		panel_5.add(textPane_1);

		JLabel lblTableWithMost = new JLabel("Table with most rows:");
		lblTableWithMost.setBounds(511, 13, 133, 16);
		panel_5.add(lblTableWithMost);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(511, 31, 190, 16);
		panel_5.add(textPane_2);

		JTable table_1 = new JTable();
		table_1.setBounds(12, 70, 689, 168);
		panel_5.add(table_1);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Cronus (Assignment 3)", null, panel_6, null);
		panel_6.setLayout(null);

		JLabel lblChooseQuery = new JLabel("Choose query:");
		lblChooseQuery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChooseQuery.setBounds(321, 29, 105, 34);
		panel_6.add(lblChooseQuery);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(295, 65, 150, 30);
		panel_6.add(comboBox_6);

		JLabel lblChooseProgram = new JLabel("Choose program:");
		lblChooseProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChooseProgram.setBounds(312, 136, 133, 34);
		panel_6.add(lblChooseProgram);

		JButton btnExcel = new JButton("Excel");
		btnExcel.setBounds(212, 183, 133, 34);
		panel_6.add(btnExcel);

		JButton btnAccess = new JButton("Access");
		btnAccess.setBounds(385, 183, 133, 34);
		panel_6.add(btnAccess);

		JButton btnWord = new JButton("Word");
		btnWord.setBounds(212, 230, 133, 34);
		panel_6.add(btnWord);

		JButton btnSql = new JButton("SQL");
		btnSql.setBounds(385, 230, 133, 34);
		panel_6.add(btnSql);

	}
}
