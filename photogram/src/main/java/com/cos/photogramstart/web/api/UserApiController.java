package com.cos.photogramstart.web.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController  // api controller는 전부 레스트 컨트롤러다.(데이터 응답), 제이쿼리는 데이터로 응답.
public class UserApiController {

	private final UserService userService;
	
	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(
			@PathVariable int id,
			@ Valid UserUpdateDto userUpdateDto, 
			BindingResult bindingResult, // 위에서 문제가 생기면 아래에 담는다. 꼭 @Vaild가 적혀있는 다음 파라미터에 적어야함
			@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		if(bindingResult.hasErrors()) { // 뒤쪽에서 부적절한 접근을 막는 수단.
			Map<String, String> errorMap = new HashMap<>(); 
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println(error.getDefaultMessage());
			}
			throw new CustomValidationApiException("유효성 검사 실패함", errorMap);
			// @Authentication 세션 정보에 접근하는 방법, 이 부분을 추가해줘야 성별을 남 으로 바꾸면 값이 웹에 남게된다.
		} else {
			 User userEntity= userService.회원수정(id, userUpdateDto.toEntity());
			 principalDetails.setUser(userEntity); // 세션 정보 변경
			return new CMRespDto<>(1, "회원수정완료", userEntity);
		}
	}
}
