public class Studied {

	private String pNr;
	private String cCode;
	private String grade;
	private String semester;
	
	public Studied (String pNr, String cCode, String grade, String semester){
		
		this.pNr = pNr;
		this.cCode = cCode;
		this.grade = grade;
		this.semester = semester;
		
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getpNr() {
		return pNr;
	}

	public void setpNr(String pNr) {
		this.pNr = pNr;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
