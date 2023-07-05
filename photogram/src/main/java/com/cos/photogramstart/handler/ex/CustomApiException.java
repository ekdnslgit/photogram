package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomApiException extends RuntimeException {

	private static final long serialVersionUID = 1L; // 클래스명에 마우스를 올리고 id 써져있는 것 체크
	
	public CustomApiException(String message) {
		super(message);
	}
	
}
