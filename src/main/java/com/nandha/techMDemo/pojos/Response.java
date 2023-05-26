package com.nandha.techMDemo.pojos;

import java.util.List;

import lombok.Data;

public class Response {
	private String status;
	private int statusCode;
	private int fetchSize;
	private int pageNumber;
	private int totalRecords;
	private int totalPages;
	private List<String> errorMessages;
	private DebugInfo debugInfo;
	private String uniqueJobId ;
	private String message;
	private String defaultClusterName;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getFetchSize() {
		return fetchSize;
	}
	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public DebugInfo getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(DebugInfo debugInfo) {
		this.debugInfo = debugInfo;
	}
	public String getUniqueJobId() {
		return uniqueJobId;
	}
	public void setUniqueJobId(String uniqueJobId) {
		this.uniqueJobId = uniqueJobId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDefaultClusterName() {
		return defaultClusterName;
	}
	public void setDefaultClusterName(String defaultClusterName) {
		this.defaultClusterName = defaultClusterName;
	}
	
	
}
