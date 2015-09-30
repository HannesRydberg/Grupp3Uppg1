import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class StudentView {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField textFieldpNr;
	private JTextField textFieldfirstName;
	private JTextField textFieldlastName;
	private JTextField textFieldadress;
	private JTextField textFieldphoneNr;
	private JTextField textFieldCourseCode;
	private JTextField textFieldCourseName;
	private JTextField textFieldInstitution;
	private JTextField textFieldManager;
	private JTextField textFieldSelectPNr;
	private JTextField textFieldCourseCode1;
	private Controller controller = new Controller();
	private JTextField textFieldPoints;
	private JTextField textFieldPNr_2;
	private JTextField textFieldFirstName_2;
	private JTextField textFieldLastName_2;
	private JTextField textFieldAdress_2;
	private JTextField textFieldPhoneNr_2;
	private JTextField textFieldCcode_2;
	private JTextField textFieldCname_2;
	private JTextField textFieldInstitution_2;
	private JTextField textFieldCmanager_2;
	private JTextField textFieldPNrGrade;
	private JTextField textFieldCCodeGrade;
	private JTextField textFieldCpoints_2;
	private JTextField textFieldFindCcodeLeft;
	private DefaultTableModel dtmLeft = new DefaultTableModel();
	private DefaultTableModel dtmRight = new DefaultTableModel();
	private DefaultTableModel dtmCourses = new DefaultTableModel();
	private JTextField textFieldFindCCodeRight;
	private ResultSet rs = controller.getAllCoursesSorted();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView window = new StudentView();
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
	public StudentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1225, 811);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1203, 755);
		frame.getContentPane().add(tabbedPane);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tabbedPane.addTab("Administration", null, panel, null);
		panel.setLayout(null);

		JLabel lblAddDeleteStudent = new JLabel("Add/ delete student");
		lblAddDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddDeleteStudent.setBounds(62, 27, 155, 16);
		panel.add(lblAddDeleteStudent);

		JLabel lblPnr = new JLabel("Person number:");
		lblPnr.setBounds(12, 56, 100, 16);
		panel.add(lblPnr);

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(12, 85, 72, 16);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(12, 114, 72, 16);
		panel.add(lblLastName);

		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(12, 143, 72, 16);
		panel.add(lblAdress);

		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setBounds(12, 172, 88, 16);
		panel.add(lblPhoneNumber);

		textFieldpNr = new JTextField();
		textFieldpNr.setBounds(124, 53, 173, 22);
		panel.add(textFieldpNr);
		textFieldpNr.setColumns(10);

		textFieldfirstName = new JTextField();
		textFieldfirstName.setColumns(10);
		textFieldfirstName.setBounds(124, 82, 173, 22);
		panel.add(textFieldfirstName);

		textFieldlastName = new JTextField();
		textFieldlastName.setColumns(10);
		textFieldlastName.setBounds(124, 111, 173, 22);
		panel.add(textFieldlastName);

		textFieldadress = new JTextField();
		textFieldadress.setColumns(10);
		textFieldadress.setBounds(124, 140, 173, 22);
		panel.add(textFieldadress);

		textFieldphoneNr = new JTextField();
		textFieldphoneNr.setColumns(10);
		textFieldphoneNr.setBounds(124, 169, 173, 22);
		panel.add(textFieldphoneNr);

		JButton btnDeleteStudent = new JButton("Delete student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String pNr = textFieldpNr.getText();

				if (textFieldpNr.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,
							"Vänligen fyll i Personnumret!", " ", 2);

				} else {
					controller.deleteStudent(pNr);

					textFieldpNr.setText("");
					textFieldfirstName.setText("");
					textFieldlastName.setText("");
					textFieldadress.setText("");
					textFieldphoneNr.setText("");
					JOptionPane.showMessageDialog(frame,
							"Studenten är nu borttagen!", " ", 2);
				}

			}
		});
		btnDeleteStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteStudent.setBounds(166, 230, 131, 25);
		panel.add(btnDeleteStudent);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 261, 1198, 2);
		panel.add(separator);

		JLabel lblAddDeleteCourse = new JLabel("Add/ delete Course");
		lblAddDeleteCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddDeleteCourse.setBounds(538, 27, 155, 16);
		panel.add(lblAddDeleteCourse);

		JLabel lblCourseCode = new JLabel("Course code:");
		lblCourseCode.setBounds(477, 56, 100, 16);
		panel.add(lblCourseCode);

		textFieldCourseCode = new JTextField();
		textFieldCourseCode.setColumns(10);
		textFieldCourseCode.setBounds(594, 53, 173, 22);
		panel.add(textFieldCourseCode);

		JLabel lblCourseName = new JLabel("Course name:");
		lblCourseName.setBounds(477, 85, 100, 16);
		panel.add(lblCourseName);

		JLabel lblInstitution = new JLabel("Institution:");
		lblInstitution.setBounds(477, 114, 100, 16);
		panel.add(lblInstitution);

		JLabel lblCourseManager = new JLabel("Course manager:");
		lblCourseManager.setBounds(477, 143, 100, 16);
		panel.add(lblCourseManager);

		textFieldCourseName = new JTextField();
		textFieldCourseName.setColumns(10);
		textFieldCourseName.setBounds(594, 82, 173, 22);
		panel.add(textFieldCourseName);

		textFieldInstitution = new JTextField();
		textFieldInstitution.setColumns(10);
		textFieldInstitution.setBounds(594, 111, 173, 22);
		panel.add(textFieldInstitution);

		textFieldManager = new JTextField();
		textFieldManager.setColumns(10);
		textFieldManager.setBounds(594, 140, 173, 22);
		panel.add(textFieldManager);

		JButton btnAddCourse = new JButton("Add course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Course c = new Course();

				c.setcCode(textFieldCourseCode.getText());
				c.setcInstitution(textFieldInstitution.getText());
				c.setcManager(textFieldManager.getText());
				c.setcPoints(textFieldPoints.getText());
				c.setcName(textFieldCourseName.getText());

				if (textFieldCourseCode.getText().equals("")
						|| textFieldInstitution.getText().equals("")
						|| textFieldPoints.getText().equals("")
						|| textFieldManager.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,
							"Var vänlig fyll i alla fält!", " ", 2);

				} else if (controller.getCourse(textFieldCourseCode.getText()) != null) {

					JOptionPane.showMessageDialog(frame, "Kurs finns redan!",
							" ", 2);
				} else {
					controller.addCourse(c);
					textFieldCourseCode.setText("");
					textFieldInstitution.setText("");
					textFieldPoints.setText("");
					textFieldManager.setText("");
					textFieldCourseName.setText("");
				}

			}
		});
		btnAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddCourse.setBounds(477, 230, 121, 25);
		panel.add(btnAddCourse);

		JButton btnDeleteCourse = new JButton("Delete course");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnDeleteCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteCourse.setBounds(646, 230, 121, 25);
		panel.add(btnDeleteCourse);

		JLabel lblMesasge = new JLabel("");
		lblMesasge.setBounds(12, 201, 56, 16);
		panel.add(lblMesasge);

		JButton btnAddStudent_1 = new JButton("Add Student");
		btnAddStudent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Student s = new Student();

				s.setpNr(textFieldpNr.getText());
				s.setFirstName(textFieldfirstName.getText());
				s.setLastName(textFieldlastName.getText());
				s.setAdress(textFieldadress.getText());
				s.setPhoneNr(textFieldphoneNr.getText());

				if (textFieldpNr.getText().equals("")
						|| textFieldfirstName.getText().equals("")
						|| textFieldlastName.getText().equals("")
						|| textFieldadress.getText().equals("")
						|| textFieldphoneNr.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,
							"Var vänlig fyll i alla fält!", " ", 2);
				} else if (controller.getStudent(textFieldpNr.getText()) != null) {

					JOptionPane.showMessageDialog(frame,
							"Studenten finns redan!", " ", 2);
				} else {
					controller.addStudent(s);
					textFieldpNr.setText("");
					textFieldfirstName.setText("");
					textFieldlastName.setText("");
					textFieldadress.setText("");
					textFieldphoneNr.setText("");
				}

			}

		});
		btnAddStudent_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStudent_1.setBounds(12, 231, 109, 25);
		panel.add(btnAddStudent_1);

		JLabel lblMessageCourse = new JLabel("");
		lblMessageCourse.setBounds(477, 201, 56, 16);
		panel.add(lblMessageCourse);

		JComboBox<String> comboBoxSemester = new JComboBox<String>();
		comboBoxSemester.addItem("HT14");
		comboBoxSemester.addItem("VT15");
		comboBoxSemester.addItem("HT15");
		comboBoxSemester.addItem("VT16");
		comboBoxSemester.addItem("HT16");
		comboBoxSemester.addItem("VT17");
		comboBoxSemester.addItem("HT17");

		comboBoxSemester.setBounds(138, 388, 65, 22);
		panel.add(comboBoxSemester);

		JLabel lblAddStudentsTo = new JLabel(
				"Add/Delete students to/from courses");
		lblAddStudentsTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddStudentsTo.setBounds(15, 292, 282, 16);
		panel.add(lblAddStudentsTo);

		JLabel lblPersonNumber11 = new JLabel("Person number:");
		lblPersonNumber11.setBounds(12, 320, 121, 16);
		panel.add(lblPersonNumber11);

		textFieldSelectPNr = new JTextField();
		textFieldSelectPNr.setColumns(10);
		textFieldSelectPNr.setBounds(138, 317, 121, 22);
		panel.add(textFieldSelectPNr);

		JLabel lblCourseCode1 = new JLabel("Course code:");
		lblCourseCode1.setBounds(12, 352, 100, 16);
		panel.add(lblCourseCode1);

		textFieldCourseCode1 = new JTextField();
		textFieldCourseCode1.setColumns(10);
		textFieldCourseCode1.setBounds(138, 350, 121, 22);
		panel.add(textFieldCourseCode1);

		JButton btnApplyToCourse = new JButton("Apply to course");
		btnApplyToCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textFieldSelectPNr.getText().equals("")
						|| textFieldCourseCode1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,
							"Vänligen fyll i alla fält!", " ", 2);

				} 

				else if (controller.getCourse(textFieldCourseCode1.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Course cannot be found!", " ", 2);
				} else if (controller.getStudent(textFieldSelectPNr.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Student cannot be found!", " ", 2);
				} 
				else if (controller.getStudying(
						textFieldCourseCode1.getText()).contains(
						controller.getStudent(textFieldSelectPNr.getText())
								.getpNr())) {

					JOptionPane.showMessageDialog(frame,
							"Student is already studying this course!", " ", 2);
				}else if (controller.sumPoints(textFieldSelectPNr.getText(),
						(String) comboBoxSemester.getSelectedItem())
						+ Integer.parseInt(controller.getCourse(
								textFieldCourseCode1.getText()).getcPoints()) > 45) {
					JOptionPane
							.showMessageDialog(
									frame,
									"Student has reached the points limit for this semester! Unable to register",
									" ", 2);

				}

				else {
					controller.addStudies(textFieldSelectPNr.getText(),
							textFieldCourseCode1.getText(),
							(String) comboBoxSemester.getSelectedItem());
					textFieldSelectPNr.setText("");
					textFieldCourseCode1.setText("");
				}

			}

		});
		btnApplyToCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnApplyToCourse.setBounds(138, 426, 141, 25);
		panel.add(btnApplyToCourse);

		JLabel lblManageGrades = new JLabel("Manage Grades");
		lblManageGrades.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManageGrades.setBounds(538, 292, 194, 16);
		panel.add(lblManageGrades);

		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(12, 391, 100, 16);
		panel.add(lblSemester);

		textFieldPoints = new JTextField();
		textFieldPoints.setBounds(594, 167, 173, 26);
		panel.add(textFieldPoints);
		textFieldPoints.setColumns(10);

		JLabel lblPoints = new JLabel("Points");
		lblPoints.setBounds(477, 170, 69, 20);
		panel.add(lblPoints);

		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(488, 391, 48, 16);
		panel.add(lblGrade);

		JComboBox<String> comboBoxGrade = new JComboBox<String>();
		comboBoxGrade.addItem("A");
		comboBoxGrade.addItem("B");
		comboBoxGrade.addItem("C");
		comboBoxGrade.addItem("D");
		comboBoxGrade.addItem("E");
		comboBoxGrade.addItem("U");

		comboBoxGrade.setBounds(542, 391, 56, 22);
		panel.add(comboBoxGrade);

		JButton btnDeleteFromCourse = new JButton("Delete from course");
		btnDeleteFromCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldSelectPNr.getText().equals("")
						|| textFieldCourseCode1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,
							"Vänligen fyll i alla fält!", " ", 2);

				} else if (controller.getStudying(
						textFieldCourseCode1.getText()).contains(
						controller.getStudent(textFieldSelectPNr.getText()))) {

					JOptionPane.showMessageDialog(frame, "Fel!", " ", 2);
				}

				else {
					controller.deleteStudying(textFieldSelectPNr.getText(),
							textFieldCourseCode1.getText());
					textFieldSelectPNr.setText("");
					textFieldCourseCode1.setText("");

				}
			}
		});
		btnDeleteFromCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDeleteFromCourse.setBounds(138, 460, 141, 25);
		panel.add(btnDeleteFromCourse);

		textFieldPNrGrade = new JTextField();
		textFieldPNrGrade.setColumns(10);
		textFieldPNrGrade.setBounds(538, 320, 121, 22);
		panel.add(textFieldPNrGrade);

		textFieldCCodeGrade = new JTextField();
		textFieldCCodeGrade.setColumns(10);
		textFieldCCodeGrade.setBounds(538, 353, 121, 22);
		panel.add(textFieldCCodeGrade);

		JButton button = new JButton("Apply to course");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldPNrGrade.getText().equals("")
						|| textFieldCCodeGrade.getText().equals("")) {
					JOptionPane.showMessageDialog(frame,
							"Vänligen fyll i alla fält!", " ", 2);

					// FUNKAR INTE!!!
				} else if (controller.getStudied(textFieldCCodeGrade.getText())
						.contains(
								controller.getStudent(
										textFieldPNrGrade.getText()).getpNr())) {

					JOptionPane.showMessageDialog(frame,
							"The Student already has a grade this course!",
							" ", 2);
				}

				else if (controller.getCourse(textFieldCCodeGrade.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Course cannot be found!", " ", 2);
				} else if (controller.getStudent(textFieldPNrGrade.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Student cannot be found!", " ", 2);
				} else {
					controller.addStudied(textFieldPNrGrade.getText(),
							textFieldCCodeGrade.getText(),
							(String) comboBoxGrade.getSelectedItem(),
							(String) comboBoxSemester.getSelectedItem());
					textFieldPNrGrade.setText("");
					textFieldCCodeGrade.setText("");
				}

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(538, 429, 141, 25);
		panel.add(button);

		JLabel lblPNrGrade = new JLabel("Person number:");
		lblPNrGrade.setBounds(412, 318, 121, 16);
		panel.add(lblPNrGrade);

		JLabel lblCCodeGrade = new JLabel("Course code:");
		lblCCodeGrade.setBounds(412, 350, 100, 16);
		panel.add(lblCCodeGrade);

		panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblSearchStudents = new JLabel("Search students");
		lblSearchStudents.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchStudents.setBounds(113, 8, 120, 19);
		panel_1.add(lblSearchStudents);

		JLabel labelSearchPnr = new JLabel("Person number:");
		labelSearchPnr.setBounds(25, 43, 114, 20);
		panel_1.add(labelSearchPnr);

		JLabel lblSearchFirstName = new JLabel("First name:");
		lblSearchFirstName.setBounds(25, 79, 80, 20);
		panel_1.add(lblSearchFirstName);

		JLabel lblSearchLastName = new JLabel("Last name:");
		lblSearchLastName.setBounds(25, 115, 78, 20);
		panel_1.add(lblSearchLastName);

		JLabel lblSearchAdress = new JLabel("Adress:");
		lblSearchAdress.setBounds(25, 151, 54, 20);
		panel_1.add(lblSearchAdress);

		JLabel lblSearchPhoneNr = new JLabel("Phone number:");
		lblSearchPhoneNr.setBounds(25, 187, 110, 20);
		panel_1.add(lblSearchPhoneNr);

		textFieldPNr_2 = new JTextField();
		textFieldPNr_2.setColumns(10);
		textFieldPNr_2.setBounds(154, 43, 146, 26);
		panel_1.add(textFieldPNr_2);

		textFieldFirstName_2 = new JTextField();
		textFieldFirstName_2.setEditable(false);
		textFieldFirstName_2.setColumns(10);
		textFieldFirstName_2.setBounds(154, 76, 146, 26);
		panel_1.add(textFieldFirstName_2);

		textFieldLastName_2 = new JTextField();
		textFieldLastName_2.setEditable(false);
		textFieldLastName_2.setColumns(10);
		textFieldLastName_2.setBounds(154, 112, 146, 26);
		panel_1.add(textFieldLastName_2);

		textFieldAdress_2 = new JTextField();
		textFieldAdress_2.setEditable(false);
		textFieldAdress_2.setColumns(10);
		textFieldAdress_2.setBounds(154, 151, 146, 26);
		panel_1.add(textFieldAdress_2);

		textFieldPhoneNr_2 = new JTextField();
		textFieldPhoneNr_2.setEditable(false);
		textFieldPhoneNr_2.setColumns(10);
		textFieldPhoneNr_2.setBounds(154, 184, 146, 26);
		panel_1.add(textFieldPhoneNr_2);

		JLabel lblSearchCourse = new JLabel("Search Courses");
		lblSearchCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchCourse.setBounds(742, 11, 116, 19);
		panel_1.add(lblSearchCourse);

		JLabel lblCCode = new JLabel("Course code:");
		lblCCode.setBounds(642, 46, 93, 20);
		panel_1.add(lblCCode);

		JLabel lblCName = new JLabel("Course name:");
		lblCName.setBounds(642, 82, 99, 20);
		panel_1.add(lblCName);

		JLabel lblInsti = new JLabel("Institution:");
		lblInsti.setBounds(642, 184, 78, 20);
		panel_1.add(lblInsti);

		JLabel lblCManager = new JLabel("Course manager:");
		lblCManager.setBounds(642, 148, 122, 20);
		panel_1.add(lblCManager);

		textFieldCcode_2 = new JTextField();
		textFieldCcode_2.setColumns(10);
		textFieldCcode_2.setBounds(779, 43, 146, 26);
		panel_1.add(textFieldCcode_2);

		textFieldCname_2 = new JTextField();
		textFieldCname_2.setEditable(false);
		textFieldCname_2.setColumns(10);
		textFieldCname_2.setBounds(779, 79, 146, 26);
		panel_1.add(textFieldCname_2);

		textFieldInstitution_2 = new JTextField();
		textFieldInstitution_2.setEditable(false);
		textFieldInstitution_2.setColumns(10);
		textFieldInstitution_2.setBounds(779, 184, 146, 26);
		panel_1.add(textFieldInstitution_2);

		textFieldCmanager_2 = new JTextField();
		textFieldCmanager_2.setEditable(false);
		textFieldCmanager_2.setColumns(10);
		textFieldCmanager_2.setBounds(779, 145, 146, 26);
		panel_1.add(textFieldCmanager_2);

		JLabel lblStudentPoints = new JLabel("Points: ");
		lblStudentPoints.setBounds(336, 79, 69, 20);
		panel_1.add(lblStudentPoints);

		JComboBox<String> comboBoxFindSemester = new JComboBox<String>();
		comboBoxFindSemester.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (controller.getStudent(textFieldPNr_2.getText()) != null) {
					lblStudentPoints.setText("Points: "
							+ controller.sumPoints(textFieldPNr_2.getText(),
									(String) comboBoxFindSemester
											.getSelectedItem()));
				}
			}
		});
		comboBoxFindSemester.setBounds(336, 112, 65, 22);
		panel_1.add(comboBoxFindSemester);

		comboBoxFindSemester.addItem("HT14");
		comboBoxFindSemester.addItem("VT15");
		comboBoxFindSemester.addItem("HT15");
		comboBoxFindSemester.addItem("VT16");
		comboBoxFindSemester.addItem("HT16");
		comboBoxFindSemester.addItem("VT17");
		comboBoxFindSemester.addItem("HT17");

		JButton btnSearchStudent = new JButton("Search");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				lblStudentPoints.setText("Points: ");

				if (textFieldPNr_2.getText() == "") {
					JOptionPane.showMessageDialog(frame,
							"Please enter personal number!", " ", 2);
					textFieldFirstName_2.setText("");
					textFieldLastName_2.setText("");
					textFieldAdress_2.setText("");
					textFieldPNr_2.setText("");
					textFieldPhoneNr_2.setText("");

				} else if (controller.getStudent(textFieldPNr_2.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Student doesn't exist", " ", 2);
					textFieldFirstName_2.setText("");
					textFieldLastName_2.setText("");
					textFieldAdress_2.setText("");
					textFieldPNr_2.setText("");
					textFieldPhoneNr_2.setText("");

				} else {
					Student s = controller.getStudent(textFieldPNr_2.getText());
					textFieldFirstName_2.setText(s.getFirstName());
					textFieldLastName_2.setText(s.getLastName());
					textFieldAdress_2.setText(s.getAdress());
					textFieldPhoneNr_2.setText(s.getPhoneNr());
					lblStudentPoints.setText("Points: "
							+ controller.sumPoints(textFieldPNr_2.getText(),
									(String) comboBoxFindSemester
											.getSelectedItem()));

				}
			}
		});
		btnSearchStudent.setBounds(154, 226, 79, 29);
		panel_1.add(btnSearchStudent);

		JLabel lblPercentagePass = new JLabel("Percentage pass:");
		lblPercentagePass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPercentagePass.setBounds(970, 43, 200, 20);
		panel_1.add(lblPercentagePass);

		JLabel lblPercentageWithA = new JLabel("Percentage with A: ");
		lblPercentageWithA.setBounds(970, 79, 200, 20);
		panel_1.add(lblPercentageWithA);

		JButton btnSearchCourse = new JButton("Search");
		btnSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCcode_2.getText() == "") {
					JOptionPane.showMessageDialog(frame,
							"Please enter Course code!", " ", 2);

					textFieldCname_2.setText("");
					textFieldInstitution_2.setText("");
					textFieldCmanager_2.setText("");
					textFieldCcode_2.setText("");
					textFieldCpoints_2.setText("");

				} else if (controller.getCourse(textFieldCcode_2.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Course doesn't exist", " ", 2);
					textFieldCname_2.setText("");
					textFieldInstitution_2.setText("");
					textFieldCmanager_2.setText("");
					textFieldCcode_2.setText("");
					textFieldCpoints_2.setText("");

				} else {
					Course c = controller.getCourse(textFieldCcode_2.getText());
					textFieldCname_2.setText(c.getcName());
					textFieldInstitution_2.setText(c.getcInstitution());
					textFieldCmanager_2.setText(c.getcManager());
					textFieldCcode_2.setText(c.getcCode());
					textFieldCpoints_2.setText(c.getcPoints());
					lblPercentagePass.setText("Percentage pass: "
							+ controller.percentagePass(c.getcCode()));

					lblPercentageWithA.setText("Percentage with A: "
							+ controller.percentageA(c.getcCode()));
				}

			}
		});
		btnSearchCourse.setBounds(779, 226, 79, 29);
		panel_1.add(btnSearchCourse);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(638, 111, 0, 2);
		panel_1.add(separator_1);

		textFieldCpoints_2 = new JTextField();
		textFieldCpoints_2.setEditable(false);
		textFieldCpoints_2.setColumns(10);
		textFieldCpoints_2.setBounds(779, 112, 146, 26);
		panel_1.add(textFieldCpoints_2);

		JLabel lblCoursePoints = new JLabel("Course points:");
		lblCoursePoints.setBounds(642, 115, 122, 20);
		panel_1.add(lblCoursePoints);

		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMessage.setBounds(315, 336, 261, 20);
		panel_1.add(lblMessage);

		JButton btnFindStudentsLeft = new JButton("Find Students");
		btnFindStudentsLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblMessage.setText("");
				if (textFieldFindCcodeLeft.getText() == "") {
					JOptionPane.showMessageDialog(frame,
							"Please enter Course code!", " ", 2);
					textFieldFindCcodeLeft.setText("");
					dtmLeft.setColumnCount(0);
				} else if (controller.getCourse(textFieldFindCcodeLeft
						.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Course doesn't exist", " ", 2);
					textFieldFindCcodeLeft.setText("");
					dtmLeft.setColumnCount(0);
				} else if (controller.getStudying(
						textFieldFindCcodeLeft.getText()).size() == 0) {

					lblMessage.setText("No students are registered on course");
				}

				else {
					ArrayList<Student> list = controller
							.getStudying(textFieldFindCcodeLeft.getText());
					dtmLeft.setRowCount(0);
					for (Student s : list) {
						String[] row = new String[] { s.getpNr(),
								s.getFirstName(), s.getLastName() };
						dtmLeft.addRow(row);
					}
				}
			}
		});
		btnFindStudentsLeft.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFindStudentsLeft.setBounds(154, 375, 141, 25);
		panel_1.add(btnFindStudentsLeft);

		JLabel label = new JLabel("Course code:");
		label.setBounds(25, 338, 100, 16);
		panel_1.add(label);

		JLabel lblFindStudentsOn = new JLabel("Find students on course");
		lblFindStudentsOn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFindStudentsOn.setBounds(88, 297, 194, 16);
		panel_1.add(lblFindStudentsOn);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 279, 1198, 2);
		panel_1.add(separator_2);

		dtmLeft = new DefaultTableModel();
		String[] leftColumnNames = new String[] { "Personal number",
				"First Name", "Last Name" };
		dtmLeft.setColumnIdentifiers(leftColumnNames);

		textFieldFindCcodeLeft = new JTextField();
		textFieldFindCcodeLeft.setColumns(10);
		textFieldFindCcodeLeft.setBounds(154, 333, 146, 26);
		panel_1.add(textFieldFindCcodeLeft);

		JScrollPane spLeftTable = new JScrollPane();
		spLeftTable.setBounds(15, 423, 485, 251);
		panel_1.add(spLeftTable);
		JTable lefTable = new JTable(dtmLeft);
		spLeftTable.setViewportView(lefTable);

		dtmRight = new DefaultTableModel();
		String[] rightColumnNames = new String[] { "Personal number",
				"First Name", "Last Name", "Grade" };
		dtmRight.setColumnIdentifiers(rightColumnNames);

		JScrollPane spRightTable = new JScrollPane();
		spRightTable.setBounds(667, 423, 485, 251);
		panel_1.add(spRightTable);
		JTable rightTable = new JTable(dtmRight);
		spRightTable.setViewportView(rightTable);

		JLabel label_1 = new JLabel("Course code:");
		label_1.setBounds(754, 338, 100, 16);
		panel_1.add(label_1);

		textFieldFindCCodeRight = new JTextField();
		textFieldFindCCodeRight.setColumns(10);
		textFieldFindCCodeRight.setBounds(883, 333, 146, 26);
		panel_1.add(textFieldFindCCodeRight);

		JButton btnFindStudents = new JButton("Find Students");
		btnFindStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dtmRight.setRowCount(0);

				if (textFieldFindCCodeRight.getText() == "") {
					JOptionPane.showMessageDialog(frame,
							"Please enter Course code!", " ", 2);
					textFieldFindCCodeRight.setText("");
					dtmRight.setRowCount(0);

				} else if (controller.getCourse(textFieldFindCCodeRight
						.getText()) == null) {
					JOptionPane.showMessageDialog(frame,
							"Course doesn't exist", " ", 2);
					textFieldFindCCodeRight.setText("");
					dtmRight.setRowCount(0);

				} else {

					ArrayList<ArrayList> list = controller
							.getAllGrades(textFieldFindCCodeRight.getText());

					for (int i = 0; i < list.get(0).size(); i++) {
						String[] row = new String[] {
								(String) list.get(0).get(i),
								(String) list.get(1).get(i),
								(String) list.get(2).get(i),
								(String) list.get(3).get(i) };
						dtmRight.addRow(row);
					}
				}
			}
		});
		btnFindStudents.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFindStudents.setBounds(883, 375, 141, 25);
		panel_1.add(btnFindStudents);

		JLabel lblFindGradesOn = new JLabel("Find Grades on Course");
		lblFindGradesOn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFindGradesOn.setBounds(804, 295, 194, 16);
		panel_1.add(lblFindGradesOn);

		panel_2 = new JPanel();
		tabbedPane.addTab("Course Stats", null, panel_2, null);
		panel_2.setLayout(null);
		
		String[] coursesColumnNames = new String[] { "Course Code",
				"Course Name", "Percentage Pass"};
		dtmCourses.setColumnIdentifiers(coursesColumnNames);
		
		JScrollPane spCourses = new JScrollPane();
		spCourses.setBounds(40, 57, 996, 525);
		panel_2.add(spCourses);
		JTable courses = new JTable(dtmCourses);
		spCourses.setViewportView(courses);
		
		try {
			dtmCourses.setRowCount(0);
			while(rs.next()){
				String[] courseRow = {rs.getString(1), rs.getString(2), rs.getString(3)};
				dtmCourses.addRow(courseRow);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton btnUpdateTable = new JButton("Update table");
		btnUpdateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmCourses.setRowCount(0);
				rs = controller.getAllCoursesSorted();
				
				try {
					while(rs.next()){
						String[] courseRow = {rs.getString(1), rs.getString(2), rs.getString(3)};
						dtmCourses.addRow(courseRow);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdateTable.setBounds(886, 598, 150, 29);
		panel_2.add(btnUpdateTable);

	}
}
