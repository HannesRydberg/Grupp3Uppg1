import java.util.ArrayList;

public class Test {

	private static DAL dal = new DAL();

	public static void main(String[] args) {
/*
		Student s2 = new Student();
		s2.setpNr("345");
		s2.setFirstName("Anders");
		s2.setLastName("Andersson");
		s2.setAdress("Storgatan 2245");
		s2.setPhoneNr("67813571");
		*/
		Student s3 = new Student();
		s3.setpNr("456");
		s3.setFirstName("Per");
		s3.setLastName("Persson");
		s3.setAdress("Södergatan 3");
		s3.setPhoneNr("6781589");

		Course c = new Course();
		c.setcCode("321");
		c.setcName("Java");
		c.setcInstitution("ICS");
		c.setcManager("Mats");
		c.setcPoints("2");
		dal.addCourse(c);
		
		dal.addStudent(s3);
/*
		// dal.deleteStudent(s2.getpNr());
*/
		// Hitta en student och dess uppgifter
		/*Student s = dal.getStudent("345");
		if (s != null) {
			System.out.println(s.getFirstName() + " " + s.getLastName());
		} else {
			System.out.println("Kan ej hitta student!");
		}
		*/
		//dal.addStudies("345", "123", "ht15");
		//dal.getCourse("123");
		//System.out.println(c.getcCode() +  " " + c.getcName());
		
		dal.addStudied("345", "123", "B", "ht15");
		dal.addStudied("456", "321", "U", "ht15");
		//if (dal.getGrade("345", "123") != null){
			//System.out.println(dal.getGrade("345", "123"));
	//	}
		
		//dal.deleteStudent("456");
		ArrayList<ArrayList> list = dal.getAllGrades("321");
		for(int i = 0; i < list.get(0).size(); i++){
			System.out.println(list.get(0).get(i));
			System.out.println(list.get(1).get(i));
			System.out.println(list.get(2).get(i)); 
		
		}
	
		System.out.println(dal.percentagePass("321"));
		System.out.println(dal.sumPoints("456", "ht15"));
	}

	/*
	 * (non-Java-doc
	 * 
	 * @see java.lang.Object#Object()
	 */

}