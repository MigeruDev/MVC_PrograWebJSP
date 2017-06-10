package Model.VO;

public class EmailVO {

	private String from;
	private String pass;
	private String[] to;
	private String subject;
	private String body;
	
	public EmailVO(){
		
	}
	
	public EmailVO(String from, String pass, String[] to, String subject, String body){
		this.from = from;
		this.pass = pass;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
