package com.cos.photogramstart.domain.image;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.cos.photogramstart.domain.subscribe.Subscribe;
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
public class Image { // 이미지는 2명이서 만들 수 없음  / N

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String caption; // 사진 설명
	private String postImageUrl; // 사진을 전송받아서 그 사진을 서버의 특정 폴더에 저장 - db에 그 저장된 경로를 insert(db 자체에 사진을 넣는 것이 아니라 경로를 저장)
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User user; // 이미지를 업로드한 사람, 1명의 사람은 여러개의 이미지 올리기 가능 / 1 , 객체를 db에 저장하게 되면 포린키로 저장이 됨
	
	// 이미지 좋아요, 댓글
	
	private LocalDateTime createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
