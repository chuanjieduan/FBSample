package sk.viawebtour.www.domain;


public class VacationForm {

	private String message;

	private String link;

    public VacationForm() {
    }

	public VacationForm(String message, String link) {
		this.message = message;
		this.link = link;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
    
}
