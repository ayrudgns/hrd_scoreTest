function valid_check() {
	const frm = document.forms[0];

	const stu_id = frm.stu_id;
	const name = frm.name;
	const dept = frm.dept;
	const tel = frm.tel;
	let isValid = true;
	
	if(stu_id.value == '') {
		alert('학번은 필수 입력 사항입니다.');
		isValid = false;
	}
	
	if(name.value == '') {
		alert('이름은 필수 입력 사항입니다.');
		isValid = false;
	}

	if(dept.value == '') {
		alert('학과는 필수 입력 사항입니다.');
		isValid = false;
	}
		
	let regex =  /^010-[0-9]{4}-[0-9]{4}$/
	if(regex.test(tel.value) === false) {
		if(tel.value == '') {
			alert('핸드폰 번호는 필수 입력 사항입니다.');
			isValid = false;
		}
		alert('올바른 핸드폰 번호 형식이 아닙니다.');
		isValid = false;
	}	
    
    if(isValid){
		alert('유효한 정보입니다. 학생 등록 성공!');
      	frm.submit()
    } else{

    }
}

function valid_check2() {
	const frm = document.forms[0];

	const stu_id = frm.stu_id;
	const jumsu = frm.jumsu;
	let isValid = true;

	if(stu_id.value == '') {
		alert('학번은 필수 입력 사항입니다.');
		isValid = false;
	}
	
	if(jumsu.value == '' || (jumsu.value > 100 || jumsu.value < 0)) {
		alert('점수는 필수 입력 사항이며, 범위는 0 ~ 100 의 정수입니다.');
		isValid = false;		
	}
	
	if(isValid){
      	frm.submit();
    } else {

    }
}

function valid_check3() {
	const frm = document.forms[0];
	
	const stu_id = frm.stu_id;
	let isValid = true;
	
	if(stu_id.value == '') {
		alert('학번을 입력하세요.');
		isValid = false;
	}
	
	if(isValid) {
		frm.submit();
	}
}