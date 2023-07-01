package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;

@ RestController // 응답을 위해 사용
@ ControllerAdvice // 모든 익셉션을 낚아채기 위해 사용한다
public class ControllerExceptionHandler {

	
	@ExceptionHandler(CustomValidationException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
	public String validationException(CustomValidationException e) { // 제네릭에서 뭘 리턴할지 모르겠으면 <T>자리에 <?>
	// CMRespDto, Script 비교
	// 1. 클라이언트에게 응답할 때는 스크립트가 좋다.
	// 2. Ajax 통신 - 씨알엠이 좋다.
	// 3. 안드로이드 통신 -씨알엠이 좋다.
		return Script.back(e.getErrorMap().toString());
		
		
		// return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrorMap()); // 겟에러맵이 <> 안에 들어가는 타입으로 리턴된다
	}
}
