package com.TechFiesta.htreport.helper;



public class ServerResponse {

	String jObj;
	int status;

	public ServerResponse() {
		// TODO Auto-generated constructor stub
	}

	public ServerResponse(String jObj, int status) {
		this.jObj = jObj;
		this.status = status;
	}

	public String getjObj() {
		return jObj;
	}

	public void setjObj(String jObj) {
		this.jObj = jObj;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
