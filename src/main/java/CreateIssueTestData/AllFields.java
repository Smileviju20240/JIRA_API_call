package CreateIssueTestData;

public class AllFields {

	private Project project;
	private String summary;
	private String description;
	private IssueTypes issuetype;

	
	public AllFields(Project project, IssueTypes issuetype, String summary, String description) {
		this.project = project;
		this.issuetype = issuetype;
		this.summary = summary;
		this.description = description;
	}
	
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueTypes getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(IssueTypes issuetype) {
		this.issuetype = issuetype;
	}

}
