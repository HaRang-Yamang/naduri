// 비밀번호 유효성 체크

$('#memberForm').submit(function(event){
	var pwd = $('#m_pwd1').val();
	var pwd2 = $('#m_pwd2').val();
	
	if( pwd != pwd2 ){
		$('#pwdValidate').text('비밀번호와 확인 값이 일치하지 않습니다!')
						.show();
		
	} else if( pwd == ''){
		$('#pwdValidate').text('비밀번호를 반드시 입력해주세요!')
						.show();
	} else {
		return;
	}
	
	event.preventDefault();
});



// 이메일 선택

function emailSelect(e){
	var m_email = e.email_select.selectedIndex;
	
	switch(m_email){
		case 0 :
			e.m_email.value = '직접 입력하세요.';
			break;
		case 1 :
			e.m_email.value = '@gmail.com';
			break;
		case 2 :
			e.m_email.value = '@gmail.com';
			break;
		case 3 :
			e.m_email.value = '@gmail.com';
			break;
		case 4 :
			e.m_email.value = '@gmail.com';
			break;
		case 5 :
			e.m_email.value = '@gmail.com';
			break;
		case 6 :
			e.m_email.value = '@gmail.com';
			break;
	}
	
	return true;
}






