package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;

@ RestController // 응답을 위해 사용
@ ControllerAdvice // 모든 익셉션을 낚아채기 위해 사용한다
public class ControllerExceptionHandler {

	
	@ExceptionHandler(CustomValidationException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
	public Map<String, String> validationException(CustomValidationException e) {
		return e.getErrorMap();
	}
}
