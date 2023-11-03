package com.eng.lgpd.controllers.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrors  extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationErrors() {
		super();
	}

	public ValidationErrors(LocalDate localDate, Integer status, String error, String message, String path) {
		super(localDate, status, error, message, path);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
