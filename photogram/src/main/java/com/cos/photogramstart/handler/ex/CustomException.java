package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomException extends RuntimeException {

	// 객체를 구분할 때 쓴다.
	private static final long serialVersionUID = 1L; // 클래스명에 마우스를 올리고 id 써져있는 것 체크
	
	
	public CustomException(String message) {
		super(message); // 부모한테 던진다
	}

}
