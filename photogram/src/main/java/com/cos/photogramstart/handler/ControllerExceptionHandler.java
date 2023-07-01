package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.CMRespDto;

@ RestController // 응답을 위해 사용
@ ControllerAdvice // 모든 익셉션을 낚아채기 위해 사용한다
public class ControllerExceptionHandler {

	
	@ExceptionHandler(CustomValidationException.class) // 런타임 익셉션이 발동하는 모든 익셉션을 아래 함수가 감지한다.
	public CMRespDto<?> validationException(CustomValidationException e) { // 제네릭에서 뭘 리턴할지 모르겠으면 <T>자리에 <?>
		return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrorMap()); // 겟에러맵이 <> 안에 들어가는 타입으로 리턴된다
	}
}
