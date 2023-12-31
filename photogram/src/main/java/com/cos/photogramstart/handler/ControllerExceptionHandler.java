package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.handler.ex.CustomException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@ RestController // 응답을 위해 사용
@ ControllerAdvice // 모든 익셉션을 낚아채기 위해 사용한다
public class ControllerExceptionHandler {

	
	@ExceptionHandler(CustomValidationException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
	public String validationException(CustomValidationException e) { // 제네릭에서 뭘 리턴할지 모르겠으면 <T>자리에 <?>
	// CMRespDto, Script 비교
	// 1. 클라이언트에게 응답할 때는 스크립트가 좋다.
	// 2. Ajax 통신 - 씨알엠이 좋다.
	// 3. 안드로이드 통신 -씨알엠이 좋다.
		
		if(e.getErrorMap() == null) {
			return Script.back(e.getMessage());
			
		} else {
			return Script.back(e.getErrorMap().toString());
		}
	}
		// 자바스크립트 응답
		
		@ExceptionHandler(CustomException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
		public String exception(CustomException e) { // 제네릭에서 뭘 리턴할지 모르겠으면 <T>자리에 <?>
			return Script.back(e.getMessage());
		}
	
	@ExceptionHandler(CustomValidationApiException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
	public ResponseEntity<?> apiException(CustomValidationApiException e) { 
		// 제네릭에서 뭘 리턴할지 모르겠으면 <T>자리에 <?>
		// CMRespDto<?> : http 상태 코드를 던진다.
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST); // body와 상태코드를 순서대로 넣는다
	}
	
	@ExceptionHandler(CustomApiException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
	public ResponseEntity<?> apiException(CustomApiException e) { 
		// 제네릭에서 뭘 리턴할지 모르겠으면 <T>자리에 <?>
		// CMRespDto<?> : http 상태 코드를 던진다.
		
		 return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST); // body와 상태코드를 순서대로 넣는다
	 }
	
}
