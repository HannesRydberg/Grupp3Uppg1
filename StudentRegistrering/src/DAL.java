import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAL {

	private static String connStr = "jdbc:sqlserver://localhost:1433;databaseName=StudentReg;user=sa;password=Password1";
	ArrayList<Studied> list = new ArrayList<Studied>();

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(connStr);
	}

	// public boolean addStudent(String pNr, String firstName, String
	// lastName....)

	public void addStudent(Student s) {
		String query = "INSERT INTO Student values(" + "'" + s.getpNr()
				+ "', '" + s.getFirstName() + "', '" + s.getLastName() + "', '"
				+ s.getAdress() + "', '" + s.getPhoneNr() + "');";

		if (getStudent(s.getpNr()) == null) {
			try {
				Statement statement = getConn().createStatement();
				statement.executeUpdate(query);
				statement.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

	public Student getStudent(String pNr) {

		Student s = new Student();
		String query = "SELECT * FROM Student WHERE pNr = '" + pNr + "'";
		try {
			// execute query

			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);

			rs.next();
			s.setpNr(rs.getString(1));
			s.setFirstName(rs.getString(2));
			s.setLastName(rs.getString(3));
			s.setAdress(rs.getString(4));
			s.setPhoneNr(rs.getString(5));

			statement.close();

			return s;
		}

		catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

	public void deleteStudent(String pNr) {

		String query = "DELETE  FROM Student WHERE pNr = '" + pNr + "'";
		String query2 = "DELETE FROM Studies WHERE pNr = '" + pNr + "'";
		String query3 = "Delete FROM Studied WHERE pNr = '" + pNr + "'";
		try {

			Statement statement = getConn().createStatement();
			statement.executeUpdate(query2);
			statement.executeUpdate(query3);
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void addCourse(Course c) {

		if (getCourse(c.getcCode()) == null) {
			String query = "INSERT INTO Course values('" + c.getcCode()
					+ "', '" + c.getcName() + "', '" + c.getcInstitution()
					+ "', '" + c.getcManager() + "', '" + c.getcPoints() + "')";
			try {
				Statement statement = getConn().createStatement();
				statement.executeUpdate(query);
				statement.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

	public Course getCourse(String cCode) {
		Course c = new Course();

		String query = "SELECT * FROM Course WHERE cCode = '" + cCode + "'";
		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);

			rs.next();
			c.setcCode(rs.getString(1));
			c.setcName(rs.getString(2));
			c.setcInstitution(rs.getString(3));
			c.setcManager(rs.getString(4));
			c.setcPoints(rs.getString(5));

			statement.close();

			return c;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public void deleteCourse(String cCode) {

		String query = "DELETE  FROM Course WHERE cCode = '" + cCode + "'";
		String query2 = "DELETE FROM Studies WHERE cCode = '" + cCode + "'";
		String query3 = "Delete FROM Studied WHERE cCode = '" + cCode + "'";
		try {
			Statement statement = getConn().createStatement();
			statement.executeUpdate(query2);
			statement.executeUpdate(query3);
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void addStudied(String pNr, String cCode, String grade,
			String semester) {
		String query = "INSERT INTO Studied values('" + pNr + "', '" + cCode
				+ "', '" + grade + "', '" + semester + "')";
		try {
			Statement statement = getConn().createStatement();
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public ArrayList<Student> getStudied(String cCode) {
		ArrayList<Student> studentList = new ArrayList<Student>();

		String query = "SELECT pNr FROM Studied WHERE cCode = '" + cCode + "'";

		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				studentList.add(getStudent(rs.getString(1)));
			}

			return studentList;

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public void addStudies(String pNr, String cCode, String semester) {
		String query = "INSERT INTO Studies values('" + pNr + "', '" + cCode
				+ "', '" + semester + "')";
		try {
			Statement statement = getConn().createStatement();
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public String getGrade(String pNr, String cCode) {
		String query = "SELECT grade FROM Studied WHERE pNr ='" + pNr + "'"
				+ " and cCode = '" + cCode + "'";

		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();

			return rs.getString(1);

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Student> getStudying(String cCode) {
		ArrayList<Student> studentList = new ArrayList<Student>();

		String query = "SELECT pNr FROM Studies WHERE cCode = '" + cCode + "'";

		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				studentList.add(getStudent(rs.getString(1)));
			}

			return studentList;

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public String percentagePass(String cCode) {
		String query = "SELECT grade FROM studied WHERE cCode = '" + cCode
				+ "'";
		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			int size = 0;
			int fail = 0;
			while (rs.next()) {
				size++;
				if (rs.getString(1).equals("U")) {
					fail++;
				}
			}
			if (size == 0) {
				return "0";
			} else {
				double percentage = ((size - fail) / (double) size) * 100;
				// String p = String.format("%.2", percentage);
				return percentage + "%";
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

	public String percentageA(String cCode) {
		String query = "SELECT grade FROM studied WHERE cCode = '" + cCode
				+ "'";
		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			int size = 0;
			int a = 0;
			while (rs.next()) {
				size++;
				if (rs.getString(1).equals("A")) {
					a++;
				}
			}
			if (size == 0) {
				return "0";
			} else {
				double percentage = (a / (double) size) * 100;
				return percentage + "%";
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;

	}

	public ArrayList<ArrayList> getAllGrades(String cCode) {
		ArrayList<ArrayList> list = new ArrayList<ArrayList>();
		ArrayList<String> pNrList = new ArrayList<String>();
		ArrayList<String> firstNameList = new ArrayList<String>();
		ArrayList<String> lastNameList = new ArrayList<String>();
		ArrayList<String> gradeList = new ArrayList<String>();

		String query = "SELECT * FROM Studied WHERE cCode = '" + cCode + "'";

		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Student s = getStudent(rs.getString(1));
				pNrList.add(s.getpNr());
				firstNameList.add(s.getFirstName());
				lastNameList.add(s.getLastName());
				gradeList.add(rs.getString(3));
			}
			list.add(pNrList);
			list.add(firstNameList);
			list.add(lastNameList);
			list.add(gradeList);
			return list;

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public void deleteStudying(String pNr, String cCode) {
		String query = "DELETE FROM Studies WHERE pNr = '" + pNr + "'"
				+ " AND cCode = '" + cCode + "'";
		try {
			Statement statement = getConn().createStatement();
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void deleteStudied(String pNr, String cCode) {
		String query = "DELETE FROM Studied WHERE pNr = '" + pNr + "'"
				+ " AND cCode = '" + cCode + "'";
		try {
			Statement statement = getConn().createStatement();
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public int sumPoints(String pNr, String semester) {
		String query = "SELECT cPoints FROM Course c WHERE c.cCode IN (SELECT h.cCode from studied h WHERE h.pNr = '"
				+ pNr + "' AND h.semester = '" + semester + "')";
		int sum = 0;
		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next())
				sum += rs.getInt(1);

			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return sum;

	}

	public ArrayList<String> getAllCourses() {
		ArrayList<String> cList = new ArrayList<String>();
		String query = "SELECT cCode FROM Course";

		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next())
				cList.add(rs.getString(1));

		} catch (SQLException e) {
			System.out.println(e);
		}
		return cList;
	}

	public ResultSet getAllCoursesSorted() {

		String query = "SELECT studied.cCode, Course.cName, (SUM(CASE WHEN studied.grade !='u' " +
				"THEN 1 ELSE 0 END)) * 100 / " +
				"(SUM (CASE WHEN studied.grade LIKE '_' THEN 1 " +
				"ELSE 0 END)) AS passedPercentage " +
				 "FROM studied " +
				"JOIN Course " +
				 "ON studied.cCode = course.cCode " + 
				 "GROUP BY studied.cCode, course.cName " +
				  "ORDER BY passedPercentage DESC";


		try {
			Statement statement = getConn().createStatement();
			ResultSet rs = statement.executeQuery(query);
			return rs;

		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
