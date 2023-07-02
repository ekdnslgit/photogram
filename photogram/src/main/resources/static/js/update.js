// (1) 회원정보 수정
function update(userId) {
	
	let data = $("#profileUpdate").serialize(); // 헤더에 제이쿼리를 정의해놓았기 떄문에 쓸 수 있음 profileUpdate는 id(update.jsp의 프로필 수정 영역)값을 의미함
	// 이 폼태그를 잦아서 이 폼테그가 들고있는 모든 인포값들을 시리얼라이즈하면 데이터에 담긴다.
	
	console.log(data);
	
	$.ajax({
		type : "put",
		url : '/api/user/${userId}',
		data : data,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
		
	}).done(res=> { // "json"을 파싱해서 받는다. res는 자바스크립트 오브젝트가 된다.
		console.log("update 성공");
	}).fail(error=> {
		console.log("update 실패");
	});
}