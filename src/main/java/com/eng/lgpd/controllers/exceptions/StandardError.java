package com.eng.lgpd.controllers.exceptions;

import java.io.Serializable;
import java.time.LocalDate;

public class StandardError  implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDate timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(LocalDate localDate, Integer status, String error, String message, String path) {
		super();
		this.timestamp = localDate;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
