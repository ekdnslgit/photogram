package com.cos.photogramstart.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	// 권한이 하나가 아닐 수 있음(Collection 타입 사용하는 이유)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collector = new ArrayList<>(); // 어레이리스트의 부모가 컬렉션
		collector.add(()  -> { return user.getRole();}); // 람다식으로 바꿈, add 안에 함수를 넣는게 목적
		// 자바에서는 매개변수에 함수를 못넣음(함수가 일급객체가 아님), 함수를 들고있는 인터페이스 가능
		return collector;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 비밀번호 만료여부
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
