
public class Studying {
	
	private String pNr;
	private String cCode;
	private String semester;
	
	public Studying(String pNr, String cCode, String semester){
		
		this.pNr = pNr;
		this.cCode = cCode;
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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	

}
