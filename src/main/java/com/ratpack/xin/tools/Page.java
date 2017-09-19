package com.ratpack.xin.tools;

public class Page {

	private int totalNumber;
	private int currentPage = 1;
	private int totalPage=1;
	private int start=0;
	private int maxRows;
	
	private String pageType;
	
	private String pageEditStatus;


	public Page(int totalNumber, int maxRows) {
		super();
		this.totalNumber = totalNumber;
		this.maxRows = maxRows;
		this.totalPage = getTotalPage();
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getPageEditStatus() {
		return pageEditStatus;
	}

	public void setPageEditStatus(String pageEditStatus) {
		this.pageEditStatus = pageEditStatus;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.totalPage=getTotalPage();
		this.currentPage=getCurrentPage();
	}

	public int getCurrentPage() {
		if(currentPage>=totalPage){
			this.currentPage=totalPage;
		}else if(currentPage<=0){
			this.currentPage=1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if(currentPage>=totalPage){
			this.currentPage=totalPage;
		}else if(currentPage<=0){
			this.currentPage=1;
		}else{
			this.currentPage = currentPage;
		}
		
		this.start = getStart();
	}

	public int getTotalPage() {
		totalPage = (totalNumber/maxRows + (totalNumber%maxRows==0?0:1));
		return totalPage;
	}

	public int getStart() {
		start = (this.currentPage-1)*maxRows;
		if(start<=0){
			return 0;
		}else {
			return start;
		}
	}


	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
		this.totalPage = getTotalPage();
	}

	@Override
	public String toString() {
		return "{\"page\":[{\"totalNumber\":\"" + totalNumber + "\",\"currentPage\":\"" + currentPage + "\",\"totalPage\":\"" + totalPage
				+ "\",\"start\":\"" + start + "\",\"maxRows\":\"" + maxRows + "\",\"pageType\":\""+pageType+"\",\"pageEditStatus\":\""+pageEditStatus+"\"}]}";//pageEditStatus
	}
	
	
	
	
}
