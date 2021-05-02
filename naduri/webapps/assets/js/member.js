// 중복 확인
	$('#idCheck_btn').on('click', function(){
		$.ajax({
			url : '/naduri/idcheck.do',
			type : 'post',
			data : { m_id : $('#m_id').val() },
			success : function( data ) {
				console.log(data);
				
				// 전달된 결과가 0이면 : 사용 가능
				// 전달된 결과가 1이면 : 사용 불가
				
				if ( data == 0){
					alert("사용 가능한 아이디입니다.");
				} else{
					alert("이미 사용 중인 아이디입니다.");
				}
			}, error : function(){
				console.log("전송 실패!");
			}
		});
	});


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



// 주소 검색
// 참조 API : http://postcode.map.daum.net/guide
function addrSearch() {
    new daum.Postcode({
        oncomplete: function(data) {
            var fullAddr = '';
            var extraAddr = '';
            
            if (data.userSelectedType === 'R') {
                fullAddr = data.roadAddress;
            } else {
                fullAddr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }                 
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }
            $('#zipCode').val(data.zonecode);
            $('#m_address1').val(fullAddr);
            $('#m_address2').focus();
        }
    }).open();
};	
	
	
// 회원 가입 필수 정보 확인 & 비밀번호 일치 확인
function insertMember() {
	$("#memberForm").submit();
}
	
$("#memberForm").submit(function(event){
	if(
		$("#m_pwd1").val() == "" ||
		$("#m_id").val() == "" ||
		$("#m_name").val() == "" ||
		($("#gender_F").val() || $("#gender_M").val() == "") ||
		$("#m_birth").val() == "" ||
		$("#m_phone").val() == "" ||
		$("#m_email").val() == "" ||
		$("#zipCode").val() == "" ||
		$("#m_address1").val() == ""
		)
		 alert("필수 값을 확인해주세요!");
	else if($('#m_pwd1').val() != $('#m_pwd2').val()) alert("비밀번호가 비밀번호 확인 값과 다릅니다.");
	else return;
	event.preventDefault();
});




	// 회원 탈퇴
	function memberDelete(){
		location.href = '/naduri/memberDelete.do';
	}


