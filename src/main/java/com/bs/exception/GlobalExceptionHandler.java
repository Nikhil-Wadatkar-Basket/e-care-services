package com.bs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MyRuntimeException.class)
	public ModelAndView getExceptionDetails(MyRuntimeException exception, ErrorInfo errorInfo) {
		System.out.println("GlobalExceptionHandler.getExceptionDetails()");
		ModelAndView mav = new ModelAndView("FailureMessage");

		System.out.println(errorInfo);
//		mav.addObject("errorInfo", errorInfo);
		return mav;
	}

	private ErrorInfo getErrorInfo(RuntimeException exception) {
		ErrorInfo errorInfo = new ErrorInfo();

		String message = exception.getMessage();

		errorInfo.setClassName(null);
		errorInfo.setMethodName(null);
		errorInfo.setExceptionMessage(null);
		return errorInfo;
	}
}