package com.bs.exception;

import com.bs.beans.ErrorInfo;

public class MyRuntimeException extends RuntimeException {

	public MyRuntimeException(String message) {
		super(message);
	}

}
