package mm.survey.webapp.model;

import java.util.List;

public class Stats {

	private int total;
	private List<String> emails;

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
