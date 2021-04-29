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