package createSprintdata;

public class CreateSprintTestData {
	
	private String name;
	private String startDate;
	private String endDate;
	private int originBoardId;
	
	public CreateSprintTestData(String name, String startDate, String endDate, int originBoardId) {
		this.name=name;
		this.startDate=startDate;
		this.endDate=endDate;
		this.originBoardId=originBoardId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getOriginBoardId() {
		return originBoardId;
	}
	public void setOriginBoardId(int originBoardId) {
		this.originBoardId = originBoardId;
	}
	
	

}
