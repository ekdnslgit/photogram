package com.cos.photogramstart.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( // 중복 구독하기 방지
		uniqueConstraints = {
				@UniqueConstraint(
						name="subscribe_uk",
						columnNames = {"fromUserId", "toUserId"} // 실제 데이터베이스의 열 이름을 적는다.
				)
		}
)
public class Subscribe { // 중간테이블

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	// 모델만들기
	
	@JoinColumn(name = "fromUserId") // 데이터베이스 테이블의 열을 생성할 때 자동이 아닌 직접 이름을 부여
	@ManyToOne // 유저가 1이고 구독하기가 다수
	private User fromUser; // 구독하기
	
	@JoinColumn(name = "toUserId")
	@ManyToOne // 유저가 1이고 구독받기가 다수
	private User toUser; // 구독받기
	
	
	private LocalDateTime createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
