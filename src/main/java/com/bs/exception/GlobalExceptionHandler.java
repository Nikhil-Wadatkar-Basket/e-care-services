package com.bs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.bs.beans.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MyRuntimeException.class)
	public ModelAndView getExceptionDetails(MyRuntimeException exception) {
		System.out.println("GlobalExceptionHandler.getExceptionDetails()");
		ModelAndView mav = new ModelAndView("FailureMessage");

		System.out.println(exception.getMessage());
		ErrorInfo errorInfo = getErrorInfo(exception);
		
		
		mav.addObject("className", errorInfo.getClassName());
		mav.addObject("methodName", errorInfo.getMethodName());
		mav.addObject("lineNumber", errorInfo.getLineNUmber());
		mav.addObject("exceptionMessage", errorInfo.getExceptionMessage());
		return mav;
	}

	private ErrorInfo getErrorInfo(RuntimeException exception) {
		ErrorInfo errorInfo = new ErrorInfo();

		String[] message = exception.getMessage().split("_");

		errorInfo.setClassName(message[0]);
		errorInfo.setMethodName(message[1]);
		errorInfo.setLineNUmber(Integer.parseInt(message[2]));
		errorInfo.setExceptionMessage(message[3]);
		return errorInfo;
	}
}