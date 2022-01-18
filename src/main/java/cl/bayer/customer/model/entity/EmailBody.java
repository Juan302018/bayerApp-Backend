package cl.bayer.customer.model.entity;

public class EmailBody {
	private String email;
	private String content;
	private String averageContent;
	private String footerContent;
	private String subject;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	

	public String getAverageContent() {
		return averageContent;
	}

	public void setAverageContent(String averageContent) {
		this.averageContent = averageContent;
	}

	public String getFooterContent() {
		return footerContent;
	}

	public void setFooterContent(String footerContent) {
		this.footerContent = footerContent;
	}
	
	

	@Override
	public String toString() {
		return "EmailBody [email=" + email + ", content=" + content + "\n" + ", averageContent=" + averageContent
				+ "\r\n" + ", footerContent=" + footerContent + ", subject=" + subject + "]";
	}
}
