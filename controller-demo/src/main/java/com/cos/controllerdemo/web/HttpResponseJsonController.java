package com.cos.controllerdemo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.controllerdemo.domain.User;

@RestController
public class HttpResponseJsonController {

		@GetMapping("/resp/json")
		public String respJason() {
			return "{\"username:\"cos\"}";
		}
		
		@GetMapping("/resp/json/object")
		public User respJasonObject() {
			User user = new User();
			user.setUsername("홍길동");
			return user;
		}
		
		@GetMapping("/resp/json/javaobject")
		public User respJasonJavaObject() {
			User user = new User();
			user.setUsername("홍길동");
			return user; //1. MessageConverter가 자동으로 자바오브젝트를 Json(구: xml)으로 변경해서 통신을 통해 응답을 해준다.
						 // 2. @RestController 일때만 MessageConverter가 작동한다.
		}
}
