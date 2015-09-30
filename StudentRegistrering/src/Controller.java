import java.sql.ResultSet;
import java.util.ArrayList;

public class Controller {

	private DAL dal = new DAL();

	public void addStudent(Student s) {
		dal.addStudent(s);
	}

	public Student getStudent(String pNr) {

		return dal.getStudent(pNr);

	}

	public void deleteStudent(String pNr) {
		dal.deleteStudent(pNr);
	}

	public void addCourse(Course c) {
		dal.addCourse(c);
	}

	public Course getCourse(String cCode) {
		return dal.getCourse(cCode);
	}

	public void deleteCourse(String cCode) {
		dal.deleteCourse(cCode);
	}

	public void addStudied(String pNr, String cCode, String grade,
			String semester) {
		dal.addStudied(pNr, cCode, grade, semester);
	}

	public ArrayList<Student> getStudied(String cCode) {
		return dal.getStudied(cCode);
	}

	public void addStudies(String pNr, String cCode, String semester) {
		dal.addStudies(pNr, cCode, semester);
	}

	public String getGrade(String pNr, String cCode) {
		return dal.getGrade(pNr, cCode);

	}

	public ArrayList<Student> getStudying(String cCode) {
		return dal.getStudying(cCode);
	}

	public String percentagePass(String cCode) {
		return dal.percentagePass(cCode);
	}

	public ArrayList<ArrayList> getAllGrades(String cCode) {
		return dal.getAllGrades(cCode);
	}

	public void deleteStudying(String pNr, String cCode) {
		dal.deleteStudying(pNr, cCode);
	}

	public void deleteStudied(String pNr, String cCode) {
		dal.deleteStudied(pNr, cCode);
	}

	public int sumPoints(String pNr, String semester) {
		return dal.sumPoints(pNr, semester);

	}

	public String percentageA(String cCode) {
		return dal.percentageA(cCode);
	}

	public ArrayList<String> getAllCourses() {
		return dal.getAllCourses();
	}

	public ResultSet getAllCoursesSorted(){
		return dal.getAllCoursesSorted();
	}

}
